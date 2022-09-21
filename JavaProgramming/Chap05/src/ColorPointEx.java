class Point {
    private int x, y;

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void showPoint() {
        System.out.println("(" + x + ", " + y + ")");
    }
}

class ColorPoint extends Point {
    private String color;

    public void setColor(String color) {
        this.color = color;
    }

    public void showPoint() {
        super.showPoint();
        System.out.println(color);
    }
}

public class ColorPointEx {
    public static void main(String[] args) {
        Point p = new Point();
        p.set(2, 3);
        p.showPoint();

        ColorPoint cp = new ColorPoint();
        cp.set(5, 6);
        cp.setColor("red");
        cp.showPoint();
    }
}