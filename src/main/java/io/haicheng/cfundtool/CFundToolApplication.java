package io.haicheng.cfundtool;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "io.haicheng")
@MapperScan("io.haicheng.cfundtool.mapper")
public class CFundToolApplication {

    public static void main(String[] args) {
        SpringApplication.run(CFundToolApplication.class, args);
    }

}
