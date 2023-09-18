package com.example.doItJava.ch15_thread;

// RUNNABLE 상태에서 yield() 메서드를 이용한 CPU 사용 양보
class MyThread17 extends Thread {
    boolean yieldFlag;

    @Override
    public void run() {
        while (true) {
            if (yieldFlag) {
                Thread.yield();     // yieldFlag 가 true 이면 다른 쓰레드에게 CPU 사용권을 양보
            } else {
                System.out.println(getName() + " 실행");
                // 시간 지연
                for (long i = 0; i < 1000000000L; i++) {

                }
            }
        }
    }
}

public class EX17_YieldInRunnableState {
    public static void main(String[] args) {
        MyThread17 thread1 = new MyThread17();
        thread1.setName("thread1");
        thread1.yieldFlag = true;
        thread1.setDaemon(true);
        thread1.start();

        MyThread17 thread2 = new MyThread17();
        thread2.setName("thread2");
        thread2.yieldFlag = false;
        thread2.setDaemon(true);
        thread2.start();

        // 6초 지연(1초마다 한 번씩 양보)
        for (int i = 0; i < 6; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            thread1.yieldFlag = !thread1.yieldFlag;
            thread2.yieldFlag = !thread2.yieldFlag;
        }
    }
}
