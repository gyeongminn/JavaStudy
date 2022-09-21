public class PP0307 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }

        System.out.print("랜덤한 정수들 : ");
        for (int n : arr) {
            System.out.print(n + " ");
        }

        int sum = 0;
        for (int n : arr) {
            sum += n;
        }
        System.out.println("\n평균은 " + (double) sum / arr.length);
    }
}
