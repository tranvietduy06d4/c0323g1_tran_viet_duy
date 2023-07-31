package com.example.aop;

import com.example.model.Book;
import com.example.model.Code;
import com.example.service.IBookService;
import com.example.service.ICodeService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class Logger {
    @Autowired
    private IBookService bookService;
    @Autowired
    private ICodeService codeService;
    private static int numberOfVisit = 0;
    private static int numberOfBorrow = 0;
    private static int numberOfGiveBack= 0;
    @After("execution(* com.example.controller.BookController.*(..))")
    public void calculateNumberOfVisitPage(JoinPoint joinPoint){
        numberOfVisit++;
        System.out.println("Tổng số lượt truy cập trang web tính đến hiện tại là:" +numberOfVisit);
    }

    @AfterReturning("execution(* com.example.controller.BookController.borrowBook(..))")
    public void loggOfBorrow(JoinPoint joinPoint){
        numberOfBorrow++;
        Object[] args = joinPoint.getArgs();
        Book book = bookService.findById((int) args[0]);
        System.out.println(book);
        System.out.println("Tên sách: " +book.getName() +" Số lượng cho mượn: 01 quyển " +"Số lượng còn lại: " +book.getQuantity());
        System.out.println("Tổng số quyển sách được cho mượn tính đến hiện tại là:" +numberOfBorrow);
    }
    @AfterReturning("execution(* com.example.controller.BookController.giveBookBack(..))")
    public void loggOfGiveBack(JoinPoint joinPoint){
        numberOfGiveBack++;
        Object[] args = joinPoint.getArgs();
        int rentCode = (int) args[0];
        System.out.println(rentCode);
        Code code = codeService.findCodeByRentCode(rentCode);
        System.out.println(code);
        Book book = code.getBook();
        System.out.println("Tên sách: " +book.getName() +" Số lượng thu hồi: 01 quyển " +"Số lượng còn trong kho: " +book.getQuantity());
        System.out.println("Tổng số quyển sách đã thu hồi tính đến hiện tại là:" +numberOfGiveBack);
    }


}
