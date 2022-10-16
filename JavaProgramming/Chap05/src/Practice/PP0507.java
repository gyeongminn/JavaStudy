package Practice;

class Point3D extends Point {
    private int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    private void move(int x, int y, int z) {
        super.move(x, y);
        this.z = z;
    }

    private void moveUp() {
        z++;
    }

    private void moveDown() {
        z--;
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + "," + z + ")의 점";
    }

    public static void main(String[] args) {
        Point3D p = new Point3D(1, 2, 3);
        System.out.println(p.toString() + "입니다.");

        p.moveUp();
        System.out.println(p.toString() + "입니다.");

        p.moveDown();
        p.move(10, 10);
        System.out.println(p.toString() + "입니다.");

        p.move(100, 200, 300);
        System.out.println(p.toString() + "입니다.");
    }
}
