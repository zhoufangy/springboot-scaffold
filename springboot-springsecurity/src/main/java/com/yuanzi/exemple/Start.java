package com.yuanzi.exemple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by ZhouFangyuan on 2018/1/8. Information:
 */
@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = {"com.yuanzi.exemple"})
@EntityScan("com.yuanzi.exemple.model")
public class Start implements EmbeddedServletContainerCustomizer {

    final static Logger logger = LoggerFactory.getLogger(Start.class);

    public static void main(String[] args) {
        SpringApplication.run(Start.class);
    }
    @Override
    public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
    }
}
