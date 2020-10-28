package io.haicheng.cfundtool.pojo;

import javax.persistence.*;

import org.springframework.stereotype.Repository;

import lombok.Data;

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
}