package com.chap07;

public class MainProxy {
    public static void main(String[] args) {
        ExeTimeCalculator ttCal1 = new ExeTimeCalculator(new ImpeCalculator());
        System.out.println(ttCal1.factorial(20));

        ExeTimeCalculator tt2Cal2 = new ExeTimeCalculator(new RecCalculator());
        System.out.println(tt2Cal2.factorial(20));
    }
}
