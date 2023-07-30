package com.example.controller;

import com.example.model.Book;
import com.example.model.Code;
import com.example.service.IBookService;
import com.example.service.ICodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Random;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private ICodeService codeService;
    @GetMapping("/book/list")
    public String showBookList(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookingList",bookList);
        return "list";
    }

    @GetMapping("/book/detail/{id}")
    public String showDetail(@PathVariable int id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book",book);
        return "detail";
    }

    @PostMapping("/book/borrow")
    public String borrowBook(@RequestParam int id, Model model) {
        Book book = bookService.findById(id);
        if(book.getQuantity()>0) {
            book.setQuantity(book.getQuantity()-1);
            bookService.add(book);
            Random random = new Random();
            int rentCode = random.nextInt(90000) + 10000;
            codeService.add(rentCode,book);
            model.addAttribute("rentCode",rentCode);
            return "borrow";
        } else {
            model.addAttribute("message","This book is out of rent");
            model.addAttribute("book",book);
            return "detail";
        }
    }

    @GetMapping("/book/give_back")
    public String showFormGiveBackBook() {
        return "give_book_back";
    }
    @PostMapping("/book/give_back")
    public String giveBookBack(@RequestParam int rentCode, RedirectAttributes redirectAttributes) {
        Code code = codeService.findCodeByRentCode(rentCode);
        if(code!=null) {
            Book book = code.getBook();
            book.setQuantity(book.getQuantity()+1);
            bookService.add(book);
            codeService.deleteByCode(code);
            redirectAttributes.addFlashAttribute("message","Give book back success!");
            return "redirect:/book/list";
        }
        return "errors";
        }
    }

