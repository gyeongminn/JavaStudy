package PracticeProblem;

import java.util.Scanner;

abstract class Calculate {
    int a, b;
    void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }
    abstract int calculate();
}

class Add extends Calculate {
    @Override
    int calculate() {
        return a + b;
    }
}

class Sub extends Calculate {
    @Override
    int calculate() {
        return a - b;
    }
}

class Mul extends Calculate {
    @Override
    int calculate() {
        return a * b;
    }
}

class Div extends Calculate {
    @Override
    int calculate() {
        if (b == 0) return 0;
        else return a / b;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("두 정수와 연산자를 입력하시오 >> ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        switch (scanner.next()) {
            case "+" -> {
                Add add = new Add();
                add.setValue(n , m);
                System.out.println(add.calculate());
            }
            case "-" -> {
                Sub sub = new Sub();
                sub.setValue(n , m);
                System.out.println(sub.calculate());
            }
            case "*" -> {
                Mul mul = new Mul();
                mul.setValue(n , m);
                System.out.println(mul.calculate());
            }
            case "/" -> {
                Div div = new Div();
                div.setValue(n , m);
                System.out.println(div.calculate());
            }
        }
    }
}