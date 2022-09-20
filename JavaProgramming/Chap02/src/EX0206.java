public class EX0206 {
    public static void main(String[] args) {
        int a = 3, b = 3, c = 3;

        a += 3; // 6
        b *= 3; // 9
        c %= 2; // 1
        System.out.println("a=" + a + " b=" + b + " c=" + c);

        int d = 3;

        a = d++; // 3 -> 4
        System.out.println("a=" + a + " d=" + d);
        a = ++d; // 4 -> 5
        System.out.println("a=" + a + " d=" + d);
        a = d--; // 5 -> 4
        System.out.println("a=" + a + " d=" + d);
        a = --d; // 4 -> 3
        System.out.println("a=" + a + " d=" + d);
    }
}
