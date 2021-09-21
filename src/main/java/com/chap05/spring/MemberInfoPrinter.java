package com.chap05.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component("infoPrinter")
public class MemberInfoPrinter {

    private MemberDao memDao;
    private MemberPrinter printer;

    public void printMemberInfo(String email) {
        Member member = memDao.selectByEmail(email);
        if( member == null) {
            System.out.println("데이터 없음\ns");
            return;
        }
        printer.print(member);
        System.out.println();
    }

    @Autowired
    public void setMemDao(MemberDao memberDao) {
        this.memDao = memberDao;
    }

    @Autowired
    @Qualifier("printer") // 자식 객체랑 햇갈리지 않기 위해...
    public void setPrinter(MemberPrinter printer) {
        this.printer = printer;
    }

}
