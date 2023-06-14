package bai_tap_them.excercise_15;

public class NameChecking {
    public static void main(String[] args) {

    }

    public static boolean checkName(String fileName, String fileType) {
        fileType = fileType.toLowerCase();

        switch (fileType) {
            case "package":
//                if((fileName.charAt(0)))
                break;
            case "class":
                break;
            case "field":
            case "method":
                break;
            default:
                System.out.println("Không phải định dạng file");

        }
        return true;
    }

    private static final String PACKAGE_REGEX = "^[a-z]*$";
//    public static boolean checkPackage(String string) {
//
//    }
}
