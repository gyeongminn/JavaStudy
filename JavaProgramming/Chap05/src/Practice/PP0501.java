package Practice;

class TV {
    private int size;

    public TV(int size) {
        this.size = size;
    }

    protected int getSize() {
        return size;
    }
}

class ColorTV extends TV {
    private int color;

    public ColorTV(int size, int color) {
        super(size);
        this.color = color;
    }

    public void printProperty() {
        System.out.println(getSize() + "인치 " + color + "컬러");
    }
}

public class PP0501 {
    public static void main(String[] args) {
        ColorTV myTv = new ColorTV(32,1034);
        myTv.printProperty();
    }
}
