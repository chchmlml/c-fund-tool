package io.haicheng.cfundtool.service.impl;

import io.haicheng.cfundtool.domain.ServiceVO;
import io.haicheng.cfundtool.domain.SuccessCode;
import io.haicheng.cfundtool.mapper.IndexDailyReportMapper;
import io.haicheng.cfundtool.pojo.IndexDailyReport;
import io.haicheng.cfundtool.service.IndexDailyReportService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Title: FundServiceImpl</p>
 * <p>Description: </p>
 *
 * @author haicheng
 * @Email haicheng@staff.weibo.com
 * @date 2020/9/28 3:44 下午
 */
@Service
public class IndexDailyReportServiceImpl implements IndexDailyReportService {

    @Autowired
    IndexDailyReportMapper indexDailyReport;

    @Override
    public Map<String, Object> list(Integer page, Integer rows, String name) {
        Map<String, Object> map = new HashMap<>();
        page = (null == page || page == 0) ? 1 : page;
        rows = (null == rows || rows == 0) ? 20 : rows;
        int offSet = (page - 1) * rows;
        List<IndexDailyReport> funds = indexDailyReport.getReportList(offSet, rows, name);
        map.put("total", indexDailyReport.getReportCount(name));
        map.put("rows", funds);
        return map;
    }

    @Override
    public ServiceVO save(IndexDailyReport data) {
        IndexDailyReport indexData = indexDailyReport.getReportByCodeAndDate(data.getIndexCode(), data.getDate());
        if (indexData == null) {
            indexDailyReport.saveReport(data);
        } else {
            data.setId(indexData.getId());
            indexDailyReport.updateReport(data);
        }
        return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }

    @Override
    public IndexDailyReport getReportByCodeAndDate(String code, String date) {
        return indexDailyReport.getReportByCodeAndDate(code, date);
    }
}
