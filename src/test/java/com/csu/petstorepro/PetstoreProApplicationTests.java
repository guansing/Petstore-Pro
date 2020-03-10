package com.csu.petstorepro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper")
//@MapperScan("com.csu.jpetstoreadmin.petstore.mapper")
@MapperScan("com.csu.petstorepro.petstore.mapper")
public class PetstoreProApplicationTests
{
    public static void main(String[] args)
    {
        SpringApplication.run(PetstoreProApplicationTests.class, args);
    }
}
