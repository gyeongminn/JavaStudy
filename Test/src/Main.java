class Apple {
}

class Banana {
}

class FruitBox {
    private Object fruit;

    public FruitBox(Object fruit) {
        this.fruit = fruit;
    }

    public Object getFruit() {
        return fruit;
    }

    public static void main(String[] args) {
        FruitBox appleBox = new FruitBox(new Apple());
        FruitBox banBox = new FruitBox(new Apple());

    }
}