package com.example.java8to11;

public interface Foo {

    void printName();

    /*
    기본 메소드 : default 키워드 추가.
            인터페이스에 메소드 선언이 아니라 구현체를 제공
            Foo를 상속받은 클래스들이 아래 메소드를 override할 필요 없음.
            Foo를 상속받은 클래스들에게 모두 동일한 기능 제공 가능
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

    String getName();

    // 스태틱 메소드
    static void printAnything() {
        System.out.println("Foo!");
    }
}
