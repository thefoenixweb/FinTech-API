package com.peerlender.lendingengine.domain.exception;

public class LoanApplicationNotfoundException extends RuntimeException {

    public LoanApplicationNotfoundException(long loanApplicationId) {
        super("Loan application with id :" + loanApplicationId + "was not found");
    }
}
