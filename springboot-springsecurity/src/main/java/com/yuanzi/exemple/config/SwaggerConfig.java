package com.yuanzi.exemple.config;

import com.google.common.collect.Lists;
import com.yuanzi.exemple.util.StatusConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * Created by ZuoYun on 26/06/2017.
 * Time: 4:23 PM
 * Information:
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurerAdapter {

    @Bean
    public Docket createRestApi() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("API文档")
                .description("接口文档")
                .contact("周芳园")
                .version("0.6.0")
                .build();
        List<ResponseMessage> msg = Lists.newArrayList();

        for (StatusConstant statusConstant : StatusConstant.values()) {
            msg.add(new ResponseMessageBuilder()
                    .code(statusConstant.val())
                    .message(statusConstant.msg())
                    .responseModel(new ModelRef("Error")).build());
        }
        return new Docket(DocumentationType.SWAGGER_2)
//        .useDefaultResponseMessages(false)
//        .globalResponseMessage(RequestMethod.GET,
//                               msg
//        )
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yuanzi.exemple.api"))
                .paths(PathSelectors.any())
                .build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }


}
