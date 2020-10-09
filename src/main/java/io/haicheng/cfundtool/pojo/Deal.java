package io.haicheng.cfundtool.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
@Table(name = "deal")
public class Deal {
    @Id
    private Integer id;

    private String date;

    @Column(name = "fund_id")
    private Integer fundId;

    @Column(name = "fund_name")
    private String fundName;

    @Column(name = "inside_fund")
    private String insideFund;

    @Column(name = "outside_fund")
    private String outsideFund;

    private Double amount;
}