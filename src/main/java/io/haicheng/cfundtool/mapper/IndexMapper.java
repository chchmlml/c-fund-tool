package io.haicheng.cfundtool.mapper;

import io.haicheng.cfundtool.pojo.Index;
import io.haicheng.cfundtool.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IndexMapper extends MyMapper<Index> {

    List<Index> getIndexList(@Param("offSet") Integer offSet, @Param("pageRow") Integer pageRow, @Param("name") String name);

    Integer getIndexCount(@Param("name") String name);

    Integer saveIndex(Index Index);

    Integer updateIndex(Index Index);

    Index getIndexById(Integer id);

    Index getIndexByCode(String code);

    Integer deleteIndex(Integer id);

}