package com.anasiangangster.aomall001;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.anasiangangster.aomall001.mapper")
public class AomallApplication {

    public static void main(String[] args) {
        SpringApplication.run(AomallApplication.class, args);
    }

}
