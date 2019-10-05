package br.com.workmade.service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import br.com.workmade.fetcher.BookDataFetcher;
import br.com.workmade.fetcher.BookDataFetcherByIsbn;
import br.com.workmade.fetcher.BooksDataFetcher;
import br.com.workmade.model.Autor;
import br.com.workmade.model.Book;
import br.com.workmade.repository.BookRepository;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service
public class GraphQLService {
	@Value("classpath:books.graphql")
	private Resource graphqlFile;
	
	private GraphQL graphQL;

	@Autowired
	private BooksDataFetcher allBooksDataFetcher;
	@Autowired
	private BookDataFetcher singleBookDataFetcher;
	@Autowired
	private BookDataFetcherByIsbn bookDataFetcherByIsbn;
	
	@Autowired
	private BookRepository repo;
	
	@PostConstruct
	private void loadSchema() throws IOException {
		//insert initial data
		//insertInitialData();
		
		File schemaFile = graphqlFile.getFile();
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
		RuntimeWiring wiring = buildRuntimeWiring();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
		graphQL = GraphQL.newGraphQL(schema).build();
	}
	

	private void insertInitialData() {
		List<Book> asList = Arrays.asList(			
				new Book(null,"123", "Livro da Lua", "Nossa editora", Arrays.asList(new Autor("Nosso Autor")), "13/12/1988"),
				new Book(null,"321", "Livro da Sol", "Sua editora", Arrays.asList(new Autor("Sua Autor")), "13/12/1988"),
				new Book(null,"675", "Livro da Ar", "Minha editora", Arrays.asList(new Autor("Minha Autor")), "13/12/1988"),
				new Book(null,"998", "Livro da Água", "Deles editora", Arrays.asList(new Autor("Deles Autor")), "13/12/1988"));
		
		this.repo.saveAll(asList);
		
	}

	private RuntimeWiring buildRuntimeWiring() {
		return RuntimeWiring.newRuntimeWiring()
				.type("Query", typeWiring ->  typeWiring
						.dataFetcher("livros", allBooksDataFetcher)
						.dataFetcher("livroPorId", singleBookDataFetcher)
						.dataFetcher("livroPorIsbn", bookDataFetcherByIsbn)
						).build();
	}

	public GraphQL getGraphQL() {
		return graphQL;
	}
	
	

}
