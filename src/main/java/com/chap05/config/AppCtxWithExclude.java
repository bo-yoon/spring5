package com.chap05.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {"com.chap05.config"},
        excludeFilters = @ComponentScan.Filter(type= FilterType.ASPECTJ, pattern = "com.chap05.config.*Dao"))
public class AppCtxWithExclude {
}
