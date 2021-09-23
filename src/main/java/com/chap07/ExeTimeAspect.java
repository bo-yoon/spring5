package com.chap07;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Aspect
public class ExeTimeAspect {

    // 적용할 대상
    @Pointcut("execution(public * com.chap07..*(..))")
    private void publicTarget() {

    }


    //
    @Around("publicTarget()")
    public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        try {
            Object res = joinPoint.proceed();
            return res;
        } finally {
            long finish = System.nanoTime();
            Signature sig = joinPoint.getSignature();
            System.out.printf("%s. %s(%s) 실행시간 : %d ns\n",
                    sig.getName(), Arrays.toString(joinPoint.getArgs()), (finish - start));
        }
    }
}
