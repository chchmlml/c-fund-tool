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
import io.haicheng.cfundtool.pojo.Deal;
import java.util.List;
import java.util.Map;

public interface DealService {

    Map<String,Object> list(Integer page, Integer rows, String name);

    ServiceVO save(Deal customer);

    ServiceVO get(Integer id);

    ServiceVO delete(String ids);

    List<Map> getComboboxList(String q);
}
