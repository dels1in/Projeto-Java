package com.cotacao.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cotacao.api.DAL.PrecoRangeDAL;
import com.cotacao.api.model.PrecoRange;

@RestController
@RequestMapping("/service")
public class PrecoRangeResource {
	
	@Autowired
	PrecoRangeDAL cepRangeRepository;
	
	@GetMapping("/range")//http://localhost:9000/service/range
	public List<PrecoRange> listarCep(){
		return cepRangeRepository.findAll();
	}
	
	@GetMapping("/range/{id}")//http://localhost:9000/service/range/ID
	public PrecoRange listaCepById(@PathVariable(value="id") int id) {
		return cepRangeRepository.findById(id);
	}
	
	@GetMapping("/rangecep/{cep}")//http://localhost:9000/service/rangecep/CEP
	public List<PrecoRange> listaCepRange(@PathVariable(value="cep") int cep){
		return cepRangeRepository.findByCepRange(cep);
	}
	
	@PostMapping("/range")//http://localhost:9000/service/range
	public PrecoRange addCep(@RequestBody PrecoRange cep) {
		return cepRangeRepository.save(cep);
	}
}

