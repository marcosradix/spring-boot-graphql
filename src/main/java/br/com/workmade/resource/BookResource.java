package br.com.workmade.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.workmade.service.GraphQLService;
import graphql.ExecutionResult;

@RequestMapping(value = "/rest/books")
@RestController
public class BookResource {
	
	@Autowired
	private GraphQLService graphQLService;
	
	@PostMapping
	public ResponseEntity<?> getAllBooks(@RequestBody String data) {
		ExecutionResult result = this.graphQLService.getGraphQL().execute(data);
		return ResponseEntity.ok(result);
	}

}
