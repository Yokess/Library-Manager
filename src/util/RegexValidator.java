package util;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexValidator {

    // 正则表达式
    private static final String EMAIL_REGEX = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
    private static final String PHONE_REGEX = "^\\+?1?\\d{10,15}$";
    private static final String ZIP_CODE_REGEX = "^\\d{5}(-\\d{4})?$";
    private static final String DATE_REGEX = "^\\d{4}-\\d{2}-\\d{2}$";
    private static final String URL_REGEX = "^(https?|ftp)://[\\w.-]+(?:\\.[\\w.-]+)+[/#?]?.*$";
    private static final String USERNAME_REGEX = "^[a-zA-Z0-9_]{3,16}$";
    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z]).{8,16}$";

    // 判断方法
    public static boolean isEmail(String input) {
        return matches(input, EMAIL_REGEX);
    }

    public static boolean isPhone(String input) {
        return matches(input, PHONE_REGEX);
    }


    public static boolean isZipCode(String input) {
        return matches(input, ZIP_CODE_REGEX);
    }

    public static boolean isDate(String input) {
        return matches(input, DATE_REGEX);
    }



    public static boolean isURL(String input) {
        return matches(input, URL_REGEX);
    }


    public static boolean isUsername(String input) {
        return matches(input, USERNAME_REGEX);
    }
    public static boolean isPassword(String input) {
        return matches(input, PASSWORD_REGEX);
    }


    // 私有匹配方法
    private static boolean matches(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}