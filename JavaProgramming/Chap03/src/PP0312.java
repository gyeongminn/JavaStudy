public class PP0312 {
    public static void main(String[] args) {
        int sum = 0;
        for (String a : args) {
            try {
                sum += Integer.parseInt(a);
            } catch (NumberFormatException e) {
                continue;
            }
        }
        System.out.println(sum);
    }
}