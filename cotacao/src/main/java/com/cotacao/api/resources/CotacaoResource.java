package com.cotacao.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cotacao.api.DAL.CotacaoDAL;
import com.cotacao.api.model.Cotacao;

@RestController
@RequestMapping("/service")
public class CotacaoResource {
		
	@Autowired
	CotacaoDAL cotacaoRepository;
	
	@GetMapping("/cotacao")//http://localhost:9000/service/range
	public List<Cotacao> listarCotacao(){
		return cotacaoRepository.findAll();
	}
	
	@GetMapping("/cotacao/{id}")
	public Cotacao listaCotacaoById(@PathVariable("id") int id) {
		return cotacaoRepository.findById(id);
	}
	
	@PostMapping("/cotacao")
	public Cotacao addCotacao(@RequestBody Cotacao cotacao) {
		cotacao.setValor(cotacaoRepository.addCotacao(cotacao.getCep(), cotacao.getPeso()));
			
		return cotacaoRepository.save(cotacao);
	}
}
