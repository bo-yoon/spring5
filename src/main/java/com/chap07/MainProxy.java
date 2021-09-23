package com.chap07;

import com.chap07.src.ExeTimeCalculator;
import com.chap07.src.ImpeCalculator;
import com.chap07.src.RecCalculator;

public class MainProxy {
    public static void main(String[] args) {
        ExeTimeCalculator ttCal1 = new ExeTimeCalculator(new ImpeCalculator());
        System.out.println(ttCal1.factorial(20));

        ExeTimeCalculator tt2Cal2 = new ExeTimeCalculator(new RecCalculator());
        System.out.println(tt2Cal2.factorial(20));
    }
}
