package Practice;

class IPTV extends ColorTV {
    private String ip;

    public IPTV(String ip, int size, int color) {
        super(size, color);
        this.ip = ip;
    }

    @Override
    public void printProperty() {
        System.out.print("나의 IPTV는 " + ip + " 주소의 ");
        super.printProperty();
    }
}

public class PP0502 {
    public static void main(String[] args) {
        IPTV iptv = new IPTV("192.1.1.2", 32, 2048);

        iptv.printProperty();
    }
}
