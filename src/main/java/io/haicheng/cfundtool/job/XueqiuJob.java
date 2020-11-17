package io.haicheng.cfundtool.job;

import io.haicheng.cfundtool.api.XueQiuApi;
import io.haicheng.cfundtool.api.response.XueQiuResponse;
import io.haicheng.cfundtool.api.response.XueQiuResponseIndustries;
import io.haicheng.cfundtool.api.response.XueQiuResponseStocks;
import io.haicheng.cfundtool.pojo.Stock;
import io.haicheng.cfundtool.service.StockService;
import io.haicheng.cfundtool.utils.DateTimeUtil;
import java.util.Arrays;
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

    @Scheduled(cron = "* */30  * * * ?")
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
                    String IndustryName = industryMap.containsKey(stockSave.getIndustryCode()) ? industryMap.get(
                            stockSave.getIndustryCode()) : "";
                    stockSave.setIndustryName(IndustryName);
                    stockSave.setPeLyr(stock.getPelyr());
                    stockSave.setPeTtm(stock.getPettm());
                    stockSave.setPeDynamic(0.00);
                    stockSave.setPb(stock.getPb());
                    stockSave.setNetprofit(stock.getNetprofit());
                    stockSave.setIa(stock.getIa());
                    stockSave.setTa(stock.getTa());
                    stockSave.setGoodwill(stock.getGoodwill());
                    Double pbScore = 0.00;
                    Double peScore = 0.00;
                    if(stock.getPb() > 0 && stock.getPb() < 1.5 && stock.getPettm() < 20 && stock.getPettm() > 0){
                        if (Arrays.asList("普钢", "特种钢", "钢加工区域地产", "房地产", "银行", "煤炭开采", "公路", "路桥", "水力发电", "火力发电", "新型电力",
                                "房地产开发", "高速公路", "钢铁").contains(IndustryName)) {
                            pbScore = 0.6 / stock.getPb() * 100;
                            peScore = 6 / stock.getPettm() * 100;
                        } else {
                            pbScore = 1 / stock.getPb() * 100;
                            peScore = 10 / stock.getPettm() * 100;
                        }
                    }
                    stockSave.setPbScore(pbScore);
                    stockSave.setPeScore(peScore);
                    stockSave.setScore(pbScore + peScore);
                    stockService.save(stockSave);
                });
            }
        } catch (Exception e) {
            log.error("{}", e.getMessage());
        }


    }

}
