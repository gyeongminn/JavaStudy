class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void showPoint() {
        System.out.println("(" + x + ", " + y + ")");
    }
}

class ColorPoint extends Point {
    private String color;

    public ColorPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }
    public void showPoint() {
        super.showPoint();
        System.out.println(color);
    }
}

public class ColorPointEx {
    public static void main(String[] args) {
        Point p = new Point(2, 3);
        p.showPoint();

        ColorPoint cp = new ColorPoint(5, 6, "Red");
        cp.showPoint();
    }
}