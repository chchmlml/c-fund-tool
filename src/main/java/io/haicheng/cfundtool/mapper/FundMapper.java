package io.haicheng.cfundtool.mapper;

import io.haicheng.cfundtool.pojo.Fund;
import io.haicheng.cfundtool.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FundMapper extends MyMapper<Fund> {

    List<Fund> getFundList(@Param("offSet") Integer offSet,
            @Param("pageRow") Integer pageRow,
            @Param("name") String name);

    Integer getFundCount(@Param("name") String name);

    Integer saveFund(Fund fund);

    Integer updateFund(Fund fund);

    Fund getFundById(Integer id);

    Fund getFundByOutsideFund(String outsideFund);

    Integer deleteFund(Integer id);

    List<Fund> getFundListByNameLike(String q);
}