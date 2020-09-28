package io.haicheng.cfundtool.pojo;

import javax.persistence.*;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository
@Table(name = "relation_fund_stock")
public class RelationFundStock {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 基金id
     */
    @Column(name = "fund_id")
    private Integer fundId;

    /**
     * 股票id
     */
    @Column(name = "stock_id")
    private Integer stockId;

    /**
     * 占比
     */
    private Float percent;

}