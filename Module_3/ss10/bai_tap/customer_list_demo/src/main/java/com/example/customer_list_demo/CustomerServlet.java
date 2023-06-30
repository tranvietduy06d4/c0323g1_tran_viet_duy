package com.example.customer_list_demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Mai Văn Hoàng","1999-03-21","Hà Nội","https://vnn-imgs-a1.vgcloud.vn/znews-photo.zadn.vn/w660/Uploaded/lce_jwqqc/2020_10_13/3_1602581704108161769165.jpg"));
        customerList.add(new Customer("Nguyễn Văn Nam","2000-04-25","Hồ Chí Minh","https://meliawedding.com.vn/wp-content/uploads/2022/03/hinh-anh-gai-xinh-trung-quoc-95.jpg"));
        customerList.add(new Customer("Trần Văn Minh","1991-01-22","Bắc Ninh","https://samkyvuong.vn/wp-content/uploads/2022/04/girl-tik-tok.jpg"));
        customerList.add(new Customer("Hoàng Hạ","1997-01-20","Đà Nẵng","https://cdn.alongwalk.info/vn/wp-content/uploads/2022/09/28150737/image-69-hinh-anh-gai-xinh-trung-quoc-hot-girl-trung-quoc-dep-nhat-2022-166432725635319.jpg"));
        request.setAttribute("customerList",customerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/list.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
