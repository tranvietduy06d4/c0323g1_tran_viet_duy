package utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class AgeChecking {
    public static boolean checkAge(String birthDay) {
        LocalDate currentDate = LocalDate.now();
        LocalDate date0fBirth = LocalDate.parse(birthDay);
        int age = Period.between(date0fBirth,currentDate).getYears();
        if(age>=18) {
            return true;
        } else {
            return false;
        }
    }
}
