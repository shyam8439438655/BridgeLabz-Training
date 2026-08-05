package com.clinic.dto;

import java.math.BigDecimal;

public class Billing {
    private int billId;
    private int appointmentId;
    private BigDecimal amount;
    private String paymentStatus;

    public Billing() {}

    public Billing(int appointmentId, BigDecimal amount, String paymentStatus) {
        this.appointmentId = appointmentId;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

    public int getBillId() { return billId; }
    public void setBillId(int billId) { this.billId = billId; }

    public int getAppointmentId() { return appointmentId; }
    public void setAppointmentId(int appointmentId) { this.appointmentId = appointmentId; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }

    @Override
    public String toString() {
        return "Billing [BillID=" + billId + ", ApptID=" + appointmentId + 
               ", Amount=" + amount + ", Status=" + paymentStatus + "]";
    }
}
