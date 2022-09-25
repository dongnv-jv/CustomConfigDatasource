package com.example.customconfigdatasource.repository.postgres;

import com.example.customconfigdatasource.model.postgres.BookPojo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IBookPojoRepository extends JpaRepository<BookPojo,Integer> {
}
