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

        Element asset = Element.builder()
                .id(1001)
                .text("资产")
                .iconCls("menu-11")
                .state("open")
                .attributes(Attributes.builder().url("/purchase/purchase.html").build())
                .build();

        Element account = Element.builder()
                .id(10)
                .text("我的资产")
                .iconCls("menu-1")
                .state("closed")
                .children(Arrays.asList(asset))
                .build();
        Element data = Element.builder()
                .id(11)
                .text("数据报表")
                .iconCls("menu-2")
                .state("closed")
                .children(Arrays.asList(asset))
                .build();
        Element log = Element.builder()
                .id(12)
                .text("日志")
                .iconCls("menu-3")
                .state("closed")
                .children(Arrays.asList(asset))
                .build();

        Element system = Element.builder()
                .id(1)
                .text("系统菜单")
                .iconCls("menu-plugin")
                .state("closed")
                .children(Arrays.asList(account, data, log))
                .build();

        return JsonUtil.obj2String(Arrays.asList(system));
    }
}
