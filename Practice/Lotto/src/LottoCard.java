import java.util.Scanner;

public class LottoCard {
    private final int MAX_CARD_SIZE = 5;
    private final int LOTTO_SIZE = 6;
    private int autoNum;
    private int selfNum;
    private Lotto[] mLotto;

    public void show(int n) {
        System.out.println("\n------ " + (n + 1) + "번째 로또카드 ------");
        for (int i = 0; i < autoNum + selfNum; i++) {
            System.out.printf("[%02d] ", (i + 1));
            mLotto[i].show();
        }
        System.out.println("------------------------\n");
    }

    private void init() {
        mLotto = new Lotto[selfNum + autoNum];
    }

    private void run() {
        for (int i = 0; i < autoNum; i++) {
            mLotto[i] = new AutoLotto();
        }
        for (int i = 0; i < selfNum; i++) {
            mLotto[i + autoNum] = new SelfLotto();
        }
    }

    public LottoCard(int autoNum, int selfNum) {
        this.autoNum = autoNum;
        this.selfNum = selfNum;
        init();
        run();
    }
}
