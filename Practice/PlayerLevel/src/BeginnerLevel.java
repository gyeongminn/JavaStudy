public class BeginnerLevel extends PlayerLevel{
    @Override
    void run() {
        System.out.println("천천히 달립니다.");
    }

    @Override
    void jump() {
        System.out.println("jump 할 수 없습니다.");
    }

    @Override
    void turn() {
        System.out.println("turn 할 수 없습니다.");
    }

    @Override
    void showLevelMessage() {
        System.out.println("----- 초급자 레벨이 되었습니다 -----");
    }
}
