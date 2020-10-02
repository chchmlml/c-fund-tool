package io.haicheng.cfundtool.controller;

import io.haicheng.cfundtool.service.IndexDailyReportService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
     * @param page 当前页数
     * @param rows 每页显示的记录数
     * @param fundName 供应商名
     * @return
     */
    @RequestMapping("/list")
    public Map<String,Object> list(Integer page, Integer rows, String fundName) {
        return service.list(page, rows, fundName);
    }
}
