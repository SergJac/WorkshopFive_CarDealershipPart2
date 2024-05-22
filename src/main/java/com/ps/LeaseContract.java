package com.ps;

public class LeaseContract extends Contract{

    private double expectedEndingValue;
    private double leaseFee;
    private double monthlyPayment;

    Vehicle vehicle = new Vehicle();

    public LeaseContract(
            String dateOfContract,
            String customerName,
            String customerEmail,
            String vehicleSold
    ) {
        super(
                dateOfContract,
                customerName,
                customerEmail,
                vehicleSold
        );
        double originalPrice = vehicle.getPrice();
        this.expectedEndingValue = originalPrice * 0.50;
        this.leaseFee = originalPrice * .07;
        this.monthlyPayment = calculateMonthlyPayment(36, 4.0);
    }

    private double calculateMonthlyPayment(int months, double interestRate){
        double monthlyInterestRate= interestRate / 100 / 12;
        double originalPrice = vehicle.getPrice();
        double loanAmount = originalPrice - expectedEndingValue;
        double monthlyPayment = (loanAmount - monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -months));
        return monthlyPayment;
    }

    @Override
    public double getMonthlyPayment(){
        return monthlyPayment;
    }

    @Override
    public double getTotalPrice(){
        double totalPrice = vehicle.getPrice() + leaseFee;
        return totalPrice;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }
}
