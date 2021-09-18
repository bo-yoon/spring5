package com.chap03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainForAssembler {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            System.out.println("명령어를 입력하세요");
            String comand = reader.readLine();
            if ( comand.equalsIgnoreCase("exit")) {
                System.out.println("종료합니다.");
                break;
            }
            if ( comand.startsWith("new")) {
                processNewCommand(comand.split(" "));
                continue;
            } else if(comand.startsWith("change")) {
                processChangeCommand(comand.split(" "));
                continue;
            }


        }
    }

    private static Assembler assembler = new Assembler();

    private static void processChangeCommand(String[] s) {
        if( s.length != 4 ) {
            printHelp();
            return;
        }
        ChangePasswordService changePwdSvc =
                assembler.getChangePasswordService();
        try {
            changePwdSvc.changePassword(s[1], s[2], s[3]);
            System.out.println("암호를 변경했습니다.");
        } catch (MemberNotFoundException e) {
            System.out.println("존재하지 않는 이메일입니다.");
        } catch (WrongIdPasswordException e) {
            System.out.println("이메일과 암호가 일치하지 않습니다.");
        }

    }

    private static void printHelp() {
        System.out.println();
        System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요");
        System.out.println("명령어 사용법 : ");
        System.out.println("new 이메일 이를 암호 암호확인");
        System.out.println("change 이메일 현재 비번 변경 비번");
        System.out.println();
    }

    private static void processNewCommand(String[] s) {
        if(s.length != 5 ) {
            printHelp();
            return;
        }
        MemberRegisterService reqSvc
                = assembler.getMemberRegisterService();
        RegisterRequest req = new RegisterRequest();
        req.setEmail(s[1]);
        req.settName(s[2]);
        req.setPassword(s[3]);
        req.setConfirmPassword(s[4]);

        if(!req.isPasswordEqualToConfirmPassword()) {
            System.out.println("암호와 확인이 일치하기 않습니다.");
            return;
        }
        try {
            reqSvc.regist(req);
            System.out.println("등록했습니다. ");
        } catch (DuplicateMemberException e) {
            System.out.println("이미 존재하는 이메일입니다.");
        }

    }


}
