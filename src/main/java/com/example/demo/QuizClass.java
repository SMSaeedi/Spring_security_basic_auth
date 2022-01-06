package com.example.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuizClass {

    static String x;

    public static void main(String[] args) {
        x = "2 * 2";
        x = "2 + 2";
        x = "b + a";

        Pattern p = Pattern.compile("([*,+,-,/])+([0-9]+)");
        Matcher m = p.matcher(x);
        if (!m.find()) {
            x = "a+b";
            System.out.println("X contains chars: " + x);
        } else {
            if (p.equals("*")) {
                int mul = Integer.parseInt(x.substring(0, 1)) * Integer.parseInt(x.substring(4,5));
                System.out.println("mul operation is done: " + mul);
            }
            if(p.equals("+")){
                int mul = Integer.parseInt(x.substring(0, 1)) + Integer.parseInt(x.substring(4,5));
                System.out.println("mul operation is done: " + mul);
            }
        }

    }

    public static boolean isNumeric(String a) {
        int i;
        i = Integer.parseInt(a);
        return true;
    }
}
