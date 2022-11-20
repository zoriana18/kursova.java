package com.example.kursova.insurances;

public class Life implements Insurance{

    final String insuranceType = "Life";
    int number,contribution, payment;
    double riskLevel,healthLevel;
    private int age,termOfContract;

    public Life(int number,int age, int health,int termOfContract){
this.number=number;
        this.age = age;
        healthLevel = calculateHealthLevel(health);
        this.termOfContract=termOfContract;
        calculateRiskLevel();
        calculateContribution();
        calculatePayment();
    }

    public String getInsuranceType(){
        return  insuranceType;
    }
    public void setHealth_level(double health_level) {
        this.healthLevel = health_level;
    }
    public int getAge(){
        return age;
    }
    @Override
    public int getTermOfContract(){
        return termOfContract;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public int getNumber(){return number;}
    @Override
    public double getRiskLevel() {
        return riskLevel;
    }
    @Override
    public int getContribution(){
        return contribution;
    }

    @Override
    public int getPayment() {
        return payment;
    }

    double calculateHealthLevel(int health){
        switch (health){
            case 1:
                return 1.7;
            case 2:
                return 1.5;
            default:
                return  1.3;
        }
    }
    @Override
    public void calculateRiskLevel() {
        riskLevel = age*healthLevel/300;
    }

    @Override
    public void calculateContribution() {
        contribution = (int)(riskLevel*10000);
    }

    @Override
    public void calculatePayment() {
       payment = (int)((1-riskLevel)*contribution*termOfContract);
    }


    @Override
    public String toString() {
        return "LifeInsurance{" +
                "risk level=" + riskLevel +
                ", contribution=" + contribution +
                ", payment=" + payment +
                ", term of contract=" + termOfContract +
                '}';
    }
}
