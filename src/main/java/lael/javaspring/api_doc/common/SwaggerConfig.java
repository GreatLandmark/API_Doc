package lael.javaspring.api_doc.common;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 测试网址：http://localhost:8080/server.context-path/swagger-ui.html
 * API 文档：http://localhost:8001/swagger-ui.html 
 */

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket adminApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("LaeL Lofit Test API Doc").apiInfo(apiInfo())
                .useDefaultResponseMessages(false).forCodeGeneration(true).pathMapping("/").select().paths(paths())
                .build();
        // .consumes(DEFAULT_PRODUCES_AND_CONSUMES).produces(DEFAULT_PRODUCES_AND_CONSUMES)
        // 属性consumes： 指定处理请求当中的提交内容类型（Content-Type）：application/json, text/html等;
        // 属性produces：指定返回值类型，并且可以设置返回值类型和返回值的字符编码.
    }
    
    // Public API 文档
    // @Bean
    // public Docket publicApi() {
    //     return new Docket(DocumentationType.SWAGGER_2).groupName("LaeL Lofit Public API Doc").apiInfo(apiInfo())
    //             .useDefaultResponseMessages(false).forCodeGeneration(true).pathMapping("/").select().paths(paths())
    //             .build();        
    // }

    private Predicate<String> paths() {
        return PathSelectors.regex("^/(?!error).*$");
    }

    // 配置content type
    private final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(Arrays.asList("*/*",
            "application/json", "application/xml", "application/x-www-form-urlencoded", "multipart/form-data"));

    private ApiInfo apiInfo() {
        Contact contact = new Contact("Lofit", "http://www.LaeL.fun/", "lofit@lael.fun");
        return new ApiInfoBuilder().title("LaeL Lofit Doc API Test").description("学习 LaeL Lofit Doc API Test")
                .license("Apache License Version 2.0").contact(contact).version("1.0.0").build();
    }
}