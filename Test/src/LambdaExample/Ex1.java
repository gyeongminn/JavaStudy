package LambdaExample;

public class Ex1 {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println("Hello!");
                }
            }
        }).start();
    }
}

// 람다 식 (익명 메소드)
// JVM 은 Thread 생성자를 보고 ()->{} 이 무엇인지 대상을 추론한다.