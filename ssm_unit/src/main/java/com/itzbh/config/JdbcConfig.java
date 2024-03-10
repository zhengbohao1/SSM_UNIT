package com.itzbh.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;


    public class JdbcConfig {
        @Value("com.mysql.cj.jdbc.Driver")
        private String driver;
        @Value("jdbc:mysql:///mybatis?useSSL=false")
        private String url;
        @Value("root")
        private String userName;
        @Value("123456")
        private String password;

        @Bean
        public DataSource dataSource(){
            DruidDataSource ds=new DruidDataSource();
            ds.setDriverClassName(driver);
            ds.setUrl(url);
            ds.setUsername(userName);
            ds.setPassword(password);
            return ds;
        }
    }


