package com.example.java8to11.default_methods;

public class DefaultFoo implements Foo {

    String name;

    public DefaultFoo(String name){
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

    @Override
    public String getName() {
        return this.name;
    }
}
