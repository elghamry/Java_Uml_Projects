package com.WriteFromConsoleToFile;

import java.util.function.BiPredicate;

public class StringUtils {

    public static String betterString(String s1 , String s2 , BiPredicate<String,String> p ){

return p.test(s1,s2)?s1:s2;

    }
}