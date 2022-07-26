package Gin.book.dao;

import Gin.book.pojo.Book;

import java.util.List;

public interface BookDAO {

    List<Book> getBookList();
    Book getBook(Integer id);
}
