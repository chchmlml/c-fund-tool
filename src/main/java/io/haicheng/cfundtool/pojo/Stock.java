package io.haicheng.cfundtool.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class Stock {

    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 股票名称
     */
    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "industry_code")
    private String industryCode;

    @Column(name = "industry_name")
    private String industryName;

    @Column(name = "pe_dynamic")
    private Double peDynamic;

    @Column(name = "pe_lyr")
    private Double peLyr;

    @Column(name = "pe_ttm")
    private Double peTtm;

    @Column(name = "pb")
    private Double pb;

    @Column(name = "netprofit")
    private Double netprofit;

    @Column(name = "dy_l")
    private Double dy_l;

    @Column(name = "ia")
    private Double ia;

    @Column(name = "ta")
    private Double ta;

    @Column(name = "goodwill")
    private Double goodwill;

    @Column(name = "pe_score")
    private Double peScore;

    @Column(name = "pb_score")
    private Double pbScore;

    @Column(name = "score")
    private Double score;
}