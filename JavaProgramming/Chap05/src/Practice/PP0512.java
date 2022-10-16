package Practice;

import java.util.Scanner;

abstract class Shape {
    private Shape next;

    public Shape() {
        next = null;
    }

    public void setNext(Shape obj) {
        next = obj;
    }

    public Shape getNext() {
        return next;
    }

    public abstract void draw();
}

class Line extends Shape {
    @Override
    public void draw() {
        System.out.println("Line");
    }
}

class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("Rect");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Circle");
    }
}


class GraphicEditor {
    private final String name;

    private final Scanner scanner;

    private Shape headShape;

    public GraphicEditor(String name) {
        this.name = name;
        headShape = null;
        scanner = new Scanner(System.in);
    }

    public String getName() {
        return name;
    }

    private void insert() {
        System.out.print("Line(1), Rect(2), Circle(3) >> ");

        Shape shape = null;
        switch (scanner.nextInt()) {
            case 1 -> shape = new Line();
            case 2 -> shape = new Rect();
            case 3 -> shape = new Circle();
        }

        if (headShape == null) {
            headShape = shape;
        } else {
            Shape ref = headShape;
            while (ref.getNext() != null) {
                ref = ref.getNext();
            }
            ref.setNext(shape);
        }
    }

    private void delete() {
        System.out.print("삭제할 도형의 위치 >> ");
        int idx = scanner.nextInt();

        if (idx == 0) {
            headShape = headShape.getNext();
        } else {
            Shape ref = headShape;
            for (int i = 0; i < idx - 1; i++) {
                ref = ref.getNext();
            }
            ref.setNext(ref.getNext().getNext());
        }
    }

    private void viewAll() {
        Shape ref = headShape;
        do {
            ref.draw();
            ref = ref.getNext();
        } while (ref != null);
    }

    private void start() {
        while (true) {
            System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4) >> ");

            switch (scanner.nextInt()) {
                case 1 -> insert();
                case 2 -> delete();
                case 3 -> viewAll();
                default -> {
                    return;
                }
            }
        }
    }

    private void run() {
        System.out.println("그래픽 에디터 " + getName() + "을 실행합니다.");
        start();
        scanner.close();
        System.out.println("beauty " + getName() + "을 종료합니다.");
    }

    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor("beauty");
        graphicEditor.run();
    }
}
