package model;

public class Teacher extends Person{
    private String speciality;

    public Teacher() {
    }

    public Teacher(String id, String name, String birthDay, boolean gender, String speciality) {
        super(id, name, birthDay, gender);
        this.speciality = speciality;
    }



    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Giảng viên {" +
                "Mã số: " + getId() + '\'' +
                ", Họ và tên: " + getName() + '\'' +
                ", Ngày sinh: " + getBirthDay() + '\'' +
                ", Giới tính: " + isGender() +
                ", Chuyên ngành: " + speciality + '\'' +
                '}';
    }
}
