//package edu.wgu.d387_sample_code.rest;
//
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import edu.wgu.d387_sample_code.TimeConversion;
//import java.util.Locale;
//import java.util.Random;
//import java.util.ResourceBundle;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Locale;
//import java.util.Random;
//import java.util.ResourceBundle;
//@RestController
//public class TimeZoneConversionController {
//
//    @GetMapping("/time-conversion")
//    public String getTimeConversions(@RequestParam String time) {
//        String conversions = TimeConversion.convertToAll(time);
//        return conversions;
//    }
//}