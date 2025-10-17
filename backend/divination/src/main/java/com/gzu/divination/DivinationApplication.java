package com.gzu.divination;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class DivinationApplication {

    public static void main(String[] args) {
        SpringApplication.run(DivinationApplication.class, args);
        log.info("灵境智能助手开始启动...");
    }

}
