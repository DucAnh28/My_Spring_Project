package ducanh.pro.gateway;

import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route("auth-service", r -> r.path("/auth/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("http://localhost:2001"))
                .route("music-service", r -> r.path("/music/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("http://localhost:2000"))
                .build();
    }
}
