package com.chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;



public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppContext.class);
        Greater g1 = ctx.getBean("greater", Greater.class);
        Greater g2 = ctx.getBean("greater", Greater.class);
        System.out.println("(g1 == g2) = " + (g1 == g2));
        ctx.close();
    }
}
