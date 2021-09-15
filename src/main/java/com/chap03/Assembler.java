package com.chap03;

public class Assembler {
    private MemberDao memberDao;
    private MemberRegisterService reSvc;
    private ChangePasswordService pwdSvc;

    public Assembler() {
        memberDao = new MemberDao();
        reSvc = new MemberRegisterService(memberDao);
        pwdSvc = new ChangePasswordService();
        pwdSvc.setMemberDao(memberDao);
    }

    public MemberDao getMemberDao() {
        return memberDao;
    }

    public MemberRegisterService getMemberRegisterService() {
        return reSvc;
    }

    public ChangePasswordService getChangePasswordService() {
        return pwdSvc;
    }
}
