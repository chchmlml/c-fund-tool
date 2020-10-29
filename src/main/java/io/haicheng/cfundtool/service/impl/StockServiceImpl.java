package io.haicheng.cfundtool.service.impl;

import cn.hutool.core.util.StrUtil;
import io.haicheng.cfundtool.domain.ServiceVO;
import io.haicheng.cfundtool.domain.SuccessCode;
import io.haicheng.cfundtool.mapper.StockMapper;
import io.haicheng.cfundtool.pojo.Stock;
import io.haicheng.cfundtool.service.StockService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Title: StockServiceImpl</p>
 * <p>Description: </p>
 *
 * @author haicheng
 * @Email haicheng@staff.weibo.com
 * @date 2020/9/28 3:44 下午
 */
@Service
public class StockServiceImpl implements StockService {

    @Autowired
    StockMapper stockMapper;

    @Override
    public Map<String, Object> list(Integer page,
            Integer rows,
            String sort,
            String order,
            String name,
            String code,
            String industryName) {
        Map<String, Object> map = new HashMap<>();
        page = (null == page || page == 0) ? 1 : page;
        rows = (null == rows || rows == 0) ? 20 : rows;
        sort = (null == sort) ? "id" : StrUtil.toUnderlineCase(sort);
        order = (null == order) ? "desc" : order;
        int offSet = (page - 1) * rows;
        List<Stock> funds = stockMapper.getStockList(offSet, rows, sort, order, name, code, industryName);
        map.put("total", stockMapper.getStockCount(name, code, industryName));
        map.put("rows", funds);
        return map;
    }

    @Override
    public Map<String, Object> listOfIndustry(Integer page,
            Integer rows,
            String sort,
            String order,
            String industryName) {
        Map<String, Object> map = new HashMap<>();
        page = (null == page || page == 0) ? 1 : page;
        rows = (null == rows || rows == 0) ? 20 : rows;
        sort = (null == sort) ? "pb" : StrUtil.toUnderlineCase(sort);
        switch (sort) {
            case "pe_ttm":
                sort = "FORMAT(SUM(pe_ttm)/COUNT(industry_name), 2) + 0";
                break;
            case "pe_lyr":
                sort = "FORMAT(SUM(pe_lyr)/COUNT(industry_name), 2) + 0";
                break;
            case "pb":
                sort = "FORMAT(SUM(pb)/COUNT(industry_name), 2) + 0";
                break;
        }
        order = (null == order) ? "desc" : order;
        int offSet = (page - 1) * rows;
        List<Map> funds = stockMapper.getIndustryList(offSet, rows, sort, order, industryName);
        map.put("total", stockMapper.getIndustryCount(industryName));
        map.put("rows", funds);
        return map;
    }

    @Override
    public ServiceVO save(Stock stock) {
        Stock current = stockMapper.getStockByCode(stock.getCode());
        if (current == null) {
            stockMapper.saveStock(stock);
        } else {
            stock.setId(current.getId());
            stockMapper.updateStock(stock);
        }
        return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }

    @Override
    public Stock getByCode(String code) {
        return stockMapper.getStockByCode(code);
    }

    @Override
    public List<Map> getComboboxList(String q) {
        List<String> lists = stockMapper.getStockIndustryList(q);
        List<Map> result = new ArrayList<>();
        lists.forEach(f -> {
            result.add(new HashMap() {{
                put("name", f);
            }});
        });
        return result;
    }
}