package org.example.dao;


import org.example.classes.Book;
import org.example.dao.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookDao {

        private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> showBooks() throws SQLException {
        return jdbcTemplate.query("SELECT * from books", new BeanPropertyRowMapper<>(Book.class));
    }

    public void saveBook(Book book) {
        jdbcTemplate.update("INSERT INTO books VALUES(default,?,?,?)", book.getName(),book.getYear(),book.getAuthor());
    }

    public Book updateBook(Book updatedBook) {
        jdbcTemplate.update("UPDATE books SET Name=?, Year=?, Author=? WHERE id=?", updatedBook.getName(),updatedBook.getYear(),updatedBook.getAuthor(),updatedBook.getId());
        return updatedBook;
    }

    public void deleteBook(int id) {
        jdbcTemplate.update("DELETE FROM books WHERE id=?", id);
    }

    public List<Book> listBooks(String author2) throws  SQLException {
       return jdbcTemplate.query("SELECT * from books WHERE author = ?", new Object[]{author2}, new BookMapper()).stream().toList();
    }




}




