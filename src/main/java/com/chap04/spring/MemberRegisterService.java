package com.chap04.spring;


import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;


public class MemberRegisterService {

    @Autowired
    private MemberDao memberDao;


    // 오토와이어드 어노테이션을 붙이고 기본 생성자 생성

    public MemberRegisterService() {

    }

    public MemberRegisterService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public Long regist(RegisterRequest req) {
        Member member = memberDao.selectByEmail(req.getEmail());
        if(member != null) {
            throw new DuplicateMemberException("dup email" + req.getEmail());
        }
        Member newMember = new Member(
                req.getEmail(), req.getPassword(), req.getName(),
                LocalDateTime.now());
        memberDao.insert(newMember);
        return newMember.getId();
    }

}
