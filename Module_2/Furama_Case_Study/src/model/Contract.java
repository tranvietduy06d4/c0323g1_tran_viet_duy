package model;

public class Contract {
    private String contractCode;
    private String bookingCode;
    private int depositMoney;
    private int totalMoney;

    public Contract() {
    }

    public Contract(String contractCode, String bookingCode, int depositMoney, int totalMoney) {
        this.contractCode = contractCode;
        this.bookingCode = bookingCode;
        this.depositMoney = depositMoney;
        this.totalMoney = totalMoney;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public int getDepositMoney() {
        return depositMoney;
    }

    public void setDepositMoney(int depositMoney) {
        this.depositMoney = depositMoney;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractCode='" + contractCode + '\'' +
                ", bookingCode='" + bookingCode + '\'' +
                ", depositMoney=" + depositMoney +
                ", totalMoney=" + totalMoney +
                '}';
    }
}
