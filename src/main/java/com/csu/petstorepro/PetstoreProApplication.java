package com.csu.petstorepro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.csu.petstorepro.petstore.mapper")
public class PetstoreProApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetstoreProApplication.class, args);
    }

}
