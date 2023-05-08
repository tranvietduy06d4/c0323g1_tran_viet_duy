package ss1_introduction_java.bai_tap.bai_2_ung_dung_doc_so_thanh_chu;

import java.util.Scanner;

public class NumberSpeaking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your number: ");
        int number = scanner.nextInt();
        String result = "";
        if (number < 1 || number >= 1000) {
            System.out.println("Sai. Vui lòng nhập lại số nguyên dương trong khoảng từ 1 đến 999 để kiểm tra");
        } else {
            int hundred, tens, ones;
            hundred = number / 100;
            tens = (number % 100) / 10;
            ones = number % 10;
            String hundredStr = "";
            String tensStr = "";
            String onesStr = "";

            switch (hundred) {
                case 0:
                    break;
                case 1:
                    hundredStr += "one hundred ";
                    break;
                case 2:
                    hundredStr += "two hundred ";
                    break;
                case 3:
                    hundredStr += "three hundred ";
                    break;
                case 4:
                    hundredStr += "four hundred ";
                    break;
                case 5:
                    hundredStr += "five hundred ";
                    break;
                case 6:
                    hundredStr += "six hundred ";
                    break;
                case 7:
                    hundredStr += "seven hundred ";
                    break;
                case 8:
                    hundredStr += "eight hundred ";
                    break;
                case 9:
                    hundredStr += "nine hundred ";
                    break;
            }

            switch (tens) {
                case 0:
                    break;
                case 1:
                    switch (ones) {
                        case 0:
                            tensStr += "ten";
                            break;
                        case 1:
                            tensStr += "eleven";
                            break;
                        case 2:
                            tensStr += "twelve";
                            break;
                        case 3:
                            tensStr += "thirteen";
                            break;
                        case 4:
                            tensStr += "fourteen";
                            break;
                        case 5:
                            tensStr += "fifteen";
                            break;
                        case 6:
                            tensStr += "sixteen";
                            break;
                        case 7:
                            tensStr += "seventeen";
                            break;
                        case 8:
                            tensStr += "eighteen";
                            break;
                        case 9:
                            tensStr += "nineteen";
                            break;
                    }
                    break;
                case 2:
                    tensStr += "twenty";
                    break;
                case 3:
                    tensStr += "thirty";
                    break;
                case 4:
                    tensStr += "forty";
                    break;
                case 5:
                    tensStr += "fifty";
                    break;
                case 6:
                    tensStr += "sixty";
                    break;
                case 7:
                    tensStr += "seventy";
                    break;
                case 8:
                    tensStr += "eighty";
                    break;
                case 9:
                    tensStr += "ninety";
                    break;
            }

            switch (ones) {
                case 0:
                    break;
                case 1:
                    onesStr += "one";
                    break;
                case 2:
                    onesStr += "two";
                    break;
                case 3:
                    onesStr += "three";
                    break;
                case 4:
                    onesStr += "four";
                    break;
                case 5:
                    onesStr += "five";
                    break;
                case 6:
                    onesStr += "six";
                    break;
                case 7:
                    onesStr += "seven";
                    break;
                case 8:
                    onesStr += "eight";
                    break;
                case 9:
                    onesStr += "nine";
                    break;
            }
            if (tens == 1) {
                result += hundredStr + tensStr;
            } else {
                result += hundredStr + tensStr + onesStr;
            }
            System.out.println(result);

        }
    }
}


