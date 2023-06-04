package EL.IBDA.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger2Config {

    @Bean
    public OpenAPI IBDAOpenApi() {
        return new OpenAPI()
                .info(new Info().title("IBDA BackEnd API")
                        .description("프로젝트 IBDA 백엔드API 명세서입니다."));
    }

}
