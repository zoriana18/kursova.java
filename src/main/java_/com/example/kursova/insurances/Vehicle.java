package com.example.kursova.insurances;

public class Vehicle implements Insurance{
    final String insuranceType = "Vehicle";
    int number,contribution, payment;
    int termOfContract,motorVolume, vehiclePrice;
    double riskLevel;

    String type;

    public Vehicle(){}

    public Vehicle(int number,String type, int motorVolume, int vehiclePrice,int termOfContract){
       this.number=number;
        this.type = type;
        this.motorVolume = motorVolume;
        this.vehiclePrice = vehiclePrice;
        this.termOfContract=termOfContract;
        calculateRiskLevel();
        calculateContribution();
        calculatePayment();
    }

    public String getInsuranceType(){
        return  insuranceType;
    }


    public void setType(String type) {
        this.type = type;
    }

    public void setMotorVolume(int motorVolume) {
        this.motorVolume = motorVolume;
    }

    public void setVehiclePrice(int vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }
    public void setTermOfContract(int year){this.termOfContract=termOfContract;}
    @Override
    public int getNumber() {
        return number;
    }
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

    public int getMotorVolume() {
        return motorVolume;
    }
    @Override
    public int getTermOfContract(){return termOfContract;};

    @Override
    public void calculateRiskLevel() {
        if(type.equals("motorcycle"))
            riskLevel = 0.5;
        else if(type.equals("truck "))
            riskLevel = 0.3;
        else if(type.equals("bus"))
            riskLevel = 0.15;
        else
            riskLevel = 0.1;
    }
    @Override
    public void calculateContribution() {
        contribution = (int)(motorVolume*riskLevel*100);
    }

    @Override
    public void calculatePayment() {
        payment = (int)((1-riskLevel)*contribution*termOfContract);
    }

    @Override
    public String toString() {
        return "CarInsurance{" +
                "risk=" + riskLevel +
                ", price=" + contribution +
                ", payment=" + payment +
                ", type='" + type + '\'' +
                ", motor volume=" + motorVolume +
                ", vehicle price=" + vehiclePrice +
                ", termOfContract=" + termOfContract +
                '}';
    }
}
