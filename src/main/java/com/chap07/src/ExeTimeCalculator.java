package com.chap07.src;


import com.chap07.src.Calculator;

public class ExeTimeCalculator implements Calculator {

    private Calculator delegate ;

    public ExeTimeCalculator(Calculator delegate) {
        this.delegate =delegate;
    }


    @Override
    public long factorial(long num) {
        long start = System.nanoTime();
        long res = delegate.factorial(num);
        long end = System.nanoTime();

        System.out.printf("%s.factorial(%d) 실행 시간 = %d\n", delegate.getClass().getSimpleName()
        , num, (end - start));

        return res;
    }
}
