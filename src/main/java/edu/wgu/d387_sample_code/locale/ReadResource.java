package edu.wgu.d387_sample_code.locale;

import java.util.Locale;
import java.util.ResourceBundle;

public class ReadResource {
    private Locale locale;
    private ResourceBundle resourceBundle;

    public String getWelcomeMessage() {
        return resourceBundle.getString("Greeting");
    }

    public ReadResource() {

    }

    public ReadResource(String language, String country){
        locale = new Locale(language,country);
        resourceBundle = ResourceBundle.getBundle("rBundle",locale);
        System.out.printf("%s, %s%n",language, country);
    }

}

