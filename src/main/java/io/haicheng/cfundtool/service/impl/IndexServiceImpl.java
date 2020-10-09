package io.haicheng.cfundtool.service.impl;

import io.haicheng.cfundtool.domain.ServiceVO;
import io.haicheng.cfundtool.domain.SuccessCode;
import io.haicheng.cfundtool.mapper.IndexMapper;
import io.haicheng.cfundtool.pojo.Index;
import io.haicheng.cfundtool.service.IndexService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Title: FundServiceImpl</p>
 * <p>Description: </p>
 *
 * @author haicheng
 * @Email haicheng@staff.weibo.com
 * @date 2020/9/28 3:44 下午
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    IndexMapper indexMapper;

    @Override
    public Map<String, Object> list(Integer page, Integer rows, String name) {
        Map<String, Object> map = new HashMap<>();
        page = (null == page || page == 0) ? 1 : page;
        rows = (null == rows || rows == 0) ? 20 : rows;
        int offSet = (page - 1) * rows;
        List<Index> funds = indexMapper.getIndexList(offSet, rows, name);
        map.put("total", indexMapper.getIndexCount(name));
        map.put("rows", funds);
        return map;
    }

    @Override
    public ServiceVO save(Index index) {
        if (index.getId() == null) {
            indexMapper.saveIndex(index);
        } else {
            indexMapper.updateIndex(index);
        }
        return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }

    @Override
    public ServiceVO saveByCode(Index index) {
        Index indexData = indexMapper.getIndexByCode(index.getCode());
        if (indexData == null) {
            indexMapper.saveIndex(index);
        } else {
            index.setId(indexData.getId());
            indexMapper.updateIndex(index);
        }
        return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }

    @Override
    public ServiceVO get(Integer id) {
        return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS, indexMapper.getIndexById(id));
    }

    @Override
    public Index getByCode(String code) {
        return indexMapper.getIndexByCode(code);
    }

    @Override
    public ServiceVO delete(String ids) {
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            indexMapper.deleteIndex(Integer.parseInt(id));
        }
        return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }
}
