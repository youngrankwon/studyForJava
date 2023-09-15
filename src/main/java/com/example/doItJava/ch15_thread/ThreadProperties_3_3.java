package com.example.doItJava.ch15_thread;

// 데몬 쓰레드는 자신을 호출한 주 쓰레드가 종료되면 함께 종료되는것이 아니다.
// 데몬 쓰레드는 주 쓰레드가 아니라 프로세스내의 모든 일반 쓰레드가 종료되어야 종료된다
// 여기서는 일반 쓰레드인 thread1 이 아직 끝나지 않았기 때문에 지속된다.
public class ThreadProperties_3_3 {
    public static void main(String[] args) {

        // 일반 쓰레드
        Thread thread1 = new MyThread3_3();
        thread1.setDaemon(false); // 일반 쓰레드로 설정
        thread1.setName("thread1");
        thread1.start();

        // 데몬 쓰레드
        Thread thread2 = new MyThread3_3(); // 모든 일반 쓰레드가 중지되어야 종료됨
        thread2.setDaemon(true);
        thread2.setName("thread2");
        thread2.start();

        // 3.5초 후 main 쓰레드 종료
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            System.out.println("main Thread 종료");
        }
    }
}

class MyThread3_3 extends Thread {
    @Override
    public void run() {
        System.out.println(getName() + ": " + (isDaemon() ? "데몬 쓰레드" : "일반 쓰레드"));
        for (int i = 0; i < 6; i++) {
            System.out.println(getName() + ": " + i + "초");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}


