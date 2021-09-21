package com.chap05.config;


import com.chap05.spring.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.chap05.spring"})
public class AppCtx {

    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }

    @Bean
    public MemberRegisterService memberRegSvc() {
        return new MemberRegisterService();
    }

    @Bean
    public ChangePasswordService changePwdSvc() {
       // ChangePasswordService pwdSvc = new ChangePasswordService();
        //pwdSvc.setMemberDao(memberDao());
        // 해당 클래스에 MemberDao에 Autowird 어노테이션을 추가했다 그래서 의존 주입이 필요 없다.
        return  new ChangePasswordService();
    }

    @Bean
    @Qualifier("printer")
    public MemberPrinter memberPrinter1() {
        return new MemberPrinter();
    }

    @Bean
    @Qualifier("summaryPrinter")
    public MemberSummaryPrinter memberPrinter2() {
        return new MemberSummaryPrinter();
    }
    // 그냥 사용하면 에러 발생 ---> MemberSummaryPrinter 가 memberPrinter을 상속을 받아서 이중 선언되었기 때문에
    // 부모 빈을 사용하는 메서드에 Qualifier 어노테이션을 사용해 그 객체를 사용하라 명시해주고
    // 부모객체 자식객체 의존 주입에도 같은 어노테이션으로 이름을 지정해준다.
    // 그리고 자식 객체를 사용하는 메서드에 자식객체를 사용하라고 Qualifier로 명시해준다..


    @Bean
    public MemberListPrinter listPrinter() {
        return new MemberListPrinter();
    }


    @Bean
    public MemberInfoPrinter infoPrinter() {
        MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
//        infoPrinter.setMemDao(memberDao());
        infoPrinter.setPrinter(memberPrinter2());
        return new MemberInfoPrinter();
    }

    @Bean
    public VersionPrinter versionPrinter() {
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(0);
        return versionPrinter;
    }
}

