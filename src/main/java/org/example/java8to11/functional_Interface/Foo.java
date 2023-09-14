package com.example.java8to11.functional_Interface;

import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Foo {
    public static void main(String[] args) {

        // 기본형
        RunSomething runSomething = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("todo1");
            }
        };
        runSomething.doIt();

        // lambda - body 가 한줄이면 생략
        RunSomething lambda = () -> System.out.println("todo2");
        lambda.doIt();

        // lambda - body 가 한줄 이상일때
        RunSomething lambda2 = () -> {
            System.out.println("todo3");
            System.out.println("todo4");
        };
        lambda2.doIt();

        // return 값이 있는경우
        int baseNumber = 10;
        RunSomething2 runSomething2 = number -> number + baseNumber;
        System.out.println(runSomething2.doIt(10));

        // 자바에서 제공하는 함수형 인터페이스
        UnaryOperator<Integer> plus10 = (i) -> i + 10;
        System.out.println("plus10 : " + plus10.apply(20));

        UnaryOperator<Integer> multiply2 = (i) -> i * 2;
        System.out.println("multiply2 : " + multiply2.apply(2));
        System.out.println("plus10.andThen(multiply2) : " + plus10.andThen(multiply2).apply(2));

        Supplier<Integer> get10 = () -> 10;
        System.out.println("get10 : " + get10.get());

        BinaryOperator<Integer> sum = (a, b) -> a+b;
        System.out.println("sum : " + sum.apply(11, 12));

    }
}
