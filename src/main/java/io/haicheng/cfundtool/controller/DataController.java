package io.haicheng.cfundtool.controller;

import io.haicheng.cfundtool.service.IndexDailyReportService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 基金Controller控制器
 */
@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private IndexDailyReportService service;

    /**
     * 分页查询供应商
     *
     * @param page 当前页数
     * @param rows 每页显示的记录数
     * @param name 供应商名
     * @param date 日期
     */
    @RequestMapping("/list")
    public Map<String, Object> list(Integer page,
            Integer rows,
            @RequestParam(name = "name", defaultValue = "") String name,
            @RequestParam(name = "date", defaultValue = "") String date) {
        return service.list(page, rows, name, date);
    }

    /**
     * 查询下拉框客户信息
     * @param q 客户名称
     * @return
     */
    @RequestMapping("/getComboboxListDate")
    public List<Map> getComboboxList(String q) {
        return service.getComboboxListDate(q);
    }
}
