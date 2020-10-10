package io.haicheng.cfundtool.mapper;

import io.haicheng.cfundtool.pojo.Asset;
import io.haicheng.cfundtool.utils.MyMapper;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AssetMapper extends MyMapper<Asset> {

    List<Asset> getList(@Param("offSet") Integer offSet, @Param("pageRow") Integer pageRow, @Param("name") String name);

    Integer getCount(@Param("name") String name);

    Integer save(Asset asset);

    Integer update(Asset asset);

    Asset getById(Integer id);

    Integer deleteAsset(Integer id);

    List<Map<String, Object>> getDataCharts();
}