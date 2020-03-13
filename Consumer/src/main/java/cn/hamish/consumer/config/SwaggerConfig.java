package cn.hamish.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @描述: Swagger配置类
 * @Date: 2020-03-12 19:23
 * @Author: hha
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()) // 调用apiInfo方法
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.hamish.consumer"))
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("dubboProject测试项目")
                .contact(new Contact("hamish", "", "xxxxxxxxxx@qq.com"))
                .description("SpringBoot整合Swagger，详细信息......")
                .version("1.0.0")
                .build();
    }

}
