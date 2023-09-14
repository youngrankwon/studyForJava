package com.example.doItJava.ch15_thread;

// Runnable 인터페이스 상속 클래스를 생성한 후 쓰레드 3개 생성
class SMIFileRunnable04 implements Runnable {
    @Override
    public void run() {
        // 자막번호 하나 ~ 다섯
        String[] strArray = {"하나", "둘", "셋", "넷", "다섯"};
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
        for (int i = 0; i < strArray.length; i++) {
            System.out.println(" - (자막번호) " + strArray[i]);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
        }
    }
}

class VideoFileRunnable implements Runnable {
    @Override
    public void run() {
        // 비디오 프레임 번호 1~5
        int[] intArray = {1, 2, 3, 4, 5};

        // 비디오 프레임 번호 출력
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(" - (비디오 프레임) " + intArray[i]);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
        }
    }
}

public class EX04_CreateAndStartThread {
    public static void main(String[] args) {
        // SMIRunnable 객체 생성
        Runnable smiFileRunnable = new SMIFileRunnable04();
        // smiFileRunnable.start(); <- Runnable 객체에는 start() 메서드가 없어 오류 발생
        Thread thread1 = new Thread(smiFileRunnable);
        thread1.start();

        // VideoFileRunnable 객체 생성
        Runnable videoFileRunnable = new VideoFileRunnable();
        Thread thread2 = new Thread(videoFileRunnable);
        thread2.start();
    }
}
