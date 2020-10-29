package io.haicheng.cfundtool.controller;

import io.haicheng.cfundtool.utils.JsonUtil;
import java.util.Arrays;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haicheng
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Builder
    @Data
    public static class Element {

        private int id;
        private String text;
        private String iconCls;
        private String state;
        private Attributes attributes;
        private List<Element> children;
    }

    @Builder
    @Data
    public static class Attributes {

        private String url;
    }

    /**
     * 查询当前角色的导航菜单
     */
    @RequestMapping("/loadMenu")
    public String loadMenu() {

        // ==================== level 1-1 ========================
        Element asset = Element.builder()
                .id(1001)
                .text("资产盘点")
                .iconCls("menu-11")
                .state("open")
                .attributes(Attributes.builder().url("/asset/account.html").build())
                .build();
        Element fund = Element.builder()
                .id(1002)
                .text("关注基金")
                .iconCls("menu-12")
                .state("open")
                .attributes(Attributes.builder().url("/asset/fund.html").build())
                .build();
        Element buy = Element.builder()
                .id(1003)
                .text("投资管理")
                .iconCls("menu-13")
                .state("open")
                .attributes(Attributes.builder().url("/asset/deal.html").build())
                .build();
        Element index = Element.builder()
                .id(1004)
                .text("指数列表")
                .iconCls("menu-14")
                .state("open")
                .attributes(Attributes.builder().url("/asset/index.html").build())
                .build();

        Element account = Element.builder()
                .id(10)
                .text("我的资产")
                .iconCls("menu-1")
                .state("closed")
                .children(Arrays.asList(asset, fund, buy, index))
                .build();

        // ==================== level 1-2 ========================
        Element index2 = Element.builder()
                .id(2001)
                .text("指数估值")
                .iconCls("menu-21")
                .state("open")
                .attributes(Attributes.builder().url("/data/index.html").build())
                .build();
        Element report = Element.builder()
                .id(2002)
                .text("收益报表")
                .iconCls("menu-22")
                .state("open")
                .attributes(Attributes.builder().url("/asset/fund.html").build())
                .build();

        Element data = Element.builder()
                .id(20)
                .text("数据报表")
                .iconCls("menu-2")
                .state("closed")
                .children(Arrays.asList(index2))
                .build();

        // ==================== level 1-3 ========================
        Element industry = Element.builder()
                .id(3002)
                .text("行业概况")
                .iconCls("menu-32")
                .state("open")
                .attributes(Attributes.builder().url("/stock/industry.html").build())
                .build();
        Element stocks = Element.builder()
                .id(3001)
                .text("股票筛选")
                .iconCls("menu-31")
                .state("open")
                .attributes(Attributes.builder().url("/stock/index.html").build())
                .build();

        Element stock = Element.builder()
                .id(30)
                .text("股票")
                .iconCls("menu-3")
                .state("closed")
                .children(Arrays.asList(stocks, industry))
                .build();
        // ==================== level 0 ========================
        Element system = Element.builder()
                .id(1)
                .text("系统菜单")
                .iconCls("menu-plugin")
                .state("closed")
                .children(Arrays.asList(account, data, stock))
                .build();

        return JsonUtil.obj2String(Arrays.asList(system));
    }
}
