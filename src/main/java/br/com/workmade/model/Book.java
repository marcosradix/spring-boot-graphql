package br.com.workmade.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="Book")
public class Book {
	
	@Id
	private String id;
	private String isbn;
	private String titulo;
	private String editora;
	private List<Autor> autores = new ArrayList<>();
	private String dataDePublicacao;
	
	
	
	public Book(String isbn, String titulo, String editora, List<Autor> autores, String dataDePublicacao) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.editora = editora;
		this.autores = autores;
		this.dataDePublicacao = dataDePublicacao;
	}
	
	
	
	public Book(String id, String isbn, String titulo, String editora, List<Autor> autores, String dataDePublicacao) {
		this.id = id;
		this.isbn = isbn;
		this.titulo = titulo;
		this.editora = editora;
		this.autores = autores;
		this.dataDePublicacao = dataDePublicacao;
	}



	public Book() {}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public List<Autor> getAutores() {
		return autores;
	}
	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	public String getDataDePublicacao() {
		return dataDePublicacao;
	}
	public void setDataDePublicacao(String dataDePublicacao) {
		this.dataDePublicacao = dataDePublicacao;
	}
	
	
	

}
