package com.example.doItJava.ch15_thread;

// Runnable 인터페이스를 상속해 클래스를 생성한 후 쓰레도 2개 생성
public class EX03_CreateAndStartThread {
    public static void main(String[] args) {
        Runnable smiFileRunnable = new SMIFileRunnable();
        Thread thread = new Thread(smiFileRunnable);
        thread.start();

        // 비디오 프레임 번호 1~5
        int[] intArray = {1, 2, 3, 4, 5};

        for (int i : intArray) {
            System.out.println("(비디오 프레임) " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
        }
    }
}

// Runnable 인터페이스를 상속해 클래스를 생성한 후 쓰레드 2개 생성
class SMIFileRunnable implements Runnable {
    @Override
    public void run() {
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


