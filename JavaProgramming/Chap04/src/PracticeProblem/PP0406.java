package PracticeProblem;

import java.util.Scanner;

class CirclePlus {
    private double x, y;
    private int radius;

    public CirclePlus(double x, double y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void show() {
        System.out.println("(" + x + "," + y + ")" + radius);
    }
}

class CircleManagerPlus {
    private static CirclePlus[] c;

    private static CirclePlus findMaxCircle() {
        CirclePlus max = c[0];
        for (CirclePlus circle : c) {
            if (circle.getRadius() > max.getRadius()) {
                max = circle;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        c = new CirclePlus[3];
        for (int i = 0; i < c.length; i++) {
            System.out.print("x, y, radius >> ");
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            int radius = scanner.nextInt();
            c[i] = new CirclePlus(x, y, radius);
        }
        scanner.close();

        for (int i = 0; i < c.length; i++) c[i].show();

        System.out.println("가장 면적이 큰 원은 "); findMaxCircle().show();
    }
}