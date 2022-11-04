import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TenLabelClick extends JFrame {
    private JLabel[] labels; // 라벨 배열
    private int labelIndex; // 현재 클릭해야 하는 라벨의 인덱스

    private final int LABEL_WIDTH = 20; // 라벨 폭
    private final int LABEL_HEIGHT = 10; // 라벨 높이

    public TenLabelClick() {
        initLabel(); // 라벨 배열 초기화
        initGame(); // 게임 초기화
        showFrame(); // 화면 설정
    }

    private void showFrame() {
        Container container =  getContentPane();
        setTitle("Ten 레이블 누르기");
        container.setLayout(null);
        container.addMouseListener(new MouseAction());
        container.setSize(300, 300); // 창 크기 300 x 300
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }

    // 라벨 초기화 메서드
    private void initLabel() {
        labels = new JLabel[10];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel(Integer.toString(i + 1));
            labels[i].setSize(LABEL_WIDTH, LABEL_HEIGHT);
        }
    }

    // 게임 초기화 메서드
    private void initGame() {
        labelIndex = 9;
        for (JLabel label : labels) {
            int x = (int) (Math.random() * 280); // 랜덤 값 0~280
            int y = (int) (Math.random() * 260); // 랜덤 값 0~260
            label.setLocation(x, y);
            getContentPane().add(label);
        }
    }

    // 마우스 액션 내부 클래스
    class MouseAction extends MouseAdapter {

        // 거리 계산 메서드
        private int getDistance(int a, int b) {
            return Math.abs(a - b); // 두 정수의 차 리턴
        }

        @Override
        public void mousePressed(MouseEvent e) { // 마우스 클릭 시
            JLabel label = labels[labelIndex]; // 현재 클릭해야 하는 라벨

            // 클릭된 좌표와 라벨의 좌표의 거리 비교 (라벨 중앙 좌표 기준)
            if (getDistance(label.getX() + LABEL_WIDTH / 2, e.getX()) < 15) {
                if (getDistance(label.getY() + 30 + LABEL_HEIGHT / 2, e.getY()) < 10) {
                    Container c = label.getParent(); // 컨테이너 불러오기
                    c.remove(label); // 라벨 삭제
                    c.repaint(); // 다시 그리기
                    labelIndex--;
                }
            }

            if (labelIndex < 0) { // 라벨을 모두 누른 경우
                initGame(); // 게임 초기화
            }
        }
    }

    public static void main(String[] args) {
        new TenLabelClick(); // 실행
    }
}