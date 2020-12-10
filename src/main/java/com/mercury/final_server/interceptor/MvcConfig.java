package com.mercury.final_server.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    // configuration class to configure Spring MVC

    @Autowired
    WhoAccessedInterceptor whoAccessedInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(whoAccessedInterceptor).addPathPatterns("/products", "samples");
    }
}
