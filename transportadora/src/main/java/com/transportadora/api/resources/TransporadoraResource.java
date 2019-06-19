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

import com.transportadora.api.DAL.TransportadoraDAL;
import com.transportadora.api.model.Transportadora;

@RestController
@RequestMapping("/services")
public class TransporadoraResource {
	
	@Autowired
	TransportadoraDAL transpotadoraDal;
	
	@GetMapping("/transportadora")//http://localhost:8000/services/transportadora
	public List<Transportadora> listarTransporadora(){
		return transpotadoraDal.findAll();
	}
	
	@GetMapping("/transportadora/{id}")//http://localhost:8000/services/transportadora/ID
	public Transportadora listarTransportadoraById(@PathVariable("id") int id) {
		return transpotadoraDal.findById(id);
	}
	
	@PostMapping("/transportadora")//http://localhost:8000/services/transportadora
	public Transportadora addTransportadora(@RequestBody Transportadora transportadora) throws Exception {
		return transpotadoraDal.save(transportadora);
	}	
	
	@DeleteMapping("/transportadora")//http://localhost:8000/services/transportadora
	public void removeTransportadora(@RequestBody Transportadora transportadora) {
		transpotadoraDal.delete(transportadora);
	}
	
	@PutMapping("/transportadora")//http://localhost:8000/services/transportadora
	public Transportadora changeTransportadora(@RequestBody Transportadora transportadora) {
		return transpotadoraDal.save(transportadora);
	}
}
