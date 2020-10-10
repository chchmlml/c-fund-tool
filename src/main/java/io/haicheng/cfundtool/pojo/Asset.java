package io.haicheng.cfundtool.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class Asset {

    @Id
    private Integer id;

    @Column(name = "date")
    private String date;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_amount")
    private Double itemAmount;

}