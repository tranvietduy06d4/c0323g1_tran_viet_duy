package ss5_static_and_access_modifier.bai_tap.bai_2_xay_dung_lop_chi_ghi;

public class Test {
    public static void main(String[] args) {
        Student studentA = new Student();
        Student studentB = new Student();
        studentA.setName("Duy");
        studentA.setClasses("C03");
        studentB.setName("Vương");
        studentB.setClasses("C04");
        System.out.println(studentA.toString());
        System.out.println(studentB.toString());


    }
}
