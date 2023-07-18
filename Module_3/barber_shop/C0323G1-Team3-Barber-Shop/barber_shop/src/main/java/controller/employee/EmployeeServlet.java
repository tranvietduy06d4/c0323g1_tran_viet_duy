package controller.employee;

import model.Account;
import model.Employee;
import repository.account.impl.AccountRepository;
import service.account.IAccountService;
import service.account.impl.AccountService;
import service.employee.IEmployeeService;
import service.employee.impl.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService employeeService = new EmployeeService();
    private IAccountService accountService = new AccountService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action ==null) {
            action="";
        }
        switch (action) {
            case "showFormCreate":
                showFormCreate(request,response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            case "delete":
                showFormDelete(request, response);
                break;
            default:
                showList(request,response);
        }

    }

    private void showFormDelete(HttpServletRequest request, HttpServletResponse response) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.getById(employeeId);
        RequestDispatcher requestDispatcher;
        if (employee == null) {
            requestDispatcher= request.getRequestDispatcher("/employee/error.jsp");
        } else {
            request.setAttribute("employee",employee);
            requestDispatcher = request.getRequestDispatcher("/employee/delete.jsp");
        }

        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.getById(employeeId);
        RequestDispatcher requestDispatcher;
        if (employee == null) {
            requestDispatcher= request.getRequestDispatcher("/employee/error.jsp");
        } else {
            request.setAttribute("employee",employee);
            request.setAttribute("id",employeeId);
            requestDispatcher = request.getRequestDispatcher("/employee/edit.jsp");
        }

        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/employee/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = employeeService.display();
        request.setAttribute("employeeList",employeeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/employee/employeeList.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action ==null) {
            action="";
        }
        switch (action) {
            case "create":
                create(request,response);
                break;
            case "edit":
                edit(request,response);
                break;
            case "delete":
                delete(request,response);
                break;
            default:
                showList(request, response);
        }

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        employeeService.remove(employeeId);
        try {
            response.sendRedirect("/EmployeeServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        String employeeName = request.getParameter("name");
        String birthDay = request.getParameter("birthDay");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phoneNumber = request.getParameter("phoneNumber");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String address = request.getParameter("address");
        Employee employee = new Employee(employeeId,employeeName,birthDay,salary,phoneNumber,gender,idCard,address);
        employeeService.edit(employee);
        try {
            response.sendRedirect("/EmployeeServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void create(HttpServletRequest request, HttpServletResponse response)  {
        String employeeName = request.getParameter("employeeName");
        String birthDay = request.getParameter("birthDay");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phoneNumber = request.getParameter("phoneNumber");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String address = request.getParameter("address");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Account account=new Account(username,password);
        this.employeeService.insertAccount(account);
        int accountId=employeeService.getEmployeeAccountId(username);
        Employee employee = new Employee(employeeName, birthDay, salary, phoneNumber, gender, idCard, address, accountId);
        this.employeeService.create(employee);

        try {
            response.sendRedirect("/EmployeeServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
