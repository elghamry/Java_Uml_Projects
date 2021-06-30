package com.IsCharacter;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String s = "hello";
        String s1 = "hello123";
        boolean hasDigit = s.chars().allMatch(Character::isLetter);
        boolean hasDigit1 = s1.chars().allMatch(Character::isLetter);
                System.out.println(hasDigit);
        System.out.println(hasDigit1);
    }
}
