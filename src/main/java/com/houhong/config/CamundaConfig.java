package com.houhong.config;

import org.camunda.bpm.engine.impl.cfg.IdGenerator;
import org.camunda.bpm.engine.impl.persistence.StrongUuidGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: bpm-starter
 * @description: camunda 配置器
 * @author: houhong
 * @create: 2022-07-18 00:14
 **/
@Configuration
public class CamundaConfig {


    @Bean
    public IdGenerator camundaIdGenerator() {

        return new StrongUuidGenerator();
    }
}