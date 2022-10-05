import lib.Calculator;

import java.util.Calendar;
import java.util.Scanner;
import java.util.StringTokenizer;

class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Point po = (Point) obj;
        if (x == po.x && y == po.y) return true;
        else return false;
    }
}

class ObjEx {
    private static void print(Object obj) {
        System.out.println(obj.getClass().getName());
        System.out.println(obj.getClass().hashCode());
        System.out.println(obj.toString());
        System.out.println();
    }

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.YEAR));
        System.out.println(c.get(Calendar.MONTH)+1);
        System.out.println(c.get(Calendar.DATE));
        System.out.println(c.get(Calendar.HOUR));
        System.out.println(c.get(Calendar.MINUTE));
        System.out.println(c.get(Calendar.SECOND));
        System.out.println(c.get(Calendar.MILLISECOND));
    }
}
