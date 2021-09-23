package com.chap07;

public class ImpeCalculator implements Calculator{
    @Override
    public long factorial(long num) {
        long start = System.currentTimeMillis();
        long res =1;
        for(long i = 1; i <=num; i++){
            res *= i;
        }
        long end = System.currentTimeMillis();
        System.out.printf("ImpeCalculator.factorial(%d) 실행 시간 = %d\n", num, (end -start));
        return res;
    }
}
