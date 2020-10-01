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

    /**
     * 日期
     */
    private String date;

    /**
     * 盈利收益率
     */
    @Column(name = "EP")
    private Float ep;

    /**
     * 市盈率
     */
    @Column(name = "PE")
    private Float pe;

    /**
     * 市净率
     */
    @Column(name = "PB")
    private Float pb;

    /**
     * 股息率
     */
    @Column(name = "DYR")
    private Float dyr;

    /**
     * 净资产收益率
     */
    @Column(name = "ROE")
    private Float roe;

}