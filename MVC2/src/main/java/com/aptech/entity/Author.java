package com.aptech.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
//@NoArgsConstructor
@Entity
@Table(name = "tblAuthor")
public class Author {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	@NotBlank()
	private String name;

	@Column(name = "email")
	@NotBlank()
	@Email()
	private String email;

	@Column(name = "gender")
	@NotBlank()
	private String gender;

//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	private List<Book> books;

	public Author() {
		//books = new ArrayList<>();
	}

	public Author(String name, String email, String gender) {
		this.name = name;
		this.email = email;
		this.gender = gender;
	}

}
