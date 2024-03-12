package com.itzbh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //拦截springmvc的过度管理
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/element-ui/**").addResourceLocations("/element-ui/");
        registry.addResourceHandler("/imgs/**").addResourceLocations("/imgs/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");

        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
    }
}
