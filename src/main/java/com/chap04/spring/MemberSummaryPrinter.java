package com.chap04.spring;

public class MemberSummaryPrinter extends MemberPrinter {
// 상위, 하위 타입 관계와 자동 주입
    @Override
    public void print(Member member){
        System.out.printf(
                "회원 정보 : 이메일 = %s, 이름 = %s\n",
                member.getEmail(), member.getName()
       );
    }
}
