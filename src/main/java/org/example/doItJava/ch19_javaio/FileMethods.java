package com.example.doItJava.ch19_javaio;

import java.io.File;

public class FileMethods {

    public static void main(String[] args) {
        // C드라이브 내에 temp 폴더가 없을 때 생성
        File tempDir = new File("C:/temp");
        if (!tempDir.exists())
            tempDir.mkdir();
        // 1. 파일 객체 생성
        File file = new File("C:/Windows");
        // 2. 파일 메서드
        System.out.println("절대 경로: " + file.getAbsolutePath());
        System.out.println("폴더인가?: " + file.isDirectory());
        System.out.println("파일인가?: " + file.isFile());
        System.out.println("파일/폴더명: " + file.getName());
        System.out.println("부모폴더: " + file.getParent());

        File newFile1 = new File("C:/temp/abc");
        // 기존에 없던 폴더를 새롭게 생성할때는 true, 폴더를 생성할 수 없거나 폴더가 이미 있으면 false 리턴턴
        System.out.println(newFile1.mkdir());
        File newFile2 = new File("C:/temp/bcd/cde");
        System.out.println(newFile2.mkdir());
        System.out.println(newFile2.mkdir());
        File[] fnames = file.listFiles();
        for(File fname: fnames){
            System.out.println((fname.isDirectory()?"폴더: " : "파일: ") + fname.getName());
        }

    }
}
