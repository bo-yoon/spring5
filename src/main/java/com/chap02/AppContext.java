package com.chap02;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

    @Bean
    public Greater greater() {
        Greater g = new Greater();
        g.setFormat("%s, 안녕하세요!");
        return g;
    }
}
