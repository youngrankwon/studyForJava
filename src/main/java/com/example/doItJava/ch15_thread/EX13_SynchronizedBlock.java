package com.example.doItJava.ch15_thread;

// 메서드 전체 중에 동기화가 필요한 부분이 일부분이라면 블록 동기화를 사용한다.

//공유객체
class MyData13 {
    int data = 3;

    public void plusData() {
        synchronized (this) {
            int data = this.data;
            try { Thread.sleep(2000);} catch(InterruptedException e) {}
            this.data = data + 1;
        }
    }
}

class PlusThread13 extends Thread {
    MyData13 myData;
    public PlusThread13(MyData13 data){
        this.myData = data;
    }

    @Override
    public void run() {
        myData.plusData();
        System.out.println(getName() + "실행 결과: " + myData.data);
    }
}
public class EX13_SynchronizedBlock {
    public static void main(String[] args) {
        // 공유 객체 생성
        MyData13 myData = new MyData13();

        // plusThread 1
        Thread plusThread1 = new PlusThread13(myData);
        plusThread1.setName("plusThread1");
        plusThread1.start();

        // plusThread 2
        Thread plusThread2 = new PlusThread13(myData);
        plusThread2.setName("plusThread1");
        plusThread2.start();
    }
}
