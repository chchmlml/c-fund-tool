package io.haicheng.cfundtool.mapper;

import io.haicheng.cfundtool.pojo.IndexDailyReport;
import io.haicheng.cfundtool.utils.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IndexDailyReportMapper extends MyMapper<IndexDailyReport> {

    List<IndexDailyReport> getReportList(@Param("offSet") Integer offSet, @Param("pageRow") Integer pageRow, @Param("name") String name);

    Integer getReportCount(@Param("name") String name);

    Integer saveReport(IndexDailyReport Index);

    Integer updateReport(IndexDailyReport Index);

    IndexDailyReport getReportByCodeAndDate(String code, String date);
}