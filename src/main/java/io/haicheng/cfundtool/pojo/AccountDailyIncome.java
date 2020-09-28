package io.haicheng.cfundtool.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
@Table(name = "account_daily_income")
public class AccountDailyIncome {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 日期
     */
    private String date;

    /**
     * 基金id
     */
    @Column(name = "fund_id")
    private Integer fundId;

    /**
     * 收益
     */
    private Double income;

}