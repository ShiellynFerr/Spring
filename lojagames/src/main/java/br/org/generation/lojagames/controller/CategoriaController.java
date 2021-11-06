package br.org.generation.lojagames.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.lojagames.model.Categoria;
import br.org.generation.lojagames.repository.CategoriaRepository;

@RestController //informando que essa classe se trata de um controller
@RequestMapping("/Categoria")
@CrossOrigin("*") //aceita requisições de qualquer origem
public class CategoriaController {

	@Autowired //injeção de depêndencia //Garantimos que todos os serviços dessa interface possam ser acessados apartir do controller
	private CategoriaRepository categoriaRepository;
	
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll(){
		
		return ResponseEntity.ok(categoriaRepository.findAll());
				
	}
	
	@GetMapping("/{id}") // determinar qual método http que vai ser enviado para a nossa API //("/{id}") indicando qual paramêtro vai ser
	//usado por quem fizer a requisição
	public ResponseEntity<Categoria> getById(@PathVariable long id){
		
		return categoriaRepository.findById(null)
				.map(res -> ResponseEntity.ok(res))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/categoria/{categoria}")
	public ResponseEntity<List<Categoria>> getByTipo(@PathVariable String tipo){
		
		return ResponseEntity.ok(categoriaRepository.findAllByCategoriaContainingIgnoreCase(tipo));	
	}
	
	@PostMapping
	public ResponseEntity<Categoria> postCategoria(@Valid @RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));

	}
	
	@PutMapping
	public ResponseEntity<Categoria> putCategoria(@Valid @RequestBody Categoria categoria){
		return categoriaRepository.findById(categoria.getId())
		.map(resposta -> {
			return ResponseEntity.ok().body(categoriaRepository.save(categoria));
		})
		.orElse(ResponseEntity.notFound().build());
		}
		
		@DeleteMapping("/{id}")
		public void deletePostagem (@PathVariable long id) {
			categoriaRepository.deleteById(id);
	}
	
	
	
}
