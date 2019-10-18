package com.algorithms;

public class StripComments {

    public static String stripComments(String text, String[] commentSymbols) {


        int start, finish;
        String newstr = "";
        System.out.println(text);
        System.out.println("+++++++++++");

        for (int j = 0; j < commentSymbols.length; j++) {
            if (text.contains(commentSymbols[j])) {
                start = text.indexOf(commentSymbols[j]) - 1;
                if (text.contains("\n") && text.indexOf("\n") > start) {
                    finish = text.indexOf("\n");
                } else {
                    finish = text.length();
                }

                if (start != finish) {
                    String begin = text.substring(0, start);
                    String end = text.substring(finish, text.length());

                    text = begin + end;
                } else {
                    text = "";
                }
                j--;
                System.out.println(text);
                System.out.println("-------------");
            } else {

            }
        }
        return text;
    }

    public static void main(String[] args) {
        stripComments("apples, pears # and bananas\ngrapes\nbananas !apples", new String[]{"#", "!"});
    }

}
