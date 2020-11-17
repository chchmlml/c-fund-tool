package io.haicheng.cfundtool.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Title: DanJuanFundsJob
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author haicheng
 * @Email haicheng@staff.weibo.com
 * @date 2020/9/30 4:50 下午
 */
@Slf4j
@Component
public class DanJuanFundsJob {

//    @Autowired
//    FundService fundService;
//
//    @Autowired
//    IndexService indexService;
//
//    @Autowired
//    IndexDailyReportService indexDailyReportService;
//
//    @Scheduled(cron = "* */60  * * * ?")
//    public void cronJob() {
//        log.info(">>>>>>>>>>>>>>>>>>> 蛋卷基金数据 @{}", DateTimeUtil.getCurrentDateTimeStr());
//        run();
//    }
//
//    private void run() {
//        DanjuanResponse<DanjuanResponseValuations> response = DanjuanApi.getIndexCollect();
//        if (response.getResultCode().equals(0)) {
//            List<Valuations> valuations = response.getData().getValuations();
//            valuations.forEach(v -> {
//                // 更新基金
//                if (null != v.getOutsideFund()) {
//
//                    Fund fundResponse = fundService.getFundByOutsideFund(v.getOutsideFund());
//                    if (null == fundResponse) {
//                        DanjuanResponse<DanjuanResponseFund> responseFund = DanjuanApi
//                                .getFundDetail(v.getOutsideFund());
//
//                        if (responseFund.getResultCode().equals(0)) {
//                            Fund fund = new Fund();
//                            fund.setFundName((null != responseFund.getData().getFdFullName())
//                                    ? responseFund.getData().getFdFullName()
//                                    : "");
//                            fund.setOutsideFund((null != v.getOutsideFund()) ? v.getOutsideFund() : "");
//                            fund.setInsideFund((null != v.getInsideFund()) ? v.getInsideFund() : "");
//                            fund.setBuildDate((null != responseFund.getData().getFoundDate())
//                                    ? responseFund.getData().getFoundDate()
//                                    : "");
//                            DanjuanResponse<DanjuanResponseFundDesc> responseFundDesc = DanjuanApi
//                                    .getFundDetailDesc(v.getOutsideFund());
//                            fundService.save(fund);
//                        }
//                    }
//                }
//
//                // 更新指数
//                Index index = new Index();
//                index.setName(v.getIndexName());
//                index.setCode(v.getIndexCode());
//                indexService.saveByCode(index);
//                // 更新指数数据
//                IndexDailyReport report = new IndexDailyReport();
//                if (null != response.getData().getTime()) {
//                    report.setDate(response.getData().getTime());
//                }
//
//                report.setIndexId(index.getId());
//                report.setIndexCode(index.getCode());
//
//                if (null != v.getProfitYield()) {
//                    report.setEp(v.getProfitYield());
//                } else if (null != v.getPe()) {
//                    String pe = String.format("%.4f", 1 / v.getPe());
//                    report.setEp(Double.valueOf(pe));
//                } else {
//                    report.setEp(0.0);
//                }
//
//                if (null != v.getPe()) {
//                    report.setPe(v.getPe());
//                } else {
//                    report.setPe(0.0);
//                }
//
//                if (null != v.getPb()) {
//                    report.setPb(v.getPb());
//                } else {
//                    report.setPb(0.0);
//                }
//
//                if (null != v.getDividendYield()) {
//                    report.setDyr(v.getDividendYield());
//                } else {
//                    report.setDyr(0.0);
//                }
//
//                if (null != v.getRoe()) {
//                    report.setRoe(v.getRoe());
//                } else {
//                    report.setRoe(0.0);
//                }
//                indexDailyReportService.save(report);
//            });
//        }
//    }
}
