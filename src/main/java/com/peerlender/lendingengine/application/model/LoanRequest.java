package com.peerlender.lendingengine.application.model;

import com.peerlender.lendingengine.domain.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.Duration;
import java.util.Objects;

@Entity
public class LoanRequest {

    @Id
    private int id;
    private  int amount;

    private  int daysToRepay;
    private  double interestRate;

    public LoanRequest(){}
    public LoanRequest(int amount,  int daysToRepay, double interestRate) {
        this.amount = amount;

        this.daysToRepay = daysToRepay;
        this.interestRate = interestRate;
    }

    public int getAmount() {
        return amount;
    }



    public int getDaysToRepay() {
        return daysToRepay;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanRequest that = (LoanRequest) o;
        return amount == that.amount  && daysToRepay == that.daysToRepay && Double.compare(interestRate, that.interestRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount,  daysToRepay, interestRate);
    }

    @Override
    public String toString() {
        return "LoanRequest{" +
                "amount=" + amount +
                ", daysToRepay=" + daysToRepay +
                ", interestRate=" + interestRate +
                '}';
    }
}
