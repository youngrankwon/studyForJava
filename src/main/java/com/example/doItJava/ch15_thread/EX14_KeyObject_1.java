package com.example.doItJava.ch15_thread;


class MyData14 {
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
        synchronized (this) {   // this 객체가 갖고 있는 하나의 열쇠를 함께 사용
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

//3개의 동기화 영역이 동일한 열쇠로 동기화됐을 때
public class EX14_KeyObject_1 {
    public static void main(String[] args) {
        // 공유 객체
        MyData14 data = new MyData14();

        // 3개의 쓰레드가 각각의 메서드 호출
        new Thread() {
            public void run() {
                data.abc();
            }

        }.start();

        new Thread() {
            public void run() {
                data.bcd();
            }

        }.start();

        new Thread() {
            public void run() {
                data.cde();
            }

        }.start();

    }

}
