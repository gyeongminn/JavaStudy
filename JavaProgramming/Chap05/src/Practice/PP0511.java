package Practice;

import java.util.Scanner;

abstract class Calc {
    protected int a, b;

    public void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }

    abstract int calculate();
}

class Add extends Calc {
    @Override
    int calculate() {
        return a + b;
    }
}

class Sub extends Calc {
    @Override
    int calculate() {
        return a - b;
    }
}

class Mul extends Calc {
    @Override
    int calculate() {
        return a * b;
    }
}

class Div extends Calc {
    @Override
    int calculate() {
        if (b == 0) return 0;
        return a / b;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("두 정수와 연산자를 입력하시오 >> ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        Calc calculator = null;
        switch (scanner.nextLine().trim()) {
            case "+" -> calculator = new Add();
            case "-" -> calculator = new Sub();
            case "*" -> calculator = new Mul();
            case "/" -> calculator = new Div();
            default -> {
                System.out.println(1);
                return;
            }
        }

        calculator.setValue(a, b);
        System.out.println(calculator.calculate());
    }
}