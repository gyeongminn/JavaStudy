import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

enum LottoType {
    AUTO, SELF
}

public class LottoSim {
    LottoCard[] lottoCards;

    private void run() {
        System.out.println("--------<< 로또 판매점 >>--------");

        Scanner scanner = new Scanner(System.in);
        System.out.print("자동 로또 몇 개를 구매하시겠습니까? >> ");
        int autoNum = scanner.nextInt();

        System.out.print("수동 로또 몇 개를 구매하시겠습니까? >> ");
        int selfNum = scanner.nextInt();
        System.out.println();

        Queue<LottoType> queue = new LinkedList<>();

        for (int i = 0; i < autoNum; i++) {
            queue.offer(LottoType.AUTO);
        }
        for (int i = 0; i < selfNum; i++) {
            queue.offer(LottoType.SELF);
        }

        lottoCards = new LottoCard[autoNum + selfNum];
        int idx = 0;
        while (true) {
            autoNum = 0;
            selfNum = 0;
            for (int i = 0; i < 5; i++) {
                LottoType lottoType = queue.poll();
                if (lottoType == LottoType.AUTO) autoNum++;
                else if (lottoType == LottoType.SELF) selfNum++;
                else break;
            }
            if (autoNum == 0 && selfNum == 0) break;
            lottoCards[idx] = new LottoCard(autoNum, selfNum);
            lottoCards[idx].show(idx);
            idx++;
        }
    }

    public static void main(String[] args) {
        LottoSim lottoSim = new LottoSim();
        lottoSim.run();
    }
}
