package com.csg.ssm.mapper;

import com.csg.ssm.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    int addBook(Books book);
    int deleteBook(@Param("bookId") int id);
    int updateBook(Books books);
    Books selectBookById(@Param("bookId") int id);
    List<Books> selectAllBooks();
    Books selectBookName(@Param("bookName") String bookName);
}
