package com.aptech.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.aptech.entity.Author;
import com.aptech.entity.Book;

public class AuthorRepo {
	public  final EntityManagerFactory emf = Persistence.createEntityManagerFactory("MVC2");

	public Author add(Author author) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(author);
			em.getTransaction().commit();
			return author;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			 em.getTransaction().rollback();
			return null;
		} finally {
			em.close();
//			emf.close();
		}

	}

	public List<Author> getAll() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		String sql = " FROM Author";
		//try {
		  Query authors = em.createQuery(sql, Author.class);
		  return authors.getResultList();
	}

	public Author update(Author author) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(author);
			em.getTransaction().commit();
			return author;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			em.getTransaction().rollback();
			return null;
		} finally {
			em.close();
			//emf.close();
		}
	}

	public Author delete(int id) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Author a = em.find(Author.class, id);
			em.remove(a);
			em.getTransaction().commit();
			return a;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			em.getTransaction().rollback();
			return null;
		} finally {
			em.close();
			//emf.close();
		}
	}

	public Author getById(int id) {
		EntityManager em = emf.createEntityManager();
		try {
			Author a = em.find(Author.class, id);
			return a;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		} finally {
			em.close();
			//emf.close();
		}
	}
	

}
