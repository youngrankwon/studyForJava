package com.example.java8to11.lambda;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class App {
    public static void main(String[] args) {
        App app = new App();
        app.run();

    }

    private void run() {
        // 로컬변수 캡쳐
        // effectively final : Java8에서 final이 붙지 않은 변수의 값이 변경되지 않는다면, 그 변수를 Effectively final 이라 한다.
        int baseNumber = 10;

        // 익명클래스에서 로컬변수 참조
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println("integerConsumer : " + baseNumber);
            }
        };
        integerConsumer.accept(11);

        // 로컬 클래스에서 로컬변수 참조
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 11;
                System.out.println("localClass : " + baseNumber);
            }
        }
        LocalClass localClass = new LocalClass();
        localClass.printBaseNumber();

        // 람다에서 로컬변수 참조
        // 섀도윙이 일어나지 않음
        IntConsumer printInt = (i) -> {
            System.out.println(i + baseNumber);
        };
        printInt.accept(10);
    }


}
