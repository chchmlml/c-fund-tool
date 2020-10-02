package io.haicheng.cfundtool.job;

import cn.hutool.http.HttpUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.haicheng.cfundtool.pojo.Index;
import io.haicheng.cfundtool.pojo.IndexDailyReport;
import io.haicheng.cfundtool.service.IndexDailyReportService;
import io.haicheng.cfundtool.service.IndexService;
import io.haicheng.cfundtool.utils.DateTimeUtil;
import io.haicheng.cfundtool.utils.JsonUtil;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * <p>Title: DanJuanFundsJob</p>
 * <p>Description: </p>
 *
 * @author haicheng
 * @Email haicheng@staff.weibo.com
 * @date 2020/9/30 4:50 下午
 */
@Slf4j
@Component
public class DanJuanFundsJob {

    private final static String url = "https://danjuanfunds.com/djapi/fundx/activity/user/vip_valuation/show/detail?source=lsd";

    @Autowired
    IndexService indexService;

    @Autowired
    IndexDailyReportService indexDailyReportService;

    @Scheduled(cron = "*/60  * * * * ?")
    public void cronJob() {
        log.info(">>>>>>>>>>>>>>>>>>> 蛋卷基金数据 @{}", DateTimeUtil.getCurrentDateTimeStr());
        run();
    }

    private void run() {
        String result = HttpUtil.get(url);
        DanjuanData data = JsonUtil.string2Obj(result, DanjuanData.class);
        if (data.resultCode.equals(0)) {
            List<Valuations> valuations = data.getData().getValuations();
            valuations.forEach(v -> {
                //更新指数
                Index index = new Index();
                index.setName(v.getIndexName());
                index.setCode(v.getIndexCode());
                indexService.saveByCode(index);
                //更新指数数据
                IndexDailyReport report = new IndexDailyReport();
                if(null != data.data.getTime()){
                    report.setDate(data.data.getTime());
                }

                report.setIndexId(index.getId());
                report.setIndexCode(index.getCode());

                if(null != v.getProfitYield()){
                    report.setEp(v.getProfitYield());
                } else if(null != v.getPe()){
                    String pe = String.format("%.4f", 1 / v.getPe());
                    report.setEp(Double.valueOf(pe));
                } else {
                    report.setEp(0.0);
                }

                if(null != v.getPe()){
                    report.setPe(v.getPe());
                } else {
                    report.setPe(0.0);
                }

                if(null != v.getPb()){
                    report.setPb(v.getPb());
                } else {
                    report.setPb(0.0);
                }

                if(null != v.getDividendYield()){
                    report.setDyr(v.getDividendYield());
                } else {
                    report.setDyr(0.0);
                }

                if(null != v.getRoe()){
                    report.setRoe(v.getRoe());
                } else {
                    report.setRoe(0.0);
                }
                indexDailyReportService.save(report);
            });
        }
    }

    @lombok.Data
    public static class Valuations {

        private Integer id;

        @JsonProperty(value = "relation_id")
        private Integer relationId;
        /**
         * 指数估值说明： 1：估值较低，适合开始定投的品种 2：估值适中，可以观望 3：估值较高，谨慎投资
         */

        @JsonProperty(value = "valuation_status")
        private String valuationStatus;
        /**
         * 指数名称
         */
        @JsonProperty(value = "index_name")
        private String indexName;
        /**
         * 指数代码
         */
        @JsonProperty(value = "index_code")
        private String indexCode;
        /**
         * 市盈率
         */
        private Double pe;
        /**
         * 市净率
         */
        private Double pb;
        /**
         * 场内基金
         */
        @JsonProperty(value = "inside_fund")
        private String insideFund;

        /**
         * 场外基金
         */
        @JsonProperty(value = "outside_fund")
        private String outsideFund;
        /**
         * 净资产收益率
         */
        private Double roe;
        /**
         * 股息率
         */
        @JsonProperty(value = "dividend_yield")
        private Double dividendYield;
        /**
         * 盈利收益率
         */
        @JsonProperty(value = "profit_yield")
        private Double profitYield;
    }

    @lombok.Data
    public static class Data {

        private Integer id;
        private String periods;
        private String status;
        private String time;
        private String comment;
        private String grade;
        private List<Valuations> valuations;
    }

    @lombok.Data
    public static class DanjuanData {

        private Data data;
        @JsonProperty(value = "result_code")
        private Integer resultCode;
    }
}
