package org.example.controllers;

import org.example.classes.Book;
import org.example.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class AjaxBooksController {

    @Autowired
    private BookDao bookDao;

    @GetMapping(path ="showBooks")
    public List<Book> getBooks() throws SQLException {
        return bookDao.showBooks();
    }

    @PostMapping("/add_book")
    public void changeBook(@RequestBody Book book) { bookDao.saveBook(book);
    }

    @PostMapping("/deleteBook")
    public void deleteBook(@RequestBody Book book) {
        bookDao.deleteBook(book.getId());
    }

    @PostMapping("/updateBook")
    public void updateBook(@RequestBody Book book) {
        bookDao.updateBook(book);
    }

    @GetMapping(path ="/listBooks")
    public List<Book> listBooks(@RequestBody String book) throws SQLException { return bookDao.listBooks(book); }


}
