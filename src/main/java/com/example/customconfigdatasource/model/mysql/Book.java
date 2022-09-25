package com.example.customconfigdatasource.model.mysql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PersistenceUnit;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="BOOK_TB")
@PersistenceUnit(unitName="Book")
public class Book {

	@Id
	private int id;
	private String name;
}
