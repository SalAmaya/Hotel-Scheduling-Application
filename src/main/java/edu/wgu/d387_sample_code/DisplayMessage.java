package edu.wgu.d387_sample_code;

import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

public class DisplayMessage {
    private static final String BASE_NAME = "WelcomeMessage"; // Name of the resource bundle file
    private Locale locale;

    public DisplayMessage(Locale locale) {
        this.locale = locale;
    }

    public String getWelcomeMessage() {
        return ResourceBundle.getBundle(BASE_NAME, locale).getString("WelcomeMessage");
    }

    public static void main(String[] args) {
        DisplayMessage displayMessageUS1 = new DisplayMessage(Locale.US);

        DisplayMessage displayMessageFrench1 = new DisplayMessage(Locale.CANADA_FRENCH);

        // Store the instances in an array
        DisplayMessage[] messages = { displayMessageUS1, displayMessageFrench1};

        // Shuffle the array to randomize the order
        shuffleArray(messages);

        // Print the welcome messages
        for (DisplayMessage message : messages) {
            System.out.println(message.getWelcomeMessage());
        }
    }

    // Method to shuffle an array
    private static void shuffleArray(DisplayMessage[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            // Swap array[i] with array[index]
            DisplayMessage temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}