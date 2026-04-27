package com.project.school_manager.core.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("School Manager API")
                        .version("1.0")
                        .description("Sistema de Gestão Escolar - Coordenadorias, Escolas, Professores e Alunos")
                        .contact(new Contact()
                                .name("Seu Nome")
                                .email("seu@email.com")));
    }
}