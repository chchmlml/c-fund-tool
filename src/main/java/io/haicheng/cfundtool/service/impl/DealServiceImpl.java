package io.haicheng.cfundtool.service.impl;

import io.haicheng.cfundtool.domain.ServiceVO;
import io.haicheng.cfundtool.domain.SuccessCode;
import io.haicheng.cfundtool.mapper.DealMapper;
import io.haicheng.cfundtool.mapper.FundMapper;
import io.haicheng.cfundtool.pojo.Deal;
import io.haicheng.cfundtool.pojo.Fund;
import io.haicheng.cfundtool.service.DealService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Title: DealServiceImpl</p>
 * <p>Description: </p>
 *
 * @author haicheng
 * @Email haicheng@staff.weibo.com
 * @date 2020/9/28 3:44 下午
 */
@Service
public class DealServiceImpl implements DealService {

    @Autowired
    DealMapper dealMapper;

    @Autowired
    FundMapper fundMapper;

    @Override
    public Map<String, Object> list(Integer page, Integer rows, String name) {
        Map<String, Object> map = new HashMap<>();
        page = page == 0 ? 1 : page;
        int offSet = (page - 1) * rows;
        List<Deal> funds = dealMapper.getDealList(offSet, rows, name);
        map.put("total", dealMapper.getDealCount(name));
        map.put("rows", funds);
        map.put("footer", Arrays.asList(new HashMap<String, Object>() {{
            put("fundName", "统计");
            put("amount", dealMapper.getDealAmount());
        }}));

        return map;
    }

    @Override
    public ServiceVO save(Deal fund) {
        if (fund.getId() == null) {
            dealMapper.saveDeal(fund);
        } else {
            dealMapper.updateDeal(fund);
        }
        return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }

    @Override
    public ServiceVO get(Integer id) {
        return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS, dealMapper.getDealById(id));
    }

    @Override
    public ServiceVO delete(String ids) {
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            dealMapper.deleteDeal(Integer.parseInt(id));
        }
        return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }

    @Override
    public List<Map> getComboboxList(String q) {
        List<Fund> fundList = fundMapper.getFundListByNameLike(q);
        List<Map> result = new ArrayList<>();
        fundList.forEach(f -> {
            result.add(new HashMap() {{
                put("fundId", f.getId());
                put("fundName", f.getFundName());
            }});
        });
        return result;
    }
}
