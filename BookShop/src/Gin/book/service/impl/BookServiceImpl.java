package Gin.book.service.impl;

import Gin.book.dao.BookDAO;
import Gin.book.pojo.Book;
import Gin.book.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDAO bookDAO;

    @Override
    public List<Book> getBookList() {

        return bookDAO.getBookList();
    }

    @Override
    public Book getBook(Integer id) {
        return bookDAO.getBook(id);
    }
}
