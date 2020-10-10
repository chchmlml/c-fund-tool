package io.haicheng.cfundtool.controller;

import io.haicheng.cfundtool.domain.ServiceVO;
import io.haicheng.cfundtool.pojo.Asset;
import io.haicheng.cfundtool.service.AssetService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 基金Controller控制器
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AssetService service;

    /**
     * 分页查询供应商
     * @param page 当前页数
     * @param rows 每页显示的记录数
     * @param name 供应商名
     * @return
     */
    @RequestMapping("/list")
    public Map<String,Object> list(Integer page, Integer rows, String name) {
        return service.list(page, rows, name);
    }

    /**
     * 添加或修改供应商
     * @param fund 供应商实体
     * @return
     */
    @RequestMapping("/save")
    public ServiceVO save(Asset fund) {
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
}
