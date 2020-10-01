package io.haicheng.cfundtool.job;

import cn.hutool.http.HttpUtil;
import io.haicheng.cfundtool.mapper.FundMapper;
import io.haicheng.cfundtool.pojo.Index;
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
    FundMapper fundMapper;

    @Autowired
    IndexService indexService;

    @Scheduled(cron = "*/5 * * * * ?")
    public void cronJob() {
        log.info(">>>>>>>>>>>>>>>>>>> 蛋卷基金数据 @{}", DateTimeUtil.getCurrentDateTimeStr());
        run();
    }

    private void run() {
        String result = HttpUtil.get(url);
        DanjuanData data = JsonUtil.string2Obj(result, DanjuanData.class);
        if (data.result_code.equals(0)) {
            List<Valuations> valuations = data.getData().getValuations();
            valuations.forEach(v -> {
                Index index = new Index();
                index.setName(v.getIndex_name());
                index.setCode(v.getIndex_code());
                indexService.saveByCode(index);
            });
        }
    }

    @lombok.Data
    public static class Valuations {

        private Integer id;
        private Integer relation_id;
        /**
         * 指数估值说明： 1：估值较低，适合开始定投的品种 2：估值适中，可以观望 3：估值较高，谨慎投资
         */
        private String valuation_status;
        /**
         * 指数名称
         */
        private String index_name;
        /**
         * 指数代码
         */
        private String index_code;
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
        private String inside_fund;

        /**
         * 场外基金
         */
        private String outside_fund;
        /**
         * 净资产收益率
         */
        private Double roe;
        /**
         * 股息率
         */
        private Double dividend_yield;
        /**
         * 盈利收益率
         */
        private Double profit_yield;
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
        private Integer result_code;
    }
}
