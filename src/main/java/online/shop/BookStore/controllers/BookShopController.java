package online.shop.BookStore.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import online.shop.BookStore.domains.Author;
import online.shop.BookStore.domains.Book;
import online.shop.BookStore.repositories.AuthorRepository;
import online.shop.BookStore.repositories.BookRepository;

@Controller
@RequestMapping("book-shop")
public class BookShopController {

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	
	@Autowired
	public BookShopController(
			AuthorRepository authorRepository,
			BookRepository bookRepository) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	}
	
	
	@GetMapping("")
	public String main() {
		return "main";
	}
	
	@GetMapping("/create-book")
	public String formCreateBook(Model model) {
		List<Author> authors = authorRepository.findAll();
		
		model.addAttribute("authors", authors);
		model.addAttribute("book", new Book());
		return "create";
	}
	
	@PostMapping("/create-book")
	public String createBook(@Valid @ModelAttribute("book") Book book, Errors errors) {
		if(errors.hasErrors()) {
			return "create";
		}
		bookRepository.save(book);
		return "redirect:/book-shop";
	}
	
}












