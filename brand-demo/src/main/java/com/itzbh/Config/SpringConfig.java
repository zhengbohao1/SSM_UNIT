package com.itzbh.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({"com.itzbh.mapper","com.itzbh.service","com.itzbh.pojo"})
@Import({JdbcConfig.class, MybatisConfig.class})
public class SpringConfig {
}
