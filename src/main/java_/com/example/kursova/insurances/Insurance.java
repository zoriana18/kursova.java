package com.example.kursova.insurances;
public interface Insurance {
    double getRiskLevel();
    int getContribution();
    int getNumber();
    int getTermOfContract();
    int getPayment();
    void calculateRiskLevel();
    void calculateContribution();
    void calculatePayment();
}
