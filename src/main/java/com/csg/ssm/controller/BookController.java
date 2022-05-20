package com.csg.ssm.controller;

import com.csg.ssm.pojo.Books;
import com.csg.ssm.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class BookController {
    //controller,调用service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;
    //查询全部书籍并返回到首页
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list = bookService.selectAllBooks();
        model.addAttribute("list",list);
        return "allBook";
    }

    //跳转到增加书籍页面
    @RequestMapping(value = "/toAddBook")
    public String toAddBook(){
        return "addBook";
    }
    //添加书籍
    @RequestMapping("/addBook")
    public String addBook(Books books){
        bookService.addBook(books);
        return  "redirect:/allBook";
    }
    //跳转到修改书籍页面
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model,int id){
        Books book = bookService.selectBookById(id);
        model.addAttribute(book);
        return "updateBook";
    }
    //通过id实现修改书籍功能
    @RequestMapping("/updateBook")
    public String updateBook(Model model,Books book){
        //把经前端修改后Books对象传给后端,后端对其修改
        System.out.println(book);
        bookService.updateBook(book);
        //查询前端修改后book的id来获得已经在数据库中的该书对象
        Books books = bookService.selectBookById(book.getBookID());
        //再将该书放到请求域中让前端获取
        model.addAttribute("books",books);
        return  "redirect:/allBook";
    }
    //通过id删除书籍
    @RequestMapping("/deleteBook")
    public String deleteBook(int id){
        bookService.deleteBook(id);
        return "redirect:/allBook";
    }
    //书籍查询功能
    @RequestMapping("/selectBook")
    public String selectBook(Model model,String selectedBookName){
        Books books = bookService.selectBookByName(selectedBookName);
        List<Books> list = new ArrayList<Books>();
        if(books == null){
           model.addAttribute("error","未查到！！！");
           list = bookService.selectAllBooks();
        }
        list.add(books);
        model.addAttribute("list",list);
        return "/allBook";
    }
}
