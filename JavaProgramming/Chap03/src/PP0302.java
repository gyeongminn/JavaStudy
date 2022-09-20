public class PP0302 {
    public static void main(String[] args) {
        int n[][] = {{1}, {1, 2, 3}, {1}, {1, 2, 3 ,4}, {1, 2}};
        for (int[] row : n) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
