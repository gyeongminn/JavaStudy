abstract class Shape {
    public Shape next;
    public Shape() {
        next = null;
    }
    public void paint() {
        draw();
    }
    abstract public void draw();
}

class Line extends Shape {
    public void draw() {
        System.out.println("Line");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Circle");
    }
    public void f() {
        System.out.println("원이 좋아");
    }
}

class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("Rect");
    }
}

class OverEx {
    public static void print(Shape p) {
        while (p != null) {
            p.paint();
            p = p.next;
        }
    }

    public static void main(String[] args) {
        Shape start = null, last = null, obj;

        start = new Line();
        last = start;

        obj = new Circle();
        last.next = obj;
        last = obj;

        obj = new Rect();
        last.next = obj;
        last = obj;

        print(start);
    }
}