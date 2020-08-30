package com.example.money.api.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.money.api.model.Pessoa;
import com.example.money.api.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {
	
	@Autowired
	private PessoaRepository PessoaRepository;
	
	@GetMapping
	public List<Pessoa> listar(){
		return PessoaRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> criar(@Valid @RequestBody Pessoa Pessoa, HttpServletResponse response) {
		
	Pessoa PessoaSalva = PessoaRepository.save(Pessoa);
	URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")/*URI from java.net*/
	.buildAndExpand(PessoaSalva.getCodigo()).toUri();
	response.setHeader("Location", uri.toASCIIString());
	
	return ResponseEntity.created(uri).body(PessoaSalva);
		
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Long> buscarPeloCodigo(@PathVariable Long codigo) {
		if (!PessoaRepository.findById(codigo).isEmpty())
			return ResponseEntity.ok(codigo);
		else
			return ResponseEntity.notFound().build();
	} 

}
