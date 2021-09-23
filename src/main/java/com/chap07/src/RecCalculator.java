package com.chap07.src;

import com.chap07.src.Calculator;

public class RecCalculator implements Calculator {
    @Override
    public long factorial(long num) {
        long start = System.currentTimeMillis();
        try {
            if (num == 0) {
                return 1;
            } else {
                return num * factorial(num - 1);
            }
        } finally {
            long end = System.currentTimeMillis();
            System.out.printf("ImpeCalculator.factorial(%d) 실행 시간 = %d\n", num, (end - start));

        }
    }
}
