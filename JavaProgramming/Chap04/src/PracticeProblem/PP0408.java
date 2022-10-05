package PracticeProblem;

import java.util.Scanner;

class Phone {
    private String name;
    private String tel;

    public Phone(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }
}

class PhoneBook {
    Phone[] phones;

    private void write() {
        System.out.print("인원 수 >> ");

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < scanner.nextInt(); i++) {
            System.out.print("이름과 전화번호(이름과 전화번호는 빈칸 없이 입력) >> ");
            phones[i] = new Phone(scanner.next(), scanner.next());
        }
        System.out.println("저장되었습니다.");
    }

    private boolean search() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("검색할 이름 >> ");
        String name = scanner.next();
        for (Phone phone : phones) {
            if (name.equals(phone.getName())) {
                System.out.println(name + "의 번호는 " + phone.getTel() + "입니다.");
                return true;
            }
        }
        return false;
    }

    private void run() {
        write();
        while (true) {
            if (!search()) return;
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.run();
    }
}
