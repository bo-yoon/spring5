package com.chap02;


import org.springframework.stereotype.Component;

//                  s@Component
public class Greater {
    private String format;

    public String great(String guest) {
        return String.format(format, guest);
    }
    public void setFormat(String format) {
        this.format = format;
    }
}
