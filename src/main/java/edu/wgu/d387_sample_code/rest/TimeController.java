package edu.wgu.d387_sample_code.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@RestController
@RequestMapping("/time")
@CrossOrigin
public class TimeController {

    final private String startTime = "06:00PM EST";
    // Reference: https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html
    final private String dateTimeFormat = "hh:mma z";
    final private String[] timeZones = new String[]{"EST","MST","UTC"};
    private SimpleDateFormat timeFormater = new SimpleDateFormat(dateTimeFormat);


    @GetMapping("/presentation")
    public ResponseEntity<List<String>> getLivePresentationTimes() {
        List<String> presentationTimes = new ArrayList<String>();

        try {
            // Parse the start date then format it to each timezone
            Date date = timeFormater.parse(startTime);

            // Loop through each timezone and generate the date.
            for (String t : timeZones) {
                // Set the timezone
                TimeZone tz = TimeZone.getTimeZone(t);
                timeFormater.setTimeZone(tz);
                // Format startDate to the respective timezone
                String dateOut = timeFormater.format(date);
                presentationTimes.add(dateOut);
            }

            // Format EST time
            TimeZone tzEST = TimeZone.getTimeZone("EST");
            timeFormater.setTimeZone(tzEST);


            // Format MST time
            TimeZone tzMST = TimeZone.getTimeZone("MST");

            // Format UTC time
            TimeZone tzUTC = TimeZone.getTimeZone("UTC");

        } catch (Exception e) {
            System.out.println(e.toString());
            presentationTimes.add(e.toString());
        }

        return ResponseEntity.ok(presentationTimes);
    }


}
