package io.haicheng.cfundtool.service;

/**
 * <p>Title: FundService</p>
 * <p>Description: </p>
 *
 * @author haicheng
 * @Email haicheng@staff.weibo.com
 * @date 2020/9/28 3:42 下午
 */

import io.haicheng.cfundtool.domain.ServiceVO;
import io.haicheng.cfundtool.pojo.Stock;
import java.util.List;
import java.util.Map;

public interface StockService {

    Map<String, Object> list(Integer page,
            Integer rows,
            String sort,
            String order,
            String name,
            String code,
            String industryName,
            Boolean profit,
            Boolean st,
            Boolean onlySh);

    Map<String, Object> listOfIndustry(Integer page,
            Integer rows,
            String sort,
            String order,
            String industryName,
            Boolean profit,
            Boolean st,
            Boolean onlySh);

    ServiceVO save(Stock stock);

    Stock getByCode(String code);

    List<Map> getComboboxList(String q);
}
