package PracticeProblem;

class TV {
    private String company;
    private int productionYear;
    private int size;

    public TV(String company, int productionYear, int size) {
        this.company = company;
        this.productionYear = productionYear;
        this.size = size;
    }

    private void show() {
        System.out.println(company + "에서 만든 " + productionYear + "년형 " + size + "인치 TV");
    }

    public static void main(String[] args) {
        TV myTV = new TV("LG", 2017, 32);
        myTV.show();
    }
}