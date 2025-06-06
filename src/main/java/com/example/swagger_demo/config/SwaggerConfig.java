package com.example.swagger_demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.media.StringSchema;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Swagger Demo API")
                        .description("스프링부트 + Swagger(OpenAPI) 샘플 프로젝트")
                        .version("v1.0.0"));
    }

    @Bean
    public OpenApiCustomizer globalHeaderOpenApiCustomizer() {
        return openApi -> {
            if (openApi.getPaths() != null) {
                openApi.getPaths().values().forEach(pathItem -> 
                    pathItem.readOperations().forEach(operation -> 
                        operation.addParametersItem(new Parameter()
                            .in("header")
                            .name("X-Auth-Token")
                            .description("사용자 인증을 위한 토큰")
                            .required(false)
                            .schema(new StringSchema())
                        )
                    )
                );
            }
        };
    }
}
