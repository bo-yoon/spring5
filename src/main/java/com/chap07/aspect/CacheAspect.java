package com.chap07.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.HashMap;
import java.util.Map;

@Aspect
//@Order(2)
public class CacheAspect {

    private Map<Long, Object> cache = new HashMap<>();

    @Pointcut("execution(public * com.chap07.src..*(long))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        Long num = (Long) joinPoint.getArgs()[0];
        if(cache.containsKey(num)) {
            System.out.printf("CacheAspect: Cache에서 구함 [%d]\n", num);
            return cache.get(num);
        } else {
            Object res = joinPoint.proceed();
            cache.put(num, res);
            System.out.printf("CacheAspect: Cache에 추가 [%d]\n", num);
            return res;
        }
    }
}
