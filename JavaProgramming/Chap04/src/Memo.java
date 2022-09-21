/**
 * 객체지향언어2 8반
 * 과제2. 4장 클래스 만들기 - 1번
 * 2171333 이경민
 */
public class Memo {
    private String name, time, content;

    /**
     * Memo Class 생성자
     * @param name
     * @param time
     * @param content
     */
    public Memo(String name, String time, String content) {
        this.name = name;
        this.time = time;
        this.content = content;
    }

    /**
     * 메모 출력 함수
     * <p>이름, 시간, 메모 출력
     */
    private void show() {
        System.out.println(name + " " + time + " " + content);
    }

    /**
     * 같은 이름인지 판단
     * @param otherMemo
     * @return 같으면 true, 다르면 false
     */
    private boolean isSameName(Memo otherMemo) {
        if (this.name.equals(otherMemo.name)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 텍스트 길이 반환
     * @return 현재 memo의 텍스트 길이
     */
    private int length() {
        return this.content.length();
    }

    public static void main(String[] args) {
        Memo a = new Memo("장수희", "10:10", "자바 과제 있음");
        Memo b = new Memo("강민서", "10:15", "저녁 알바 취소됨");
        Memo c = new Memo("최강", "11:30", "사랑하는 사람이 생겼어요");
        a.show();
        if (a.isSameName(b)) System.out.println("동일한 사람입니다.");
        else System.out.println("다른 사람입니다.");
        System.out.println("a의 메모 텍스트의 길이는 " + a.length());
    }
}