package io.haicheng.cfundtool.service.impl;

import io.haicheng.cfundtool.domain.ServiceVO;
import io.haicheng.cfundtool.domain.SuccessCode;
import io.haicheng.cfundtool.mapper.AssetMapper;
import io.haicheng.cfundtool.pojo.Asset;
import io.haicheng.cfundtool.service.AssetService;
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
public class AssetServiceImpl implements AssetService {

    @Autowired
    AssetMapper assetMapper;

    @Override
    public Map<String, Object> list(Integer page, Integer rows, String name) {
        Map<String, Object> map = new HashMap<>();
        page = (null == page || page == 0) ? 1 : page;
        rows = (null == rows || rows == 0) ? 20 : rows;
        int offSet = (page - 1) * rows;
        List<Asset> funds = assetMapper.getList(offSet, rows, name);
        map.put("total", assetMapper.getCount(name));
        map.put("rows", funds);
        return map;
    }

    @Override
    public ServiceVO save(Asset asset) {
        if (asset.getId() == null) {
            assetMapper.save(asset);
        } else {
            assetMapper.update(asset);
        }
        return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }

    @Override
    public ServiceVO get(Integer id) {
        return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS, assetMapper.getById(id));
    }

    @Override
    public ServiceVO delete(String ids) {
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            assetMapper.deleteAsset(Integer.parseInt(id));
        }
        return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS);
    }

    @Override
    public List<Map<String, Object>> getDataCharts() {
        return assetMapper.getDataCharts();
    }
}
