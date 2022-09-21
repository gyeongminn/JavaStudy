public class PP0309 {
    public static void main(String[] args) {
        final int SIZE = 4;
        int[][] arr = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                arr[i][j] = (int) (Math.random() * 9) + 1;
            }
        }

        for (int[] row : arr) {
            for (int num : row) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }
}
