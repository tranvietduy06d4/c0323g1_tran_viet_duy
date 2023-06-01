package repository.impl;

import model.Person.Employee;
import repository.IEmployeeRepository;
import utils.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private List<Employee> employeeList = new ArrayList<>();
    private static final String PATH_EMPLOYEE = "src/data/employee_list.csv";


    @Override
    public List<Employee> getAll() {
        List<String> string = ReadAndWrite.readFile(PATH_EMPLOYEE);
        employeeList.clear();
        String[] info;
//        public Employee(String personCode, String personName, String birthDay, boolean gender, int personId, int phoneNumber, String email, String level, String position, int salary)
        for (String str:string) {
            info = str.split(",");
            employeeList.add(new Employee(info[0],info[1],info[2],Boolean.parseBoolean(info[3]),info[4],info[5],info[6],info[7],info[8],Float.parseFloat(info[9])));
        }
        return employeeList;

    }
    @Override
    public Employee getByCode(String employeeCode) {
        employeeList = getAll();
        for (Employee e:employeeList) {
            if(e.getPersonCode().equals(employeeCode)) {
                return e;
            }
        }
        return null;
    }

//        public Employee(String personCode, String personName, String birthDay, boolean gender, int personId, int phoneNumber, String email, String level, String position, int salary)

    @Override
    public void addNew(Employee employee) {
        List<String> string = new ArrayList<>();
        string.add(employee.getPersonCode()+","+employee.getPersonName()+","+employee.getBirthDay()+","+employee.isGender()+","+employee.getPersonId()+","+employee.getPhoneNumber()+","+employee.getEmail()+","+employee.getLevel()+","+employee.getPosition()+","+employee.getSalary());
        ReadAndWrite.writeFile(PATH_EMPLOYEE,string,true);
    }

//        public Employee(String personCode, String personName, String birthDay, boolean gender, int personId, int phoneNumber, String email, String level, String position, int salary)

    @Override
    public void deleteEmployee(Employee employeeCheck) {
        employeeList = getAll();
        employeeList.remove(employeeCheck);
        List<String> string = new ArrayList<>();
        for (Employee e:employeeList) {
            string.add(e.getPersonCode()+","+ e.getPersonName()+","+e.getBirthDay()+","+e.isGender()+","+e.getPersonId()+","+e.getPhoneNumber()+","+e.getEmail()+","+e.getLevel()+","+e.getPosition()+","+e.getSalary());
        }
        ReadAndWrite.writeFile(PATH_EMPLOYEE,string,false);
    }
}
