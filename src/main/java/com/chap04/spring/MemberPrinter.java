package com.chap04.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class MemberPrinter {

    private DateTimeFormatter dateTimeFormatter;

    public MemberPrinter() {
        dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY년 MM월 dd일");
    }

    public void print(Member member) {
        if(dateTimeFormatter == null) {
            System.out.printf(
                    "회원정보 : 아이디 =%d, 이메일=%s, 이름=%s, 등록일=%tF\n",
                    member.getId(), member.getEmail(),
                    member.getName(), member.getRegisterDateTime()
            );
        } else {
            System.out.printf(
                    "회원정보 : 아이디 =%d, 이메일=%s, 이름=%s, 등록일=%s \n",
                    member.getId(), member.getEmail(),
                    member.getName(), dateTimeFormatter.format(member.getRegisterDateTime())
            );
        }
    }

    // 1. Autowired 는 기본적으로 해당 타입의 빈이 존재하지않으면 익셉션을 발생시키지만, 필수가 아닌경우 false 를 지정하면 된다..
    // @Autowired(required = false)
    // 2. 혹은 자바 8 이상 부터는 Optional 을 사용해도 된다
    // 3. Nullable 어노테이션을 사용할 수도 있다.
//    @Autowired
//    private void setDateTimeFormatter(Optional<DateTimeFormatter> formatterOptional) {
//
//        if (formatterOptional.isPresent()) {
//            this.dateTimeFormatter = formatterOptional.get();
//        } else {
//            this.dateTimeFormatter = null;
//        }
//     //   this.dateTimeFormatter = dateTimeFormatter;
//    }
   // @Autowired(required = false)
    @Autowired
    private void setDateTimeFormatter( @Nullable DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }
}
