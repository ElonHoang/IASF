package com.aptech.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.aptech.entity.Author;
import com.aptech.entity.Book;

public class BookRepo {
	public final EntityManagerFactory emf = Persistence.createEntityManagerFactory("MVC2");
	private AuthorRepo author = new AuthorRepo();

	public Book add(Book b) {
		EntityManager em = emf.createEntityManager();
		try {	
			em.getTransaction().begin();
			em.persist(b);
			em.getTransaction().commit();
			return b;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		} finally {
			em.close();
			//emf.close();
		}

	}
	
	public Book updateBook ( Book b) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(b);
			em.getTransaction().commit();
			return b;
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}finally {
			em.close();
		}
	}
	
	public Book findById(int id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Book.class, id);
	}

	public Map<Integer, String> getAuthorName() {
		Map<Integer, String> authorName = new HashMap<>();
		try {
			for (Author a : author.getAll()) {
				authorName.put(a.getId(), a.getName());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		return authorName;

	}

	public List<Book> getAll() {
		EntityManager em = emf.createEntityManager();
		String sql = " FROM Book ";
		return em.createQuery(sql, Book.class).getResultList();
	}

	public Book delete(int id) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Book b = em.find(Book.class, id);
			em.remove(b);
			em.getTransaction().commit();
			return b;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		} finally {
			em.close();
			//emf.close();
		}

	}
}
