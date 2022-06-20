package com.example.java8to11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.text.html.Option;
import java.sql.SQLOutput;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    /*
    // 스트림 API
    public static void main(String[] args) {
        // 스트림 자체는 데이터를 저장하는 저장소가 아님. 소스를 가지고 처리를 하는 역할만 수행
        // 처리하는 데이터 소스 자체를 바꾸지 않음
        List<String> names = new ArrayList<>();
        names.add("keesun");
        names.add("toby");
        names.add("foo");

        // 중개 오퍼레이션: 스트림 리턴
        // 종료 오퍼레이션: 스트림을 리턴하지 않음
        // 중개 오퍼레이션은 종료 오퍼레이션이 선언되어야 처리됨

        // List<String> collect = names.stream().map(s -> {
            // // 이하 코드가 실행되지 않음
            // System.out.println(s);
            // return s.toUpperCase();
        // });

        // 반면 아래와 같이 선언(종료 오퍼레이션 선언)시 처리 가능
        List<String> collect = names.stream().map(s -> {
            System.out.println(s);
            return s.toUpperCase();
        }).collect((Collectors.toList()));
        collect.forEach(System.out::println);

        names.parallelStream().map(String::toUpperCase)
                .collect(Collectors.toList());

        // 병렬 처리
        List<String> collect2 = names.parallelStream().map(s -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
    }
    */

    /*
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        // spring으로 시작하는 수업
        springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .forEach(oc -> System.out.println(oc.getId()));

        // close 되지 않은 수업
        springClasses.stream()
                // 아래 2개는 동일
                // .filter(oc -> !oc.getClosed())
                .filter(Predicate.not(OnlineClass::getClosed))
                .forEach(oc -> System.out.println(oc.getId()));

        // 수업 이름만 모아서 스트림 만들기
        springClasses.stream()
                .map(OnlineClass::getTitle)
                .forEach((System.out::println));

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> events = new ArrayList<>();
        events.add(springClasses);
        events.add(javaClasses);

        // 두 수업 목록에 있는 수업 아이디 출력
        events.stream()
                .flatMap(Collection::stream)
                .forEach(oc -> System.out.println(oc.getId()));

        // 10부터 1씩 증가하는 무제한 스트림 중 앞에서 10개 빼고 최대 10개 출력
        Stream.iterate(10, i -> i + 1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        // Test가 들어가는 수업
        Boolean test = javaClasses.stream()
                .anyMatch(oc -> oc.getTitle().contains("Test"));

        // 스프링 수업 제목에 spring이 들어간 것만
        List<String> spring = springClasses.stream()
                    .filter(oc -> oc.getTitle().contains("spring"))
                    .map(OnlineClass::getTitle)
                    .collect(Collectors.toList());
    }
    */

    /*
    // Optional
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
        // 아래 코드는 null pointer exception 발생.
        // Duration studyDuration = spring_boot.getProgress().getStudyDuration();
        // 이 오류 방지를 위해 아래와 같이 코딩. 자바 8부터 Optional로 아래 코드 대체 가능
        // Progress progress = spring_boot.getProgress();
        // if ( progress != null ) {
        //    ...
        // }
        Optional<Progress> progress = spring_boot.getProgress();

        // 원시타입은 전용 메소드 있음
        Optional.of(10);
        OptionalInt.of(10); // 권장

        // Collection, Map, Stream, Array, Optional을 Optional로 감싸지 말것

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

//        OnlineClass oc = optional.get();
//        OnlineClass oc = optional.orElse(createNewClasss());
        OnlineClass oc = optional.orElseGet(Java8to11Application::createNewClasss);
        OnlineClass oc2 = optional.orElseThrow(IllegalStateException::new);
        Optional<OnlineClass> oc3 = optional.filter(o -> !o.getClosed()); // 아래 코드와 동일
        // Optional<OnlineClass> oc3 = optional.filter(OnlineClass::getClosed);

        Optional<Integer> integer = optional.map(OnlineClass::getId);

        // map으로 꺼내는 타입 자체가 Optional일 경우
        Optional<Progress> op = optional.flatMap(OnlineClass::getProgress);
        // 아래 코드 2줄을 위 코드 한줄로 축약 가능
        // Optional<Optional<Progress>> op = optional.map(OnlineClass::getProgress);
        // Optional<Progress> progess = op.orElseThrow();

    }
    private static OnlineClass createNewClasss() {
        return new OnlineClass(10, "New class", false);
    }
    */

    /* Date
    public static void main(String[] args) throws InterruptedException {
        // 근본적으로 Timestamp와 동일. mutable하고 버그가 있어 사용에 주의 필요
        Date date = new Date();

        // 기계시간
        // 기준시 UTC, GMT
        Instant instant = Instant.now();
        ZoneId zone = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = instant.atZone(zone);

        // 인류용 일시
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime.of(1982, Month.APRIL, 3, 2, 3);
        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));

        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthday = LocalDate.of(2020, Month.JULY, 15);
        Period period = Period.between(today, thisYearBirthday);

        // 파싱 또는 포매팅
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate.parse("07/15/1982", MMddyyyy);
    }
    */

    // Concurrent
    public static void main(String[] args) {

        // ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        // executorService.scheduleAtFixedRate(getRunnable("hello"), 1, 2, TimeUnit.SECONDS);

        // Callable은 리턴값 가질 수 있음
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> hello = () -> {
            Thread.sleep(2000);
            return "Hello";
        };

        Future<String> helloFuture = executorService.submit(hello);
        System.out.println(helloFuture.isDone());
        System.out.println("Started");

        helloFuture.get(); // 블록킹
        helloFuture.cancel(true);   // 현재 진행중인 작업을 인터럽트하여 종료시킴

        System.out.println(helloFuture.isDone());
        System.out.println("End");
        executorService.shutdown();
    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }
}