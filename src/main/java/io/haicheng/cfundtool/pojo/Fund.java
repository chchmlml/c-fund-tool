package io.haicheng.cfundtool.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import org.springframework.stereotype.Repository;
import lombok.Data;

@Data
@Repository
public class Fund {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 基金名称
     */
    private String name;

    /**
     * 基金代码
     */
    private String code;

    /**
     * 基金规模
     */
    private Integer scope;

    /**
     * 成立时间
     */
    @Column(name = "build_date")
    private String buildDate;
}