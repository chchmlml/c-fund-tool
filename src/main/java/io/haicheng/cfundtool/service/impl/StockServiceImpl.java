package io.haicheng.cfundtool.service.impl;

import io.haicheng.cfundtool.domain.ServiceVO;
import io.haicheng.cfundtool.domain.SuccessCode;
import io.haicheng.cfundtool.mapper.StockMapper;
import io.haicheng.cfundtool.pojo.Stock;
import io.haicheng.cfundtool.service.StockService;
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
}
