package br.com.workmade.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.workmade.model.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, String>{

	Book findByIsbn(String isbn);
	
}