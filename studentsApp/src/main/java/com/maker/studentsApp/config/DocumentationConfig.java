package com.maker.studentsApp.config;

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
 * The type Documentation config.
 *
 * @author Nestor Villar Lautero
 * @version 0.0.1 16/10/2019
 * @since 0.0.1 16/10/2019
 *
 */
@Configuration
@EnableSwagger2
public class DocumentationConfig {

    /**
     * Api docket.
     *
     * @return the docket
     * @author Nestor Villar Lautero
     * @version 0.0.1 28/11/2019
     * @since 0.0.1 12/11/2019
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.maker.studentsApp.web"))
                .paths(PathSelectors.regex("/.*"))
                .build().apiInfo(apiEndPointsInfo());
    }

    /**
     * @author Nestor Villar Lautero
     * @version 0.0.1 28/11/2019
     * @since 0.0.1 28/11/2019
     */
    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Student REST API - Makers")
                .description("API REST for microservice APP for Student entity .")
                .contact(new Contact("Nestor Villar", "nothing", "nothing@gmail.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }

}
