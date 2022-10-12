import java.util.Iterator;
import java.util.Vector;

public class MyVector {
    public static void printAll(Vector<Integer> v) {
        System.out.println("용량은 " + v.capacity());
        for (Integer k : v) {
            System.out.print(k + " ");
        }
        System.out.println();
    }

    private static void printAllIterator(Vector<Integer> v) {
        Iterator<Integer> it = v.iterator();
        while (it.hasNext()) {
            int n = it.next();
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        Vector<Integer> v = new Vector<Integer>(100);
        printAll(v);

        for (int i = 0; i < 11; i++) {
            v.add(i + 1);
        }

        Integer ref = v.remove(3);
        v.add(ref);
        printAll(v);
        printAllIterator(v);
    }
}