package utils;

public class Regex {
    public static boolean checkName(String name, String nameRegex) {
        return name.matches(nameRegex);
    }
    public static boolean checkId(String id, String idRegex) {
        return id.matches(idRegex);
    }
    public static boolean checkPhoneNumber(String phoneNumber, String phoneNumberRegex) {
        return phoneNumber.matches(phoneNumberRegex);
    }
    public static boolean checkCode(String employeeCode, String codeRegex) {
        return employeeCode.matches(codeRegex);
    }
    public static boolean checkBirthDay(String birthDay, String birthDayRegex) {
        return birthDay.matches(birthDayRegex);
    }
    public static boolean checkEmail(String email, String emailRegex){
        return email.matches(emailRegex);
    }
}
