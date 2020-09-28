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
    private String name;
}