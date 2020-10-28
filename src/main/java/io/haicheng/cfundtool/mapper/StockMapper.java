package io.haicheng.cfundtool.mapper;

import io.haicheng.cfundtool.pojo.Stock;
import io.haicheng.cfundtool.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface StockMapper extends MyMapper<Stock> {

    Integer saveStock(Stock fund);

    Integer updateStock(Stock fund);

    Stock getStockByCode(@Param("code") String code);
}