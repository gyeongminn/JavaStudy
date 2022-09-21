public class PP0311 {
    public static void main(String[] args) {
        int sum = 0;
        for (String a : args) {
            sum += Integer.parseInt(a);
        }
        System.out.println(sum / args.length);
    }
}
