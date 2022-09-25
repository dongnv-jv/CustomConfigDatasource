package com.example.customconfigdatasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class CustomConfigDatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomConfigDatasourceApplication.class, args);
    }

}
