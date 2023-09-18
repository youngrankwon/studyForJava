package com.example.doItJava.ch15_thread;

/**
 * 동기화
 * 동기화 방법은 메서드 동기화와 블록 동기화로 나눌 수 있다.
 * 메서드 동기화: 2개의 쓰레드가 동시에 메서드를 실행 할 수 없음
 * --> 동기화 하고자 하는 메서드 리턴 타입 앞에 synchronized 키워드를 넣으면 된다.
 * 블록 동기화: 2개의 쓰레드가 동시에 해당 블록을 실행할 수 없음
 */

// 공유 객체
class MyData {
    int data = 3;

    public synchronized void plusData() {
        int mydata = data;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        data = mydata + 1;
    }
}

// 공유 객체를 사용하는 쓰레드
class PlusThread extends Thread {
    MyData myData;

    public PlusThread(MyData mydata) {
        this.myData = mydata;
    }

    @Override
    public void run() {
        myData.plusData();
        System.out.println(getName() + "실행 결과: " + myData.data);
    }
}

public class EX12_SynchronizedMethod {
    public static void main(String[] args) {
        // 공유 객체 생성
        MyData myData = new MyData();

        // plusThread 1
        Thread plusThread1 = new PlusThread(myData);
        plusThread1.setName("plusThread1");
        plusThread1.start();

        // plusThread 2
        Thread plusThread2 = new PlusThread(myData);
        plusThread2.setName("plusThread1");
        plusThread2.start();
    }

}
