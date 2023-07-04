package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String DATE_OF_BIRTH_REGEX = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
    private static final String YEAR_REGEX = "\\d{4}";
    private static final String NAME_REGEX = "^[A-Za-z\\s]+$";

    public static boolean isValidDateOfBirth(String dateOfBirth) {
        Pattern pattern = Pattern.compile(DATE_OF_BIRTH_REGEX);
        Matcher matcher = pattern.matcher(dateOfBirth);
        return matcher.matches();
    }

    public static boolean isValidName(String name) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static boolean isValidYear(String year) {
        Pattern pattern = Pattern.compile(YEAR_REGEX);
        Matcher matcher = pattern.matcher(year);
        return matcher.matches();
    }
}
