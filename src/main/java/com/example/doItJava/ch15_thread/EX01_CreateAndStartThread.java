package com.example.doItJava.ch15_thread;

/**
 * Thread 클래스를 상속받아 클래스를 정의하고 객체를 생성한 후 thread 2개 생성
 */
class SMIFileThread extends Thread {
    @Override
    public void run() {
        String[] strArray = {"하나", "둘", "셋", "넷", "다섯"};
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }

        //자막번호 출력
        for (String str : strArray) {
            System.out.println("- (자막번호) " + str);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
        }
    }
}

public class EX01_CreateAndStartThread {

    public static void main(String[] args) {

        Thread smiFiThread = new SMIFileThread();
        smiFiThread.start();

        int[] intArray = {1, 2, 3, 4, 5};

        for (int i = 0; i < intArray.length; i++) {
            System.out.println("(비디오프레임) " + intArray[i]);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
        }

    }
}
