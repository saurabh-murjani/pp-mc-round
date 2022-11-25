package src;

import java.io.*;

public class Bank {
    private int bankId;
    private String bankName;
    private double paymentSuccessRate;

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public double getPaymentSuccessRate() {
        return paymentSuccessRate;
    }

    public void setPaymentSuccessRate(double paymentSuccessRate) {
        this.paymentSuccessRate = paymentSuccessRate;
    }
}
