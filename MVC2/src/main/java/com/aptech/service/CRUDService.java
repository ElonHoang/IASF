package com.aptech.service;

import java.util.List;
import java.util.Optional;

public interface CRUDService<T> {
	public List<T> getAll();
	public T add(T a);
	public T update(T a);
	public T delete(int id);
	public T findById(int id);
}
