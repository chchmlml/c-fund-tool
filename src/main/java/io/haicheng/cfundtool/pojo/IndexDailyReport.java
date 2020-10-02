package io.haicheng.cfundtool.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
@Table(name = "index_daily_report")
public class IndexDailyReport {
    @Id
    private Integer id;

    /**
     * 基金id
     */
    @Column(name = "index_id")
    private Integer indexId;

    @Column(name = "index_name")
    private String indexName;

    @Column(name = "index_code")
    private String indexCode;

    /**
     * 日期
     */
    private String date;

    /**
     * 盈利收益率
     */
    private Double ep;

    /**
     * 市盈率
     */
    private Double pe;

    /**
     * 市净率
     */
    private Double pb;

    /**
     * 股息率
     */
    private Double dyr;

    /**
     * 净资产收益率
     */
    private Double roe;
}