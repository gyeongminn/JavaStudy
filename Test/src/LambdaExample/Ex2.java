package LambdaExample;

import java.util.function.Function;

@FunctionalInterface
interface Calculate {
    int add(int a, int b);
}

public class Ex2 {

    public static void main(String[] args) {
        //Calculate calculate = (int a, int b) -> a + b;
        Calculate calculate = Integer::sum;
        System.out.println(calculate.add(1, 2));

        // Function 은 객체 T를 매개변수로 받아서 처리한 후 R로 반환하는 함수형 인터페이스다.
        Function<Integer, Integer> mul = a -> a * 10;
        System.out.println(mul.apply(10));
    }
}

// 람다 식 문법
// (매개변수 목록) -> {
//     실행문
// }

// 람다란? https://mangkyu.tistory.com/113
// 메서드 참조 http://www.tcpschool.com/java/java_lambda_reference