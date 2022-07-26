package Gin.book.service;

import Gin.book.pojo.Book;

import java.util.List;

public interface BookService {
    List<Book> getBookList();

    Book getBook(Integer id);
}
