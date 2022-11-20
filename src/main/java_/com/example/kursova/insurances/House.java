package com.example.kursova.insurances;

public class House implements Insurance{

    final String insuranceType = "House";
    double riskLevel;
    int number;
    int contribution, payment,area, housePrice,termOfContract;


    public House(int number,int area, int housePrice,int termOfContract){
        this.number = number;
        this.area = area;
        this.housePrice = housePrice;
        this.termOfContract=termOfContract;
        calculateRiskLevel();
        calculateContribution();
        calculatePayment();
    }

    public String getInsuranceType(){
        return  insuranceType;
    }
    @Override
    public int getTermOfContract(){return termOfContract;}
    @Override
    public int getNumber(){return number;}

    @Override
    public int getContribution(){
        return contribution;
    }

    @Override
    public int getPayment() {
        return payment;
    }

    @Override
    public double getRiskLevel() {
        return riskLevel;
    }

    public int getArea() {
        return area;
    }

    public int getHousePrice(){
        return housePrice;
    }
    @Override
    public void calculateRiskLevel() {
        riskLevel = (double)(int)(((double) area*100/housePrice)*10000)/10000;
    }
    @Override
    public void calculateContribution() {
        contribution = (int)(double)housePrice/100*area;
    }

    @Override
    public void calculatePayment() {
        payment = (int)(contribution*termOfContract*(1-riskLevel));
    }

    @Override
    public String toString() {
        return "HouseInsurance{" +
                "risk=" + riskLevel +
                ", price=" + contribution +
                ", payment=" + payment +
                ", area=" + area +
                ", house price=" + housePrice +
                ", term of contact=" + termOfContract +
                '}';
    }
}
