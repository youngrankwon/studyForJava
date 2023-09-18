package com.example.doItJava.ch15_thread;

class MyThread19 extends Thread {
    @Override
    public void run() {
        // 시간지연
        for (long i = 0; i < 10000000000L; i++) {
        }
    }
}

class MyThread19_2 extends Thread {
    MyThread19 myThread;

    public MyThread19_2(MyThread19 myThread) {
        this.myThread = myThread;
    }

    @Override
    public void run() {
        try {
            myThread.join(3000);
        } catch (InterruptedException e) {
            System.out.println(" -- join(...) 진행 중 interrupt() 발생");
            // 시간 지연
            for (long i = 0; i < 10000000000L; i++) {
            }
        }
    }
}

public class EX19_TimedWaiting_Join {
    public static void main(String[] args) {
        //객체 생성
        MyThread19 myThread19 = new MyThread19();
        MyThread19_2 myThread19_2 = new MyThread19_2(myThread19);
        myThread19.start();
        myThread19_2.start();

        try {
            // Thread 준비시간
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }

        System.out.println("MyThread19 State1 = " + myThread19.getState());
        System.out.println("MyThread19_2 State1 = " + myThread19_2.getState());

        // TIMED_WAITING
        myThread19_2.interrupt(); // TIMED_WAITING -> RUNNABLE 상태 전환
        try {
            // 인터럽트 준비시간
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        System.out.println("MyThread19 State2 = " + myThread19.getState());
        System.out.println("MyThread19_2 State2 = " + myThread19_2.getState());

    }
}
