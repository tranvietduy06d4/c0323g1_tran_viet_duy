package model;

public class Student extends Person {

    private String className;
    private int score;

    public Student() {
    }

    public Student(String id, String name, String birthDay, boolean gender, String className, int score) {
        super(id, name, birthDay, gender);
        this.className = className;
        this.score = score;
    }


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public String toString() {
        return "Học viên{" +
                "mã số: " + getId() + '\'' +
                ", Họ và tên: " + getName() + '\'' +
                ", Ngày sinh: " + getBirthDay() + '\'' +
                ", giới tính " + isGender() +
                ", Tên lớp: "  + className + '\'' +
                ", Điểm số: " + score +
                '}';
    }

    @Override
    public String getInfoToCsv() {
        return super.getInfoToCsv() +"," +this.className +"," +this.score;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
