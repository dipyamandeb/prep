package com.ms;

public class MyClass {

    public static void main(String[] args) {
        xyz(1);
//        java: method xyz(int) is already defined in class com.ms.MyClass
    }
    public static void xyz(int i) {
        System.out.println("1st Method");
    }

//    public static int xyz(int i) {
//        System.out.println("2nd Method");
//    }

    public static void xyz(char c) {
        System.out.println("3rd method");
    }
}
