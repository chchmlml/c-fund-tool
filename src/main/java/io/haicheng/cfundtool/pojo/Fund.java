package io.haicheng.cfundtool.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import org.springframework.stereotype.Repository;
import lombok.Data;

@Data
@Repository
public class Fund {

    @Id
    private Integer id;

    @Column(name = "fund_name")
    private String fundName;

    @Column(name = "outside_fund")
    private String outsideFund;

    @Column(name = "inside_fund")
    private String insideFund;

    @Column(name = "build_date")
    private String buildDate;
}