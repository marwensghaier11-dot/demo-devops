package com.example.user_crud.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Gestion des Utilisateurs")
                        .version("1.0.0")
                        .description("API REST pour la gestion des utilisateurs - Projet Fédérateur")
                        .contact(new Contact()
                                .name("Équipe Développement")
                                .email("dev@example.com")
                                .url("https://github.com/votre-repo"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")))
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Serveur Local"),
                        new Server().url("https://api.example.com").description("Serveur Production")
                ));
    }
}