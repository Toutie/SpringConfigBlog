package com.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import org.thymeleaf.templatemode.TemplateMode;

/**springMvc相关配置
 * //<bean></bean>@Configuration
 * @ComponentScan <context:comson></>
 * @author wang
 */

@Configuration
@ComponentScan(basePackages = {"com.config","com.controller","com.service"},
includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
classes = {Controller.class, RestController.class, ControllerAdvice.class,EnableWebMvc.class})},
excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
classes = {Service.class, Repository.class})})
@EnableWebMvc
public class MvcConfig  implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:static/");
        registry.addResourceHandler("file:d:/upload/")
                .addResourceLocations("/pics/**");

    }

    @Bean
    public SpringResourceTemplateResolver templateResolver(){
        SpringResourceTemplateResolver resourceTemplateResolver = new SpringResourceTemplateResolver();
        resourceTemplateResolver.setPrefix("classpath:templates/");
        resourceTemplateResolver.setSuffix(".html");
        resourceTemplateResolver.setCharacterEncoding("UTF-8");
        resourceTemplateResolver.setTemplateMode(TemplateMode.HTML);
        //开发时为false
        resourceTemplateResolver.setCacheable(false);
        return resourceTemplateResolver;
    }

    @Bean("engine")
    public SpringTemplateEngine springTemplateEngine(SpringResourceTemplateResolver templateResolver){

        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafReactiveViewResolver(@Qualifier("engine") SpringTemplateEngine springTemplateEngine){
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(springTemplateEngine);
       viewResolver.setCharacterEncoding("UTF-8");
        return  viewResolver;
    }


}
