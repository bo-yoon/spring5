package com.chap03;

public class MemberPrinter {

    public void print(Member member) {
        System.out.printf(
                "회원정보 : 아이디 =%d, 이메일=%s, 이름=%s, 등록일=%tFWn",
                member.getId(), member.getEmail(),
                member.getName(), member.getRegisterDateTime()
        );
    }
}
