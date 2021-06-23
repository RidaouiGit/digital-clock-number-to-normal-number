package demo.entity;

public class Digit {

    String row1;
    String row2;
    String row3;

    public String getRow1() {
        return row1;
    }

    public String getRow2() {
        return row2;
    }

    public String getRow3() {
        return row3;
    }

    public Digit(String row1, String row2, String row3) {
        this.row1 = row1;
        this.row2 = row2;
        this.row3 = row3;
    }

    public Boolean eq(Digit clockNumber) {
        return this.getRow1()
                .equals(clockNumber.row1) &&
                this.getRow2().equals(clockNumber.row2) &&
                this.getRow3().equals(clockNumber.row3);
    }
}

