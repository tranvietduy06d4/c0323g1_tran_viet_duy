package common;

import model.Person;
import model.Student;
import model.Teacher;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
//    public static List<Person> readFile (String path) {
//        List<String> personString = new ArrayList<>();
//        try {
//            FileReader fileReader = new FileReader(path);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String line = "";
//            while ((line = bufferedReader.readLine()) !=null) {
//                personString.add(line);
//            }
//            bufferedReader.close();
//        } catch (FileNotFoundException f) {
//            System.out.println("File không tồn tại");
//        } catch (IOException i) {
//            System.out.println("Lỗi đọc File");
//        } catch (Exception e) {
//            System.out.println("Lỗi Errors");
//        }
//        return personString;
//    }

    public static void writeFileStudent(String path, List<Person> studentList, boolean append) {
        try {
            FileWriter fileWriter = new FileWriter(path, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < studentList.size(); i++) {
                bufferedWriter.write(studentList.get(i).getInfoToCsv());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static List<Person> readFileStudent (String path) {
        List<Person> studentList = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            while ((line = bufferedReader.readLine())!= null) {
                String[] string = line.split(",");
//                public Student(String id, String name, String birthDay, boolean gender, String className, int score)
                studentList.add(new Student(string[0],string[1],string[2],Boolean.parseBoolean(string[3]),string[4],Integer.parseInt(string[5])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");;
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        } catch (Exception e) {
            System.out.println("Lỗi Error");
        }
        return studentList;
    }

    public static void writeFileTeacher(String path, List<Person> teacherList, boolean append) {
        try {
            FileWriter fileWriter = new FileWriter(path, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < teacherList.size(); i++) {
                bufferedWriter.write(teacherList.get(i).getInfoToCsv());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Person> readFileTeacher (String path) {
        List<Person> teacherList = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            while ((line = bufferedReader.readLine())!= null) {
                String[] string = line.split(",");
//              public Teacher(String id, String name, String birthDay, boolean gender, String speciality)
                teacherList.add(new Teacher(string[0],string[1],string[2],Boolean.parseBoolean(string[3]),string[4]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");;
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        } catch (Exception e) {
            System.out.println("Lỗi Error");
        }
        return teacherList;
    }
}



