package io.haicheng.cfundtool.controller;

import io.haicheng.cfundtool.service.AssetService;
import io.haicheng.cfundtool.utils.JsonUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author haicheng
 * @description 系统首页请求控制器
 */
@Controller
public class IndexController {

    @Autowired
    private AssetService service;

    /**
     * 进入登录页面
     *
     * @return 重定向至登录页面
     */
    @GetMapping("/")
    public String toIndex() {
        return "main.html";
    }

    @ResponseBody
    @GetMapping("/charts")
    public String charts() {

        List<Map<String, Object>> asset = service.getDataCharts();
        List<String> xaxisData = new ArrayList<>();
        List<Double> seriesData = new ArrayList<>();
        asset.forEach(q -> {
            xaxisData.add((String) q.getOrDefault("date", ""));
            seriesData.add(Double.valueOf(String.valueOf(q.get("total"))));
        });

        return JsonUtil.obj2String(new HashMap<String, Object>() {{
            put("xaxis_data", xaxisData);
            put("series_data", seriesData);
        }});
    }

}
