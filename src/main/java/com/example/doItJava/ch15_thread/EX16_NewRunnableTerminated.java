package com.example.doItJava.ch15_thread;

// 쓰레드 상태(NEW, RUNNABLE, TERMINATED)
public class EX16_NewRunnableTerminated {
    public static void main(String[] args) {
        // 쓰레드 상태 저장 클래스
        Thread.State state;

        // 1. 객체 생성(NEW)
        Thread myThread = new Thread(() -> {
            // 시간지연
            for (long i = 0; i < 100000000L; i++) {
            }
        });
        state = myThread.getState();
        System.out.println("myThread state = " + state);

        // 2. myThread 시작
        myThread.start();
        state = myThread.getState();
        System.out.println("myThread state = " + state);

        // 3. myThread 종료
        try {
            myThread.join();    // myThread 실행이 완료될 때 까지 메인 쓰레드 일시 정지
        } catch (InterruptedException e) {
        }
        state = myThread.getState();
        System.out.println("myThread state = " + state);
    }
}
