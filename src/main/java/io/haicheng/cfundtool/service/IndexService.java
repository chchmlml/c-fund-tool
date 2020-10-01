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
import io.haicheng.cfundtool.pojo.Index;
import java.util.Map;

public interface IndexService {

    Map<String,Object> list(Integer page, Integer rows, String name);

    ServiceVO save(Index indx);

    ServiceVO saveByCode(Index indx);

    ServiceVO get(Integer id);

    ServiceVO delete(String ids);
}
