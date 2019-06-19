package com.transportadora.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transportadora.api.DAL.ListStatusDAL;
import com.transportadora.api.model.ListStatus;

@RestController
@RequestMapping("/services")
public class ListStatusResource {
	
	@Autowired
	ListStatusDAL ListStatusRepository;
	
	@GetMapping("/status")//http://localhost:8000/services/status
	public List<ListStatus> listarStatus(){
		return ListStatusRepository.findAll();
	}
	
	@GetMapping("/status/{id}")//http://localhost:8000/services/status/ID
	public ListStatus listaStatusById(@PathVariable("id") int id) {
		return ListStatusRepository.findById(id);
	}
	
	@PostMapping("/status")//http://localhost:8000/services/status
	public ListStatus addListStatus(@RequestBody ListStatus ls) {
		return ListStatusRepository.save(ls);
	}
	
	@DeleteMapping("/status")//http://localhost:8000/services/status
	public void removeListStatus(@RequestBody ListStatus ls) {
		ListStatusRepository.delete(ls);
	}
	
	@PutMapping("/status")//http://localhost:8000/services/status
	public ListStatus changeListStatus(@RequestBody ListStatus ls) {
		return ListStatusRepository.save(ls);
	}
}
