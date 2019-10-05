package br.com.workmade.fetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.workmade.model.Book;
import br.com.workmade.repository.BookRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class BooksDataFetcher implements DataFetcher<List<Book>>{

	@Autowired
	private BookRepository repository;
	
	@Override
	public List<Book> get(DataFetchingEnvironment environment) {
		return this.repository.findAll();
	}

}
