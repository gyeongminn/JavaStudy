package Practice;

class Oval implements Shape2 {
    private int a, b;

    public Oval(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void draw() {
        System.out.println(a + "x" + b + "에 내접하는 타원입니다.");
    }

    @Override
    public double getArea() {
        return PI * a * b;
    }
}

class Rect2 implements Shape2 {
    private int a, b;

    public Rect2(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void draw() {
        System.out.println(a + "x" + b + "크기의 사각형입니다.");
    }

    @Override
    public double getArea() {
        return a * b;
    }
}

class Manager {
    public static void main(String[] args) {
        Shape2[] list = new Shape2[3];
        list[0] = new Circle2(10);
        list[1] = new Oval(20, 30);
        list[2] = new Rect2(10, 40);

        for (int i = 0; i < list.length; i++)
            list[i].redraw();

        for (int i = 0; i < list.length; i++)
            System.out.println("면적은 " + list[i].getArea());
    }
}