package edu.wgu.d387_sample_code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import edu.wgu.d387_sample_code.rest.WelcomeController;
import edu.wgu.d387_sample_code.rest.WelcomeController.WelcomeMessagesDto;
import java.util.Locale;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;


@SpringBootApplication
public class D387SampleCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(D387SampleCodeApplication.class, args);

		// Create two instances of WelcomeController for different locales
		WelcomeController welcomeControllerUS = new WelcomeController();
		WelcomeController welcomeControllerFrench = new WelcomeController();

		// Create threads
		Thread threadUS1 = new Thread(() -> {
			// Set the locale for US English
			Locale usEnglish = new Locale("en", "US");
			// Retrieve the welcome message
			WelcomeController.WelcomeMessagesDto messages = welcomeControllerUS.getWelcomeMessage(usEnglish);
			// Print the messages
			System.out.println(messages.getMessage1());
		});

		Thread threadFrench1 = new Thread(() -> {
			// Set the locale for Canadian French
			Locale canadianFrench = new Locale("fr", "CA");
			// Retrieve the welcome message
			WelcomeController.WelcomeMessagesDto messages = welcomeControllerFrench.getWelcomeMessage(canadianFrench);
			// Print the messages
			System.out.println(messages.getMessage1());
		});

		// Start the threads
		threadUS1.start();
		threadFrench1.start();

	}
}