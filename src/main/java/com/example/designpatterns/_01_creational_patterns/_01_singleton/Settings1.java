package com.example.designpatterns._01_creational_patterns._01_singleton;

/**
 * 싱글톤패턴 구현방법
 * 1. private 생성자와 public static 메소드를 사용하는 방법
 * 
 * 설명할 것
 * 1. 생성자를 private으로 만든 이유
 * 2. getInstance() 메소드를 static으로 선언한 이유
 * 3. getInstance() 가 멀티쓰레드 환경에서 안전하지 않은 이유
 */
public class Settings1 {
    private static Settings1 instance;

    private Settings1() {}

    public static Settings1 getInstance() {
        if(instance == null) {
            instance = new Settings1();
        }
        return instance;
    }
}
