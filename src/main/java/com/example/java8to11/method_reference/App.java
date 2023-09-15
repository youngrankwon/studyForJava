package com.example.java8to11.method_reference;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {

    public static void main(String[] args) {
        Function<Integer, String> intToString = (i) -> "number";
        System.out.println(intToString.apply(10));

        UnaryOperator<String> hi = (s) -> "hi " + s;
        System.out.println(hi.apply("user"));

        // static 메소드 참조
        // 타입::스태틱메소드
        UnaryOperator<String> hi2 = Greeting::hi;
        System.out.println(hi2.apply("user2"));

        // 특정 객체의 인스턴스 메소드 참조
        // 객체 레퍼런스::인스턴스 메소드
        Greeting greeting = new Greeting();
        UnaryOperator<String> hi3 = greeting::hello;

        // 생성자 참조
        // 타입::new
        // 생성자 매개변수가 있음
        Function<String, Greeting> userGreeting = Greeting::new;
        Greeting user = userGreeting.apply("user");
        System.out.println(user.getName());

        // 생성자 매개변수가 없음
        Supplier<Greeting> newGreeting = Greeting::new;

        String[] names = {"user3", "user2", "user1"};
        // 람다 변환 전
//        Arrays.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return 0;
//            }
//        });

        // 람다 변환 후
//        Arrays.sort(names, (o1, o2) -> 0);

        // sort
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));


    }
}
