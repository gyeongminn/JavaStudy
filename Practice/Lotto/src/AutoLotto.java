public class AutoLotto extends Lotto{
    @Override
    public int[] generate() {
        int[] lotto = new int[46];
        for (int i = 0; i < SIZE; i++) {
            int random =(int)(Math.random() * 45 + 1);
            if (lotto[random] != 1) {
                lotto[random] = 1;
            } else {
                i--;
            }
        }

        int[] lottoNumber = new int[SIZE];
        int idx = 0;
        for (int i = 1; i < 46; i++) {
            if (lotto[i] == 1) {
                lottoNumber[idx++] = i;
            }
        }
        return lottoNumber;
    }
}
