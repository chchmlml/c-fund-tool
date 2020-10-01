package io.haicheng.cfundtool.controller;

import io.haicheng.cfundtool.domain.ServiceVO;
import io.haicheng.cfundtool.pojo.Deal;
import io.haicheng.cfundtool.service.DealService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 交易Controller控制器
 */
@RestController
@RequestMapping("/deal")
public class DealController {

    @Autowired
    private DealService service;

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

    /**
     * 添加或修改供应商
     * @param fund 供应商实体
     * @return
     */
    @RequestMapping("/save")
    public ServiceVO save(Deal fund) {
        return service.save(fund);
    }

    /**
     * 删除供应商
     * @param ids 供应商ids字符串，用逗号分隔
     * @return
     */
    @RequestMapping("/delete")
    public ServiceVO delete(String ids) {
        return service.delete(ids);
    }

    /**
     * 查询下拉框客户信息
     * @param q 客户名称
     * @return
     */
    @RequestMapping("/getComboboxList")
    public List<Map> getComboboxList(String q) {
        return service.getComboboxList(q);
    }
}
