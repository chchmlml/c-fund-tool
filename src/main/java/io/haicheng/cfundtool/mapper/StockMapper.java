package io.haicheng.cfundtool.mapper;

import io.haicheng.cfundtool.pojo.Stock;
import io.haicheng.cfundtool.utils.MyMapper;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public interface StockMapper extends MyMapper<Stock> {

    List<Stock> getStockList(@Param("offSet") Integer offSet,
            @Param("pageRow") Integer pageRow,
            @Param("sort") String sort,
            @Param("order") String order,
            @Param("name") String name,
            @Param("code") String code,
            @Param("industryName") String industryName,
            @Param("profit") Boolean profit,
            @Param("st") Boolean st,
            @Param("onlySh") Boolean onlySh);

    Integer getStockCount(@Param("name") String name,
            @Param("code") String code,
            @Param("industryName") String industryName,
            @Param("profit") Boolean profit,
            @Param("st") Boolean st,
            @Param("onlySh") Boolean onlySh);

    List<Map> getIndustryList(@Param("offSet") Integer offSet,
            @Param("pageRow") Integer pageRow,
            @Param("sort") String sort,
            @Param("order") String order,
            @Param("industryName") String industryName,
            @Param("profit") Boolean profit,
            @Param("st") Boolean st,
            @Param("onlySh") Boolean onlySh);

    Integer getIndustryCount(@Param("industryName") String industryName,
            @Param("profit") Boolean profit,
            @Param("st") Boolean st,
            @Param("onlySh") Boolean onlySh);

    Integer saveStock(Stock fund);

    Integer updateStock(Stock fund);

    Stock getStockByCode(@Param("code") String code);

    List<String> getStockIndustryList(@Param("name") String name);
}