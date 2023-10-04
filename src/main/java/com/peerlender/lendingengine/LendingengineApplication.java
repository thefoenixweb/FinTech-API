package com.peerlender.lendingengine;

import com.peerlender.lendingengine.domain.model.Balance;
import com.peerlender.lendingengine.domain.model.Currency;
import com.peerlender.lendingengine.domain.model.Money;
import com.peerlender.lendingengine.domain.model.User;
import com.peerlender.lendingengine.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LendingengineApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(LendingengineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User Jason = new User("Jason","Jason", "Bird", 25, "Pastor",new Balance());
		User Michael = new User("Michael","Michael", "Yard", 26, "Deacon",new Balance());
		Jason.topUp(new Money(100, Currency.USD));
		Michael.topUp(new Money(100, Currency.USD));
		userRepository.save(Jason);
		userRepository.save(Michael);
		userRepository.save(new User("Jonathan","Jonathan", "Cedric", 27, "Theologian",new Balance()));

	}
}
