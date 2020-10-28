package io.haicheng.cfundtool.job;

import io.haicheng.cfundtool.api.XueQiuApi;
import io.haicheng.cfundtool.api.response.XueQiuResponse;
import io.haicheng.cfundtool.api.response.XueQiuResponseIndustries;
import io.haicheng.cfundtool.api.response.XueQiuResponseStocks;
import io.haicheng.cfundtool.pojo.Stock;
import io.haicheng.cfundtool.service.StockService;
import io.haicheng.cfundtool.utils.DateTimeUtil;
import java.util.HashMap;
import java.util.Map;
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
public class XueqiuJob {


    @Autowired
    StockService stockService;

    @Scheduled(cron = "* */55  * * * ?")
    public void cronJob() {
        log.info(">>>>>>>>>>>>>>>>>>> 雪球股票数据 @{}", DateTimeUtil.getCurrentDateTimeStr());
        run();
    }

    private void run() {

        try {
            XueQiuResponse<XueQiuResponseIndustries> industry = XueQiuApi.getIndustries();
            XueQiuResponseIndustries industryData = industry.getData();
            Map<String, String> industryMap = new HashMap<>();
            industryData.getIndustries().forEach(i -> {
                industryMap.put(i.getEncode(), i.getName());
            });

            Integer pageSize = 100;
            XueQiuResponse<XueQiuResponseStocks> responseConfig = XueQiuApi.getStocks(1, pageSize);

            XueQiuResponseStocks dataCongfig = responseConfig.getData();
            Integer totalCount = dataCongfig.getCount();
            Double pageCountDouble = Math.ceil(totalCount / pageSize);
            Integer pageCount = pageCountDouble.intValue();
            for (Integer i = 1; i <= pageCount; i++) {
                XueQiuResponse<XueQiuResponseStocks> response = XueQiuApi.getStocks(i, pageSize);
                XueQiuResponseStocks responseData = response.getData();
                responseData.getList().forEach(stock -> {
                    log.info("### {}", stock);
                    Stock stockSave = new Stock();
                    stockSave.setName(stock.getName());
                    stockSave.setCode(stock.getSymbol());
                    stockSave.setIndustryCode((null == stock.getIndcode()) ? "" : stock.getIndcode());
                    stockSave.setIndustryName(industryMap.containsKey(stockSave.getIndustryCode()) ? industryMap.get(
                            stockSave.getIndustryCode()) : "");
                    stockSave.setPeLyr(stock.getPelyr());
                    stockSave.setPeTtm(stock.getPettm());
                    stockSave.setPeDynamic(0.00);
                    stockSave.setPb(stock.getPb());
                    stockService.save(stockSave);
                });
            }
        } catch (Exception e) {
            log.error("{}", e.getMessage());
        }


    }

}
