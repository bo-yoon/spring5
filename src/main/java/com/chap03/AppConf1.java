package com.chap03;

import org.springframework.context.annotation.Bean;




public class AppConf1 {

    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }


    @Bean
    public MemberPrinter memberPrinter() {
        return new MemberPrinter();
    }

}
