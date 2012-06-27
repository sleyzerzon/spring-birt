package org.eclipse.birt.spring.example;

import org.eclipse.birt.spring.core.BirtEngineFactory;
import org.eclipse.birt.spring.core.BirtView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;

/**
 * @author
 */
@EnableWebMvc
@ComponentScan(basePackageClasses = {BirtWebConfiguration.class})
@Configuration
public class BirtWebConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/reports").setViewName("birtView");
    }

    @Bean
    public BirtView birtView() {
        BirtView view = new BirtView();
        view.setBirtEngine(this.engine().getObject());
        return view;
    }

    @Bean
    public BeanNameViewResolver beanNameResolver() {
        return new BeanNameViewResolver();
    }

    @Bean
    public BirtEngineFactory engine() {
        return new BirtEngineFactory();
    }


} 