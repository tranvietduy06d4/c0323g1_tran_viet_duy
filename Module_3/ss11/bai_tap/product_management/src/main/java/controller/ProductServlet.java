package controller;

import model.Product;
import service.IProductService;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showFormCreate":
                showFormCreate(request,response);
                break;
            case "showFormEdit":
                showFormEdit(request,response);
                break;
            case "showFormDelete":
                showFormDelete(request,response);
                break;
            case "showFormView":
                showFormView(request,response);
                break;
            default:
                showList(request,response);
        }

    }

    private void showFormView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.getById(id);
        RequestDispatcher requestDispatcher;
        if (product ==null) {
            requestDispatcher=request.getRequestDispatcher("/error.jsp");
        } else {
            request.setAttribute("product",product);
            requestDispatcher = request.getRequestDispatcher("/view.jsp");
        }
        requestDispatcher.forward(request,response);
    }

    private void showFormDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.getById(id);
        RequestDispatcher requestDispatcher;
        if (product == null) {
            requestDispatcher = request.getRequestDispatcher("/error.jsp");
        } else {
            request.setAttribute("product",product);
            requestDispatcher = request.getRequestDispatcher("/delete.jsp");
        }
        requestDispatcher.forward(request,response);

    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.getById(id);
        RequestDispatcher requestDispatcher;
        if (product == null) {
            requestDispatcher = request.getRequestDispatcher("/error.jsp");
        } else {
            request.setAttribute("product",product);
            requestDispatcher = request.getRequestDispatcher("/edit.jsp");
        }
        requestDispatcher.forward(request,response);


    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/add.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = productService.displayAll();
        String msg = request.getParameter("msg");
        request.setAttribute("list",list);
        request.setAttribute("msg",msg);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/list.jsp");
        requestDispatcher.forward(request,response);

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
            case "delete":
                delete(request,response);
                break;

        }



    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.getById(id);
        RequestDispatcher requestDispatcher;
        if (product == null){
            requestDispatcher = request.getRequestDispatcher("/error.jsp");
            requestDispatcher.forward(request,response);
        } else {
            this.productService.remove(id);
            response.sendRedirect("/ProductServlet");
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String producer = request.getParameter("producer");
        Product product = productService.getById(id);
        RequestDispatcher requestDispatcher;
        if (product == null){
            requestDispatcher = request.getRequestDispatcher("/error.jsp");
        } else {

            this.productService.edit(id,new Product(id,name,price,description,producer));

            request.setAttribute("message","Cập nhật thành công sản phẩm");
            requestDispatcher = request.getRequestDispatcher("/edit.jsp");
        }
        requestDispatcher.forward(request,response);


    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String producer = request.getParameter("producer");
        Product product = new Product(id,name,price,description,producer);
        productService.create(product);
        try {
            response.sendRedirect("/ProductServlet?msg=Them%20moi%20thanh%20cong");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
