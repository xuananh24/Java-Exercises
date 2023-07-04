import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String DATE_OF_BIRTH_REGEX = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final String NAME_REGEX = "^[A-Za-z\\s]+$";
    private static final String PHONE_NUMBER_REGEX = "^\\d{10}$";

    public static boolean isValidBirthDay(String dateOfBirth) {
        Pattern pattern = Pattern.compile(DATE_OF_BIRTH_REGEX);
        Matcher matcher = pattern.matcher(dateOfBirth);
        return matcher.matches();
    }

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidName(String name) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
