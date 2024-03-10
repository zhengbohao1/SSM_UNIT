package com.itzbh.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"com.itzbh.Controller"})
@EnableWebMvc
@Import(SpringMvcSupport.class)
public class SpringMvcConfig {
}
