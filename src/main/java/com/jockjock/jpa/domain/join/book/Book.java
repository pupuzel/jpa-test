package com.jockjock.jpa.domain.join.book;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;

import com.jockjock.jpa.domain.join.item.Item;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("B")
@PrimaryKeyJoinColumn(name= "BOOK_ID")
@Getter @Setter
public class Book extends Item{

	private String author;
	
	private String isbn;
	
}
