package com.aptech.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aptech.entity.Author;
import com.aptech.entity.Book;
import com.aptech.repository.BookRepo;
import com.aptech.service.CRUDService;
import com.aptech.service.AuthorServiceImpl.AuthorServiceImpl;
import com.aptech.service.BookServiceImpl.BookServiceImpl;

@Controller
@RequestMapping("/book")
public class BookController {
	CRUDService<Book> bookService = new BookServiceImpl();
	CRUDService<Author> authorService = new AuthorServiceImpl();
	BookRepo repo = new BookRepo();

	@GetMapping("/list")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("book");
		mav.addObject("book", bookService.getAll());
		return mav;
	}

	@GetMapping("/addBook")
	public ModelAndView save() {
		ModelAndView mav = new ModelAndView("saveBook");
		mav.addObject("book", new Book());
		mav.addObject("action", "");
		mav.addObject("authors", authorService.getAll());
		return mav;
	}
	
	@GetMapping("/updateBook/{id}")
	public String update(@PathVariable("id") int id, Model model) {
		model.addAttribute("book",bookService.findById(id));
		model.addAttribute("authors", authorService.getAll());
		return "saveBook";
	}
	
	@GetMapping("/deleteBook/{id}")
	public String delete(@PathVariable("id") int id, Model model) {
		bookService.delete(id);
		return "redirect:/book/list";
	}
	
//	@PostMapping("/updateBook/submitForm")
//	public ModelAndView updateForm(@Valid @ModelAttribute("book") Book book, BindingResult rs) {
//		return submitForm(book,rs);
//	}

	@RequestMapping(value = {"/submitForm", "/updateBook/submitForm"}, method = RequestMethod.POST)
	public ModelAndView submitForm(@Valid @ModelAttribute("book") Book book, BindingResult rs) {
		ModelAndView mav = new ModelAndView("saveBook");
		if (rs.hasErrors()) {
			mav.addObject("authors", authorService.getAll());
			mav.addObject(book);
		} else {
			if (book.getId() <= 0) {
				bookService.add(book);
				mav.addObject("message", "Created !");
				mav.addObject("authors", authorService.getAll());
			} else {
				bookService.update(book);
				mav.addObject("message", "Updated !");
				mav.addObject("authors", authorService.getAll());
			}

		}
		return mav;

	}

}
