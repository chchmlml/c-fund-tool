package io.haicheng.cfundtool.mapper;

import io.haicheng.cfundtool.pojo.Deal;
import io.haicheng.cfundtool.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DealMapper extends MyMapper<Deal> {

    List<Deal> getDealList(@Param("offSet") Integer offSet, @Param("pageRow") Integer pageRow, @Param("name") String name);

    Integer getDealCount(@Param("name") String name);

    Integer saveDeal(Deal deal);

    Integer updateDeal(Deal deal);

    Deal getDealById(Integer id);

    Integer deleteDeal(Integer id);
}