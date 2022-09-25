package com.example.customconfigdatasource.repository.postgres;

import com.example.customconfigdatasource.model.postgres.BookPojo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//@Repository
public class BookRepositoryCustom {

    @PersistenceContext

    private EntityManager entityManager;
    public BookPojo getBookById (@Qualifier("postgrestEntityManagerFactory") int id){

        BookPojo bookPojo= entityManager.find(BookPojo.class,id);
        return bookPojo;
    }
}
