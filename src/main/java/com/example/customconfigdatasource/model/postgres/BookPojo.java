package com.example.customconfigdatasource.model.postgres;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="book_control")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookPojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_control")
    private int id;
    @Column(name="id_book")
    private String idBook;
    @Column(name="title_book")
    private String title;
    @Column(name="year_book")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date year;


}
