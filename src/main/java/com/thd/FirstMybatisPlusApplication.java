package com.thd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Title: springboot-mybatis-demotest
 * @Description:
 * @Copyright: Copyright (c) 2019-2020 Digitalchina CO.,LTD. All rights reserved.
 * @Company: 北京桃花岛信息技术有限公司
 * @author: Allen
 * @version: V1.0
 * @修改历史:
 */
@SpringBootApplication
@MapperScan("com.thd.dao")
//@ComponentScan({"com.thd.*","com.thd.**"})
public class FirstMybatisPlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(FirstMybatisPlusApplication.class, args);
    }
}
