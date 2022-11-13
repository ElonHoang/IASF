package com.aptech.service.BookServiceImpl;

import java.util.List;

import com.aptech.entity.Book;
import com.aptech.repository.BookRepo;
import com.aptech.service.CRUDService;

public class BookServiceImpl implements CRUDService<Book> {
	private BookRepo repo = new BookRepo();
	@Override
	public List<Book> getAll() {
		// TODO Auto-generated method stub
		return repo.getAll();
	}

	@Override
	public Book add(Book a) {
		// TODO Auto-generated method stub
		return repo.add(a);
	}

	@Override
	public Book update(Book a) {
		// TODO Auto-generated method stub
		return repo.updateBook(a);
	}

	@Override
	public Book delete(int id) {
		// TODO Auto-generated method stub
		return repo.delete(id);
	}

	@Override
	public Book findById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

}
