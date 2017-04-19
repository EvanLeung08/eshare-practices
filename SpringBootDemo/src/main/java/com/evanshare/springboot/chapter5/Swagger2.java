package com.evanshare.springboot.chapter5;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by liangyh on 2017/4/19.
 * Email:10856214@163.com
 */
@Configuration
@EnableSwagger2
public class Swagger2 {


    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.evanshare.springboot.chapter5.web")).paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Spring boot 使用swagger构建rest api").description("更多文章请关注www.evanshare.com").termsOfServiceUrl("www.evanshare.com").contact("Evan").version("v1").build();
    }


}
