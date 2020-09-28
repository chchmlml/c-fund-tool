package io.haicheng.cfundtool.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
@Table(name = "account_deal_log")
public class AccountDealLog {
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
     * 金额
     */
    private Integer sum;
}