package Practice;

import java.util.Scanner;

interface Stack {
    int length();

    int capacity();

    String pop();

    boolean push(String val);
}

class StringStack implements Stack {
    private int length;
    private int capacity;

    String[] stack;

    public StringStack(int capacity) {
        this.capacity = capacity;
        stack = new String[capacity];
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public String pop() {
        if (length < 0) return null;
        return stack[--length];
    }

    @Override
    public boolean push(String val) {
        if (length >= capacity) return false;

        stack[length++] = val;
        return true;
    }
}

class StackApp {
    private void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("총 스택 저장 공간의 크기 입력 : ");
        StringStack stringStack = new StringStack(scanner.nextInt());
        scanner.nextLine();

        while (true) {
            System.out.print("문자열 입력 >> ");
            String s = scanner.next();

            if (s.equals("그만")) break;

            if (!stringStack.push(s)) {
                System.out.println("스택이 꽉 차서 푸시 불가!");
            }
        }

        System.out.print("스택에 저장된 모든 문자열 팝 : ");
        while (stringStack.length() > 0) {
            System.out.print(stringStack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        StackApp stackApp = new StackApp();
        stackApp.run();
    }
}
