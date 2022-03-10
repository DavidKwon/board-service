package kr.co.iclave.board.config.swagger;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi postsApi() {
        return GroupedOpenApi.builder()
                .group("board-service")
                .pathsToMatch("/front/boards/**")
                .build();
    }
}
