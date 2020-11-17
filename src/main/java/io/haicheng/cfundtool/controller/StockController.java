package io.haicheng.cfundtool.controller;

import io.haicheng.cfundtool.service.StockService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService service;

    @RequestMapping(path = "/list", method = {RequestMethod.POST,
            RequestMethod.GET})
    public Map<String, Object> list(Integer page,
            Integer rows,
            @RequestParam(name = "sort", defaultValue = "id") String sort,
            @RequestParam(name = "order", defaultValue = "desc") String order,
            @RequestParam(name = "name", defaultValue = "") String name,
            @RequestParam(name = "code", defaultValue = "") String code,
            @RequestParam(name = "industry", defaultValue = "") String industryName,
            @RequestParam(name = "profit", defaultValue = "false") Boolean profit,
            @RequestParam(name = "st", defaultValue = "false") Boolean st,
            @RequestParam(name = "onlySh", defaultValue = "false") Boolean onlySh) {
        return service.list(page, rows, sort, order, name, code, industryName, profit, st, onlySh);
    }

    @RequestMapping(path = "/industry", method = {RequestMethod.POST,
            RequestMethod.GET})
    public Map<String, Object> industry(Integer page,
            Integer rows,
            @RequestParam(name = "sort", defaultValue = "pb") String sort,
            @RequestParam(name = "order", defaultValue = "desc") String order,
            @RequestParam(name = "industry", defaultValue = "") String industryName,
            @RequestParam(name = "profit", defaultValue = "false") Boolean profit,
            @RequestParam(name = "st", defaultValue = "false") Boolean st,
            @RequestParam(name = "onlySh", defaultValue = "false") Boolean onlySh) {
        return service.listOfIndustry(page, rows, sort, order, industryName, profit, st, onlySh);
    }

    @RequestMapping("/getComboboxList")
    public List<Map> getComboboxList(@RequestParam(name = "q", defaultValue = "") String q) {
        return service.getComboboxList(q);
    }
}
