package com.aptech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.NumberFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "tblBook")
public class Book {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	@NotBlank()
	private String name;

	@Column(name = "price")
	@NumberFormat()
	private int price;
	@NumberFormat
	@Column(name = "quantity")
	private int quantity;

	@ManyToOne()
	@JoinColumn(name = "author_id")
	private Author author;

	public Book() {

	}

	public Book(String name, int price, int quantity, Author author) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.author = author;
	}

}
