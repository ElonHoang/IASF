package com.aptech.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aptech.entity.Author;
import com.aptech.repository.AuthorRepo;
import com.aptech.service.CRUDService;
import com.aptech.service.AuthorServiceImpl.AuthorServiceImpl;

@Controller
@RequestMapping("/author")
public class AuthorController {
	private AuthorRepo repo = new AuthorRepo();
	private CRUDService<Author> authorService = new AuthorServiceImpl();

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("author", new Author());
		return mav;
	}

	@PostMapping("/submitForm")
	public ModelAndView submitForm(@Valid @ModelAttribute("author") Author author, BindingResult rs) {
		ModelAndView mav = new ModelAndView("home");
		if (rs.hasErrors()) {
			mav.addObject(author);
			
		}else {
			authorService.add(author);
			System.out.println(author);
			mav.addObject("message", "Created !");
		}
	
			
		return mav;
	}
	@GetMapping("/list")
	public ModelAndView getAllAuthor() {
		ModelAndView mav = new ModelAndView("list");
		mav.addObject("authors", authorService.getAll());
		return mav;
	}

}
