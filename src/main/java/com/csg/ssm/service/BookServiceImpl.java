package com.csg.ssm.service;

import com.csg.ssm.mapper.BookMapper;
import com.csg.ssm.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public int addBook(Books book) {
        return bookMapper.addBook(book);
    }

    public int deleteBook(int id) {
        return bookMapper.deleteBook(id);
    }

    public int updateBook(Books book) {
        return bookMapper.updateBook(book);
    }

    public Books selectBookById(int id) {
        return bookMapper.selectBookById(id);
    }

    public List<Books> selectAllBooks() {
        return bookMapper.selectAllBooks();
    }

    public Books selectBookByName(String bookName) {
        return bookMapper.selectBookName(bookName);
    }

    public int deleteAllBooks() {
        return 88;
    }
}
