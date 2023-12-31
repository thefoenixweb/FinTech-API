package com.peerlender.lendingengine.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

@Entity
public final class Money {

    public static final Money ZERO = new Money( 0, Currency.USD);

    @Id
    @GeneratedValue
    private long id;
    private Currency currency;
    private BigDecimal amount;

    public Money() {
    }

    public Money(double amount, Currency currency) {
        this.currency = currency;
        this.amount = BigDecimal.valueOf(amount).setScale(2, RoundingMode.HALF_DOWN);
    }

    public Money times(double multiplier) {
        return new Money(amount.doubleValue() * multiplier, currency);
    }

    public Money add(final Money money) {
        if(currency != money.getCurrency()) {
            throw new IllegalArgumentException();
        }
        return new Money(amount.doubleValue() + money.getAmount(), currency);
    }

    public Money minus(final Money money) {
        if(currency != money.getCurrency() || amount.doubleValue() < money.getAmount()) {
            throw new IllegalArgumentException();
        }
        return new Money(amount.doubleValue() - money.getAmount(), currency);
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount.doubleValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return currency == money.currency && Objects.equals(amount, money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, amount);
    }

    @Override
    public String toString() {
        return "Money{" +
                "currency=" + currency +
                ", amount=" + amount +
                '}';
    }
}
