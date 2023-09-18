package com.example.doItJava.ch15_thread;

class MyBlockTest {
    // 공유객체
    MyClass myClass = new MyClass();
    // 3개의 쓰레드 필드 생성
    Thread t1 = new Thread("thread1") {
        public void run() {
            myClass.syncMethod();
        }

    };

    Thread t2 = new Thread("thread2") {
        public void run() {
            myClass.syncMethod();
        }

    };

    Thread t3 = new Thread("thread3") {
        public void run() {
            myClass.syncMethod();
        }

    };

    void startAll() {
        t1.start();
        t2.start();
        t3.start();
    }

    class MyClass {
        synchronized void syncMethod() {
            // 쓰레드 시작 준비시간
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            System.out.println("====" + Thread.currentThread().getName() + "====");
            System.out.println("thread1->" + t1.getState());
            System.out.println("thread2->" + t2.getState());
            System.out.println("thread3->" + t3.getState());
            for (long i = 0; i < 10000000000L; i++) {
            } // 시간지연
        }
    }
}

public class EX20_BlockedState {
    public static void main(String[] args) {
        MyBlockTest myBlockTest = new MyBlockTest();
        myBlockTest.startAll();
    }
}
