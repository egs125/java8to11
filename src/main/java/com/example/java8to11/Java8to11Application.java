package com.example.java8to11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.*;

@SpringBootApplication
public class Java8to11Application {

	// 함수형 인터페이스
	/*
	public static void main(String[] args) {

		RunSomething runSomething = () -> System.out.println("Hello");

		// 익명 내부 클래스 anonymous inner class. 위와 동일
		RunSomething runSomething = new RunSomething() {
			@Override
			public void doIt() {
				System.out.println("Hello");
			}
		};

		SpringApplication.run(Java8to11Application.class, args);

		Plus10 plus10 = new Plus10();
		System.out.println(plus10.apply(1));

		Function<Integer, Integer> plus10 = number -> number + 10;
		System.out.println(plus10.apply(1));

		// 입력값이 하나일 때
		UnaryOperator<Integer> _plus10 = i -> i + 1;

		Function<Integer, Integer> multiply2 = number -> number * 2;

		// multiply2의 실행 결과값을 plus10 함수에 전달
		Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
		multiply2AndPlus10.apply(2);

		// 2 + 10을 먼저 계산한 후 그 결과값을 multiply2 함수에 전달
		plus10.andThen(multiply2).apply(2);

		// T 타입 값을 받아서 아무것도 리턴하지 않음
		Consumer<Integer> printT = i -> System.out.println(i);
		printT.accept(10);

		// T타입의 값을 제공하는 함수
		Supplier<Integer> get10 = () -> 10;

		// T타입 값을 받아서 true or false 값을 리턴하는 함수
		Predicate<Integer> isEven = i -> i % 2 == 0;

		BinaryOperator<Integer> sum = (a, b) -> a + b;
	}
	*/

	/*
	// 변수 캡처
	public static void main(String[] args) {
		Java8to11Application app = new Java8to11Application();
		app.run();
	}

	private void run() {
		// 로컬 클래스, 익명 클래스, 람다 함수 모두에서 전역변수 참조 가능. final 예약어 생략 가능
		final int baseNumber = 10;

		// 로컬 클래스
		class LocalClass {
			void printBaseNumber() {
				int baseNumber = 11; // 변수 재정의하면 아래에 11 찍힘
				System.out.println(baseNumber);
			}
		}

		// 익명 클래스
		Consumer<Integer> integerConsumer = new Consumer<Integer>() {
			@Override
			public void accept(Integer integer) {
				int baseNumber = 12; // 변수 재정의하면 아래에 12 찍힘
				System.out.println(baseNumber);
			}

			// 아래와 같이 파라미터 이름을 baseNumber로 하면 위의 baseNumber 변수를 가리지 않음
//			@Override
//			public void accept(Integer baseNumber) {
//				System.out.println(baseNumber);
//			}
		};

		// 람다
		IntConsumer printInt = i -> {
			// 람다 함수의 scope는 baseNumber가 선언된 scope와 동일.
			// 따라서 IntConsumer printInt = baseNumber -> 와 같이 선언하면 네이밍 중복으로 컴파일 오류 발생
			System.out.println(i + baseNumber);
		};
		printInt.accept(10);
	}
	*/

	/*
	// 메소드 레퍼런스
	public static void main(String[] args) {

		// 스태틱 메소드 레퍼런스 사용
		UnaryOperator<String> hi = Greeting::hi;

		// 인스턴스 메소드 레퍼런스 사용
		Greeting greeting = new Greeting();
		UnaryOperator<String> hello = greeting::hello;
		System.out.println(hello.apply("there"));

		// 생성자 참조
		Supplier<Greeting> newGreeting = Greeting::new;

		// 아래 2 라인은 서로 다른 생성자를 참조하고 있음
		Function<String, Greeting> greeting3 = Greeting::new;
		Supplier<Greeting> greeting4 = Greeting::new; // 문자열 받지 않는 생성자 참조

		// 임의 객체 레퍼런스 참조
		String[] names = {"a", "b", "c"};

		// 모두 동일한 의미
		Arrays.sort(names, String::compareToIgnoreCase);
		Arrays.sort(names, (o1, o2) -> 0);
		Arrays.sort(names, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return 0;
			}
		});
	}
	*/

	/*
	// 인터페이스 기본 메소드
	public static void main(String[] args) {
		Foo foo = new DefaultFoo("k");
		foo.printName();
		foo.printNameUpperCase();
		Foo.printAnything();
	}
	*/

	/*
	자바 8 API의 기본 메소드와 스태틱 메소드
	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("keesun");
		names.add("whiteship");
		names.add("toby");
		names.add("foo");

		names.forEach(System.out::println);
		for (String n : names) {
			System.out.println(n);
		}

		names
			.stream()
			.map(String::toUpperCase)
			.filter(s -> s.startsWith("K"))
			.collect(Collectors.toSet());

		names.removeIf(s -> s.startsWith("K");

		Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
		names.sort(compareToIgnoreCase.reversed().thenComparing());

		Spliterator<String> spliterator = names.spliterator();
		Spliterator<String> spliterator1 = spliterator.trySplit();
		while (spliterator.tryAdvance(System.out::println));
		while (spliterator1.tryAdvance(System.out::println));
	}
	 */
}
