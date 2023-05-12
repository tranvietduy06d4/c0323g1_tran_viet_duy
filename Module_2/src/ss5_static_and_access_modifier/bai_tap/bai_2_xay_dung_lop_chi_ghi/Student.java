package ss5_static_and_access_modifier.bai_tap.bai_2_xay_dung_lop_chi_ghi;

public class Student {
    private String name = "John";
    private String classes = "C02";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    protected void setClasses(String classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                '}';
    }
}
