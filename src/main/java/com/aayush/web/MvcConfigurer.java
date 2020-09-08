/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aayush.web;

import javax.sql.DataSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
/**
 *
 * @author dell
 */
@Configuration
@ComponentScan(basePackages= "com.aayush.web")
@EnableWebMvc
public class MvcConfigurer extends WebMvcConfigurerAdapter{

    /*@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("WEB-INF/views/index.jsp");
    }*/
       
        @Bean 
        public DataSource getDataSource(){
            DriverManagerDataSource ds=new DriverManagerDataSource();
            ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
            ds.setUrl("jdbc:mysql://localhost/cmj18001");
            ds.setUsername("root");
            ds.setPassword("");
            return ds;
        }       
        
        @Bean
        public JdbcTemplate getJdbcTemplate(){
             return new JdbcTemplate(getDataSource());
        }
           
        @Bean
        public InternalResourceViewResolver getViewResolver(){
            InternalResourceViewResolver vr=
                    new InternalResourceViewResolver("/WEB-INF/views/",".jsp");
            return vr;
        }
   
}