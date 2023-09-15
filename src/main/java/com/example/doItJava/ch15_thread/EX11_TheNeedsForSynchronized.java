package com.example.doItJava.ch15_thread;

// 공유 객체
class MyData2 {
    int data = 3;
    public void plusData() {
        int mydata = data;
        try {Thread.sleep(2000);} catch (InterruptedException e){}
        data = mydata + 1;
    }
}

// 공유 객체를 사용하는 쓰레드
class PlusThread2 extends Thread {
    MyData2 myData;
    public PlusThread2(MyData2 mydata){
        this.myData = mydata;
    }

    @Override
    public void run() {
        myData.plusData();
        System.out.println(getName() + "실행 결과: " + myData.data);
    }
}
public class EX11_TheNeedsForSynchronized {
    public static void main(String[] args) {
        // 공유 객체 생성
        MyData2 myData = new MyData2();

        // plusThread 1
        Thread plusThread1 = new PlusThread2(myData);
        plusThread1.setName("plusThread1");
        plusThread1.start();

        // plusThread 2
        Thread plusThread2 = new PlusThread2(myData);
        plusThread2.setName("plusThread1");
        plusThread2.start();
    }

}
