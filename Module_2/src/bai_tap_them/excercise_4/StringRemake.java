package bai_tap_them.excercise_4;

public class StringRemake {
    public static void main(String[] args) {

    }

    public static String remakeString(String string) {
        String newString = "";
        String upperCase = "ABCDEFGHIKLMNOPQRSTUVXYZ";
//        Cach 1:
        for (int i = 0; i < string.length(); i++) {
            String character = string.substring(i, i + 1);
            if (i == 0) {
                newString += character;
            } else {
                if (upperCase.indexOf(character) != -1) {
                    newString += " " + character;
                } else {
                    newString += character;
                }
            }
        }
        return newString.toLowerCase();

//        Cach 2:
//        String[] str = string.split("");
//        for (int i = 0; i < str.length; i++) {
//            if (upperCase.contains(str[i])) {
//                if (i > 0) {
//                    newString+=" ";
//                }
//                newString+=str[i].toLowerCase();
//            } else {
//                newString +=str[i];
//            }
//        }
//        return newString;
    }
}
