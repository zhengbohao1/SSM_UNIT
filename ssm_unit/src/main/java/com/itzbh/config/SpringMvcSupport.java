package com.itzbh.config;

import com.itzbh.Controller.Interceptor.Userinterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {
    @Autowired
    private Userinterceptor userinterceptor;
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //拦截springmvc的过度管理
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/element-ui/**").addResourceLocations("/element-ui/");
        registry.addResourceHandler("/imgs/**").addResourceLocations("/imgs/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");

        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userinterceptor).addPathPatterns("/pages/**");
        registry.addInterceptor(userinterceptor).addPathPatterns("/ssm_unit_war/**");
    }
}
