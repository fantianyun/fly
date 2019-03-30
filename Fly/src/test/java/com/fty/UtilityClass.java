package com.fty;

public class UtilityClass {
    private UtilityClass() {
        throw new AssertionError();
    }

    public static void main(String[] args) {
        System.out.println(new UtilityClass());
        Math.abs(1);
    }
}
