package io.haicheng.cfundtool.controller;

import io.haicheng.cfundtool.domain.ServiceVO;
import io.haicheng.cfundtool.pojo.Fund;
import io.haicheng.cfundtool.service.FundService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 供应商Controller控制器
 */
@RestController
@RequestMapping("/fund")
public class FundController {

    @Autowired
    private FundService fundService;

    /**
     * 分页查询供应商
     * @param page 当前页数
     * @param rows 每页显示的记录数
     * @param fundName 供应商名
     * @return
     */
    @RequestMapping("/list")
    public Map<String,Object> list(Integer page, Integer rows, String fundName) {
        return fundService.list(page, rows, fundName);
    }

    /**
     * 添加或修改供应商
     * @param fund 供应商实体
     * @return
     */
    @RequestMapping("/save")
    public ServiceVO save(Fund fund) {
        return fundService.save(fund);
    }

    /**
     * 删除供应商
     * @param ids 供应商ids字符串，用逗号分隔
     * @return
     */
    @RequestMapping("/delete")
    public ServiceVO delete(String ids) {
        return fundService.delete(ids);
    }
}
