package com.ps;

public class SalesContract extends Contract{

    private float salesTaxAmount;
    private double recordingFee;
    private double processingFee;
    private boolean finance;
    private double monthlyPayment;

    Vehicle vehicle = new Vehicle();


    public SalesContract(
            String dateOfContract,
            String customerName,
            String customerEmail,
            String vehicleSold,
            double salesTaxAmount,
            boolean finance
    ) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.salesTaxAmount = (float) salesTaxAmount;
        this.recordingFee = 100;
        this.processingFee = (vehicle.getPrice() < 10000) ? 295 : 495;
        this.finance = finance;
        this. monthlyPayment = 0;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }


    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }

    public double getSalesTaxAmount() {
        return calculateTotalPrice() * 0.05;
    }

    private double calculateMonthlyPayment(int months, double interestRate){
        double monthlyInterestRate = interestRate / 100 / 12;
        double loanAmount = vehicle.getPrice();
        double monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -months));
        return monthlyPayment;
        }

    @Override
    public double getMonthlyPayment(){
        if (!finance){
            return 0;
        }
        if (vehicle.getPrice() >= 10000){
            monthlyPayment = calculateMonthlyPayment(48,4.25);
        } else {
            monthlyPayment = calculateMonthlyPayment(24, 5.25);
        }
        return monthlyPayment;
    }

    private double calculateTotalPrice(){
        return
                vehicle.getPrice() +
                recordingFee +
                processingFee;
    }

    @Override
    public double getTotalPrice(){
        double salesTaxAmount = getSalesTaxAmount();
        double totalPrice =
                calculateTotalPrice() +
                salesTaxAmount;
        return totalPrice;
    }

}
