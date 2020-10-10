package io.haicheng.cfundtool.service;

/**
 * <p>Title: FundService</p>
 * <p>Description: </p>
 *
 * @author haicheng
 * @Email haicheng@staff.weibo.com
 * @date 2020/9/28 3:42 下午
 */

import io.haicheng.cfundtool.domain.ServiceVO;
import io.haicheng.cfundtool.pojo.IndexDailyReport;
import java.util.List;
import java.util.Map;

public interface IndexDailyReportService {

    Map<String,Object> list(Integer page, Integer rows, String name, String date);

    ServiceVO save(IndexDailyReport indx);

    IndexDailyReport getReportByCodeAndDate(String code, String date);

    List<Map> getComboboxListDate(String q);
}
