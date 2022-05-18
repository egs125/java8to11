package com.example.java8to11;

@FunctionalInterface
public interface RunSomething {

    // 추상 메소드가 하나만 있으면 함수형 인터페이스. abstract 키워드 생략 가능
    abstract void doIt();

    // 다른 형태의 메소드가 있어도 추상 메소드가 하나만 있다면 함수형 인터페이스
    static void printName() {
        System.out.println("ok");
    }

    default void printAge() {
        System.out.println("33333");
    }
}
