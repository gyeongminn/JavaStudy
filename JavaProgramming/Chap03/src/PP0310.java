public class PP0310 {
    public static void main(String[] args) {
        final int SIZE = 4;
        int[][] arr = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                arr[i][j] = (int) (Math.random() * 10 % 9) + 1;
            }
        }

        for (int i = 0; i < SIZE * SIZE - 10; i++) {
            int row = (int)(Math.random() * 10 % SIZE);
            int col = (int)(Math.random() * 10 % SIZE);
            if (arr[row][col] == 0) {
                i--;
            } else {
                arr[row][col] = 0;
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
