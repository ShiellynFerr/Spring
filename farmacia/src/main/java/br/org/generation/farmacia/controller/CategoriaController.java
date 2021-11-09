package br.org.generation.farmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.farmacia.model.Categoria;
import br.org.generation.farmacia.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
@CrossOrigin ( origins  =  " * " , allowedHeaders  =  " * " )
public class CategoriaController {

	@Autowired //Injeção de depêndencia
	private  CategoriaRepository categoriaRepository; 
	
	@GetMapping
	public ResponseEntity <List<Categoria>> getAll(){
		return ResponseEntity.ok(categoriaRepository.findAll());	
	}
	
		@GetMapping("{id}")
		public ResponseEntity<Categoria> GetById(@PathVariable long id){
			return categoriaRepository.findById(id).map(res ->ResponseEntity.ok(res))
					.orElse(ResponseEntity.notFound().build());
		}
		
	
		
		@GetMapping("/categoria/{categoria}")
		public ResponseEntity<List<Categoria>> getByCategoria(@PathVariable String categoria){
			return ResponseEntity.ok(categoriaRepository.findAllByCategoriaContainingIgnoreCase(categoria));
		}
		
	}

