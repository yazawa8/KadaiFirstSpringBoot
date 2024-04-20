package com.techacademy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

    @GetMapping("/")
    public String index() {
        return "Hello SpringBoot!";
    }

    @GetMapping("/dayofweek/{val1}")
    public String dispDayOfWeek(@PathVariable int val1) {
        String[] dayOfWeekString = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date;
        try {
            date = sdf.parse(Integer.toString(val1));
        } catch (ParseException e) {
            e.printStackTrace();
            return "Invalid Date";
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 1; // Calendar.DAY_OF_WEEK returns 1 for Sunday, 2 for Monday, etc.

        return dayOfWeekString[dayOfWeek];
    }

    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 + val2;
        return Integer.toString(res);
    }

    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 - val2;
        return Integer.toString(res);
    }

    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 * val2;
        return  Integer.toString(res);
    }

    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 / val2;
        return Integer.toString(res);
    }

}
