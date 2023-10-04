package com.peerlender.lendingengine.domain.service;

import com.peerlender.lendingengine.domain.exception.UserNotFoundException;
import com.peerlender.lendingengine.domain.model.Money;
import com.peerlender.lendingengine.domain.model.User;
import com.peerlender.lendingengine.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BalanceService {

    private final UserRepository userRepository;

    @Autowired
    public BalanceService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void topUpBalance(final Money money, String authToken) {
        User user = findUser(authToken);

        user.topUp(money);
    }

    private User findUser(String authToken) {
        return userRepository.findById(authToken)
                .orElseThrow(() -> new UserNotFoundException(authToken));
    }

    @Transactional
    public void withdrawFromBalance(final Money money, String authToken) {
        User user = findUser(authToken);
        user.withDraw(money);
    }
}
