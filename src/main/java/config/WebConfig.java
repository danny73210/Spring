package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

//finding web files configurer
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "controller")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver getViewResolver(){
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
        //set order for loading (1 - loading from the begining)
        freeMarkerViewResolver.setOrder(1);
        freeMarkerViewResolver.setSuffix(".ftl");
        freeMarkerViewResolver.setPrefix("");
        return freeMarkerViewResolver;
    }

    //Instead of setPrefix
    @Bean
    public FreeMarkerConfigurer getFreeMarkerConfigurer(){
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        //freemarker and spring-context-support dependencies needed for setTemplateLoaderPaths
        freeMarkerConfigurer.setTemplateLoaderPaths("/", "/WEB-INF/views/");
        return freeMarkerConfigurer;
    }
}
