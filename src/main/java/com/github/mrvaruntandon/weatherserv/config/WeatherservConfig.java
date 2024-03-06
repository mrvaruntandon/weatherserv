package com.github.mrvaruntandon.weatherserv.config;

import com.github.mrvaruntandon.weatherserv.interceptor.MdcLoggingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WeatherservConfig implements WebMvcConfigurer {

    @Autowired
    MdcLoggingInterceptor mdcLoggingInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(mdcLoggingInterceptor);
    }
}
