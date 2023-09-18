package com.example.doItJava.ch15_thread;

/**
 * wait(), notify()를 이용한 쓰레드의 교차 실행
 */
public class EX22_Waiting_WaitNotify_2 {
    public static void main(String[] args) {
        DataBox22 dataBox = new DataBox22();
        Thread t1 = new Thread(() -> {
            for (int i = 1; i < 9; i++) {
                dataBox.inputData(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i < 9; i++) {
                dataBox.outputData();
            }
        });

        t1.start();
        t2.start();
    }
}

class DataBox22 {
    boolean isEmpty = true;
    int data;

    synchronized void inputData(int data) {
        if (!isEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {
            } // WAITING
        }
        this.data = data;
        isEmpty = false;
        System.out.println("입력 데이터: " + data);
        notify();
    }

    synchronized void outputData() {
        if (isEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {
            } // WAITING
        }
        isEmpty = true;
        System.out.println("출력 데이터: " + data);
        notify();
    }
}