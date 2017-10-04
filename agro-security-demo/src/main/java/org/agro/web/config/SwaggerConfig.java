/**
 * 
 */
package org.agro.web.config;

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
 * @author gaoxiang
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket createRestApi() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .apiInfo(apiInfo())		
//          .groupName("v1")
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("org.agro.web"))              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
	
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("测试用")
                .termsOfServiceUrl("localhost:8080")
                .contact(new Contact("taurusnail","https://github.com/taurusnail","gauxiang@aliyun.com"))
                .version("1.0")
                .build();
    }

}
