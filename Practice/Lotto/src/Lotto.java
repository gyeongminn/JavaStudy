abstract class Lotto {
    public final int SIZE = 6;
    public boolean isValid;
    private int[] lottoNumber;

    abstract int[] generate();

    public Lotto() {
        this.lottoNumber = generate();
        isValid = verify();
    }

    private boolean verify() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = i + 1; j < SIZE; j++) {
                if (lottoNumber[i] == lottoNumber[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void show() {
        if (!isValid) {
            System.out.println("유효하지 않은 번호입니다.");
            return;
        }

        for (int n : lottoNumber) {
            System.out.printf("%02d ", n);
        }
        System.out.println();
    }
}