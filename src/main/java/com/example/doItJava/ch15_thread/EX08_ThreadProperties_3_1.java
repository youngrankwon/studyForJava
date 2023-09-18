package com.example.doItJava.ch15_thread;

// 3.5초 동안 지속되는 main 쓰레드 내에서 5초 동안 지속하는 MyThread 객체를 생성 및 실행
// MyThread 가 일반 쓰레드인 경우 main thread 가 종료되어도 자신의 실행이 끝날 때까지 계속 지속된다.
class MyThread3 extends Thread {
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

public class EX08_ThreadProperties_3_1 {
    public static void main(String[] args) {

        // 일반 쓰레드
        Thread thread1 = new MyThread3();
        thread1.setDaemon(false); // 일반 쓰레드로 설정
        thread1.setName("thread1");
        thread1.start();

        // 3.5초 후 main 쓰레드 종료
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
        }
        System.out.println("main Thread 종료");
    }

}
