package ss18_string_and_regex.bai_tap.bai_1_validate_ten_lop;

public class ClassNameValidate {
    public static boolean validateClassName(String className, String regexClassName) {
        return className.matches(regexClassName);
    }
}
