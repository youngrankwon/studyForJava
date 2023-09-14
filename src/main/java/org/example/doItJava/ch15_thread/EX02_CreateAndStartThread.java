package com.example.doItJava.ch15_thread;

/**
 * Thread 클래스를 상속해 클래스를 생성한 후 쓰레드 3개 생성
 */

class EX02_SMIFileThread extends Thread {
    @Override
    public void run() {
        String[] strArray = {"하나", "둘", "셋", "넷", "다섯"};
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // 자막 번호 출력
        for (int i = 0; i < strArray.length; i++) {
            System.out.println(" -(자막번호) " + strArray[i]);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class EX02_VideoFileThread extends Thread {
    @Override
    public void run() {
        // 비디오 프레임 번호 1~5
        int[] intArray = {1, 2, 3, 4, 5};

        // 비디오 프레임 번호 출력
        for (int i = 0; i < intArray.length; i++) {
            System.out.println("(비디오 프레임)" + intArray[i]);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
        }
    }
}

public class EX02_CreateAndStartThread {

    public static void main(String[] args) {
        // SMIFileThread 객체 생성 및 시작
        Thread smiFileThread = new SMIFileThread();
        smiFileThread.start();

        // VideoFileThread 객체 생성 및 시작
        Thread videoFileThread = new EX02_VideoFileThread();
        videoFileThread.start();
    }
}
