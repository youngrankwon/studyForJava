package com.example.doItJava.ch15_thread;

// Thread.sleep() 메서드를 이용한 TIMED_WAITING과 interrupt()
// 쓰레드 시작과 동시에 3초 동안 일시정지 상태가 되는 MyThread 클래스를 정의하고
// main() 메서드에서는 MyThread 객체를 생성 및 실행시켰으며, 실행한 지 0.1초 후에 쓰레드의 상태를 출력
class MyThread18 extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(" -- sleep() 진행 중 interrupt() 발생");
            for (long i = 0; i < 10000000000L; i++) {
            }
        }
    }
}

public class EX18_TimedWaiting_Sleep {
    public static void main(String[] args) {
        MyThread18 myThread = new MyThread18();
        myThread.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        System.out.println("MYThread State = " + myThread.getState());
        // TIMED_WAITING
        myThread.interrupt(); //TIMED_WAITING -> RUNNABLE 상태 전환
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        System.out.println("MYThread State = " + myThread.getState());
    }
}
