package com.example.medicagent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.medicagent.mapper")
public class MedicAgentApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicAgentApplication.class, args);
    }

}
