//package edu.wgu.d387_sample_code.rest;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import java.util.Locale;
//import java.util.Random;
//import java.util.ResourceBundle;
//
//@RestController
//public class WelcomeController {
//    private static final String BASE_NAME = "WelcomeMessages"; // Name of the resource bundle file
//    private static final Locale[] SUPPORTED_LOCALES = {Locale.US, Locale.CANADA_FRENCH};
//
//    @GetMapping("/WelcomeMessages")
//    public WelcomeMessagesDto getRandomWelcomeMessages() {
//        Locale randomLocale = getRandomLocale();
//        return new WelcomeMessagesDto(
//                getRandomWelcomeMessage(randomLocale),
//                randomLocale.toString()
//        );
//    }
//
//    private String getRandomWelcomeMessage(Locale locale) {
//        ResourceBundle bundle = ResourceBundle.getBundle(BASE_NAME, locale);
//        return bundle.getString("WelcomeMessages");
//    }
//
//    private Locale getRandomLocale() {
//        Random random = new Random();
//        int index = random.nextInt(SUPPORTED_LOCALES.length);
//        return SUPPORTED_LOCALES[index];
//    }
//
//    public static class WelcomeMessagesDto {
//        private String message;
//        private String locale;
//
//        public WelcomeMessagesDto(String message, String locale) {
//            this.message = message;
//            this.locale = locale;
//        }
//
//        public String getMessage() {
//            return message;
//        }
//
//        public void setMessage(String message) {
//            this.message = message;
//        }
//
//        public String getLocale() {
//            return locale;
//        }
//
//        public void setLocale(String locale) {
//            this.locale = locale;
//        }
//    }
//}