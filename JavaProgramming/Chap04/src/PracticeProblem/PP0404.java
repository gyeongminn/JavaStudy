package PracticeProblem;

class Rectangle {
    private int x, y, width, height;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private int square() {
        return width * height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private void show() {
        System.out.println("(" + x + "," + y + ")에서 크기가 " + width+"x"+height+"인 사각형");
    }

    private boolean contains(Rectangle r) {
        if (x < r.getX() && r.getX() + r.getWidth() < x + width) {
            if (y < r.getY() && r.getY() + r.getHeight() < y + height) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle(2, 2, 8, 7);
        Rectangle s = new Rectangle(5, 5, 6 ,6);
        Rectangle t = new Rectangle(1, 1, 10, 10);

        r.show();
        System.out.println("s의 면적은 " + s.square());
        if (t.contains(r)) System.out.println("t는 r을 포함합니다.");
        if (t.contains(s)) System.out.println("t는 s를 포함합니다.");
    }
}