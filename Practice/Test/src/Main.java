public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("dog", 10);
        dog.speak();

        Dog dog2 = new Dog("DOG");
        dog2.setAge(122);
        dog2.speak();



        Cat cat = new Cat("cat", 20);
        cat.speak();
    }
}
