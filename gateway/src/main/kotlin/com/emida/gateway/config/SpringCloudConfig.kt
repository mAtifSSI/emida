package com.emida.gateway.config

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec
import org.springframework.cloud.gateway.route.builder.PredicateSpec
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SpringCloudConfig {
    @Bean
    open fun routeLocator(routeLocatorBuilder: RouteLocatorBuilder): RouteLocator? {
        return routeLocatorBuilder.routes()
                .route { r: PredicateSpec ->
                    r
                            .path("/accounts/**")
                            //.filters { filters: GatewayFilterSpec -> filters.addResponseHeader("testHeaderName", "testHeaderValue") }
                            .uri("http://localhost:8084/accounts/")
                }
                .build()
    }
}