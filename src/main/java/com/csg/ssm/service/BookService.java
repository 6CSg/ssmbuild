package com.csg.ssm.service;

import com.csg.ssm.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    int addBook(Books book);
    int deleteBook( int id);
    int updateBook( Books book);
    Books selectBookById(int id);
    List<Books> selectAllBooks();
    Books selectBookByName(String bookName);
    int deleteAllBooks2();
}
