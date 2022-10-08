public class SuperLevel extends PlayerLevel{
    @Override
    void run() {
        System.out.println("엄청 빨리 달립니다.");
    }

    @Override
    void jump() {
        System.out.println("높이 jump 합니다.");
    }

    @Override
    void turn() {
        System.out.println("turn 합니다.");
    }

    @Override
    void showLevelMessage() {
        System.out.println("----- 상급자 레벨이 되었습니다 -----");
    }
}
