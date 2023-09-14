package com.example.java8to11.default_methods;

public class App {
    public static void main(String[] args) {
        Foo foo = new DefaultFoo("user");
        foo.printName();
        foo.printNameUpperCase();

        Foo.printAnything();
    }
}
