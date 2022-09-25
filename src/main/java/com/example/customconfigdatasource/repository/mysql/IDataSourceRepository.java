package com.example.customconfigdatasource.repository.mysql;

import com.example.customconfigdatasource.model.mysql.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IDataSourceRepository extends JpaRepository<Book,Integer> {
}
