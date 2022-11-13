package com.aptech.service.AuthorServiceImpl;

import java.util.List;
import java.util.Optional;

import com.aptech.entity.Author;
import com.aptech.repository.AuthorRepo;
import com.aptech.service.CRUDService;

public class AuthorServiceImpl implements CRUDService<Author> {
	
	private AuthorRepo author = new AuthorRepo();
	
	@Override
	public List<Author> getAll() {
		// TODO Auto-generated method stub
		return author.getAll();
	}

	@Override
	public Author add(Author a) {
		// TODO Auto-generated method stub
		return author.add(a);
	}

	@Override
	public Author update(Author a) {
		// TODO Auto-generated method stub
		return author.update(a);
	}

	@Override
	public Author delete(int id) {
		// TODO Auto-generated method stub
		return author.delete(id);
	}

	@Override
	public Author findById(int id) {
		// TODO Auto-generated method stub
		return author.getById(id);
	}
	

}
