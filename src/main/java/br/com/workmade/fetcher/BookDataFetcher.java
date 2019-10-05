package br.com.workmade.fetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.workmade.model.Book;
import br.com.workmade.repository.BookRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class BookDataFetcher implements DataFetcher<Book>{

	@Autowired
	private BookRepository repository;
	
	@Override
	public Book get(DataFetchingEnvironment environment) {
		String id = environment.getArgument("id");
		return this.repository.findById(id).orElseThrow(() -> new RuntimeException("Dado não encontrado"));
	}

}
