package com.WriteFromConsoleToFile;

public class Main {

    public static void main(String[] args) {
        String string1 = "hello789";  String string2 ="hello29887";

        String longer = StringUtils.betterString(string1, string2, (s1, s2) -> s1.length() > s2.length());

        String first = StringUtils.betterString(string1, string2, (s1, s2) -> true);




        System.out.println(longer);
        System.out.println(first);

    }
}
