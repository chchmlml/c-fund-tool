package io.haicheng.cfundtool;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(value = "io.haicheng")
@MapperScan("io.haicheng.cfundtool.mapper")
@EnableScheduling
public class CFundToolApplication {

    public static void main(String[] args) {
        SpringApplication.run(CFundToolApplication.class, args);
    }

}
