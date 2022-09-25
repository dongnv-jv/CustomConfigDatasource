package com.example.customconfigdatasource.controller;

import com.example.customconfigdatasource.model.mysql.Book;
import com.example.customconfigdatasource.repository.mysql.IDataSourceRepository;
import com.example.customconfigdatasource.repository.postgres.BookRepositoryCustom;
import com.example.customconfigdatasource.repository.postgres.IBookPojoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
@Controller
public class BookController {
    @Autowired
    private IDataSourceRepository bookRepository;

    @Autowired
    private IBookPojoRepository iBookPojoRepository;
    @GetMapping("/get-all-book1")
    @ResponseBody
    public List<Book> /*ResponseEntity<?>*/ getAllBookMySql(){
        return /*ResponseEntity.ok().body(bookRepository.findAll());*/ bookRepository.findAll();
    }

    @GetMapping("/get-all-book2")
    public ResponseEntity<?> getAllBookPostGres(){
        return ResponseEntity.ok().body(iBookPojoRepository.findAll());
    }
//    @GetMapping("/getbook/{id}")
//    public ResponseEntity<?> getBookById(@PathVariable("id") int id){
//
//        Book book = bookRepositryCustom.getBookById(id);
//
//
//        return ResponseEntity.ok().body(book);
//    }
}
