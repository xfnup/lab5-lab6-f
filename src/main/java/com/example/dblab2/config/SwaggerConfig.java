package com.example.dblab2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 //开启Swagger2
@EnableWebMvc
public class SwaggerConfig {
    //配置Swagger的Docket的Bean
    @Bean
    public Docket docketDefault(Environment environment){

        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .select()
                //selectors配置扫描哪里的接口basepackage指定我的包，简单配置
                .apis(RequestHandlerSelectors.basePackage("com.example.dblab2.controller"))
                .build();
    } //enable(false)就是关闭Swagger2，正式发布时不要使用Swagger2.
}
