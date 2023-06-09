package controller;

import model.User;
import service.IUserService;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    private IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showFormCreate":
                showFormCreate(request, response);
                break;
            case "showFormEdit":
                showFormEdit(request, response);
                break;
            case "delete":
                remove(request,response);
                break;
            case "sortByName":
                sortByName(request,response);
                break;
            default:
                showList(request, response);

        }

    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.getById(id);
        RequestDispatcher requestDispatcher;
        if(user == null) {
            requestDispatcher = request.getRequestDispatcher("/user/error.jsp");
        } else {
            request.setAttribute("user",user);
            requestDispatcher = request.getRequestDispatcher("/user/edit.jsp");
        }
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void remove(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.remove(id);
        List<User> list = userService.displayAll();
        request.setAttribute("list",list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/user/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
           e.printStackTrace();
        }
    }


    private void sortByName(HttpServletRequest request, HttpServletResponse response) {
        List<User> list = userService.sortByName();
        request.setAttribute("list", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/user/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/user/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<User> list = userService.displayAll();
        String msg = request.getParameter("msg");
        request.setAttribute("list", list);
        request.setAttribute("msg", msg);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/user/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request,response);
                break;
            case "edit":
                edit(request,response);
                break;
            case "search":
                searchByCountry(request,response);
                break;
        }

    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id,name,email,country);
        userService.edit(user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/user/edit.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchByCountry(HttpServletRequest request, HttpServletResponse response) {
        String country = request.getParameter("searchByCountry");
        List<User> userList = userService.getByCountry(country);
        RequestDispatcher requestDispatcher;
        if(userList.isEmpty()) {
            requestDispatcher = request.getRequestDispatcher("/user/error.jsp");
        } else {
            request.setAttribute("userList",userList);
            requestDispatcher = request.getRequestDispatcher("/user/searchList.jsp");
        }
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name,email,country);
        userService.create(user);
        try {
            response.sendRedirect("/UserServlet&msg=Bạn%20đã%20thêm%20mới%20thành%20công");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
