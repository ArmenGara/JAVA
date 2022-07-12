package com.armen.BookClub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.armen.BookClub.models.Book;
import com.armen.BookClub.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	BookRepository qRepo;
	
	// CREATE
	public Book create(Book newBook) {
		return qRepo.save(newBook);
	}
	
	// READ ALL
	public List<Book> getAllBooks(){
		return qRepo.findAll();
	}
	// READ ONE
	public Book getOneBook(Long id) {
		return qRepo.findById(id).orElse( null);
	}
	
	// UPDATE
	
	// DELETE
	public void deleteBook(Long id) {
		qRepo.deleteById(id);
	}
}