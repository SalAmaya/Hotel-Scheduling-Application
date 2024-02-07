package edu.wgu.d387_sample_code.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

@RestController
public class WelcomeController {
    private static final String BASE_NAME = "WelcomeMessages"; // Name of the resource bundle file
    private static final Locale[] SUPPORTED_LOCALES = {Locale.US, Locale.CANADA_FRENCH};

    @GetMapping("/WelcomeMessage")
    public WelcomeMessagesDto getWelcomeMessage(Locale locale) {
        return new WelcomeMessagesDto(
                getRandomWelcomeMessage(locale),
                getRandomWelcomeMessage(locale)
        );
    }

    private String getRandomWelcomeMessage(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle(BASE_NAME, locale);
        return bundle.getString("WelcomeMessage");
    }

    private Locale getRandomLocale() {
        Random random = new Random();
        int index = random.nextInt(SUPPORTED_LOCALES.length);
        return SUPPORTED_LOCALES[index];
    }

    public static class WelcomeMessagesDto {
        private String message1;
        private String message2;

        public WelcomeMessagesDto(String message1, String message2) {
            this.message1 = message1;
            this.message2 = message2;
        }

        public String getMessage1() {
            return message1;
        }

        public void setMessage1(String message1) {
            this.message1 = message1;
        }

        public String getMessage2() {
            return message2;
        }

        public void setMessage2(String message2) {
            this.message2 = message2;
        }
    }
}