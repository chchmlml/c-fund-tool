package io.haicheng.cfundtool.service.impl;

import io.haicheng.cfundtool.domain.ServiceVO;
import io.haicheng.cfundtool.domain.SuccessCode;
import io.haicheng.cfundtool.mapper.FundMapper;
import io.haicheng.cfundtool.pojo.Fund;
import io.haicheng.cfundtool.service.FundService;
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
public class FundServiceImpl implements FundService {

    @Autowired
    FundMapper fundMapper;

    @Override
    public Map<String, Object> list(Integer page, Integer rows, String name) {
        Map<String, Object> map = new HashMap<>();
        page = page == 0 ? 1 : page;
        int offSet = (page - 1) * rows;
        List<Fund> funds = fundMapper.getFundList(offSet, rows, name);
        map.put("total", fundMapper.getFundCount(name));
        map.put("rows", funds);
        return map;
    }

    @Override
    public ServiceVO save(Fund fund) {
        if (fund.getId() == null) {
            fundMapper.saveFund(fund);
        } else {
            fundMapper.updateFund(fund);
        }
        return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }

    @Override
    public ServiceVO get(Integer id) {
        return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS, fundMapper.getFundById(id));
    }

    @Override
    public Fund getFundByOutsideFund(String code) {
        return fundMapper.getFundByOutsideFund(code);
    }

    @Override
    public ServiceVO delete(String ids) {
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            fundMapper.deleteFund(Integer.parseInt(id));
        }
        return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }
}
