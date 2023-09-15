package com.example.java8to11.functional_Interface;

@FunctionalInterface
public interface RunSomething {
    void doIt();

    // @FunctionalInterface 를 사용하려면 추상메소드가 하나여야 한다.
    // void doItAgain();

    static void printName() {
        System.out.println("name");
    }

    default void printAge() {
        System.out.println("age");
    }
}
