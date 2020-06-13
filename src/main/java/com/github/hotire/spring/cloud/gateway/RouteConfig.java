package com.github.hotire.spring.cloud.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                      .route(p -> p.path("/get").uri("https://www.naver.com/"))
                      .route("naver", r -> r.path("/naver")
                                                .filters(f -> f.rewritePath("naver", ""))
                                                .uri("https://www.naver.com"))
                      .route(r -> r.path("/daum/**")
                                   .filters(f -> f.rewritePath("daum", ""))
                                   .uri("https://www.daum.net")
                                   .id("daum"))
                      .build();
    }
}
