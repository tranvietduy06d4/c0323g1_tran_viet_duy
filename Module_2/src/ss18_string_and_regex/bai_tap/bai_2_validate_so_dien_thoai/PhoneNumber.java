package ss18_string_and_regex.bai_tap.bai_2_validate_so_dien_thoai;

public class PhoneNumber {
    public static boolean validatePhoneNumber(String phoneNumber, String regexPhoneNumber) {
        return phoneNumber.matches(regexPhoneNumber);
    }
}
