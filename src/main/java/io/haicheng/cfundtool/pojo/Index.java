package io.haicheng.cfundtool.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class Index {

    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

}