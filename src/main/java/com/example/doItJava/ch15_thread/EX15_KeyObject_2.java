package com.example.doItJava.ch15_thread;

// 동기화 메서드와 동기화 블록이 다른 열쇠를 사용할 때
class MyData15 {
    synchronized void abc() {   // this 객체가 갖고 있는 하나의 열쇠를 함께 사용
        for (int i = 0; i < 3; i++) {
            System.out.println(i + "sec");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }
    }

    synchronized void bcd() {   // this 객체가 갖고 있는 하나의 열쇠를 함께 사용
        for (int i = 0; i < 3; i++) {
            System.out.println(i + "초");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }
    }

    void cde() {
        synchronized (new Object()) {   // Object 객체가 갖고있는 열쇠를 사용
            for (int i = 0; i < 3; i++) {
                System.out.println(i + "번째");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}

public class EX15_KeyObject_2 {
    public static void main(String[] args) {
        // 공유 객체
        MyData15 data = new MyData15();

        // 3개의 쓰레드가 각각의 메서드 호출
        new Thread(() -> data.abc()).start();

        new Thread(() -> data.bcd()).start();

        new Thread(() -> data.cde()).start();

    }

}
