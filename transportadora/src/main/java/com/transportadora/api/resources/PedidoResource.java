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

import com.transportadora.api.DAL.PedidoDAL;
import com.transportadora.api.model.Pedido;

@RestController
@RequestMapping(value="/services")
public class PedidoResource {
	
	@Autowired
	PedidoDAL pedidoRepository;
	
	@GetMapping("/pedido")//http://localhost:8000/services/pedido
	public List<Pedido> listaPedidos(){
		return pedidoRepository.findAll();
	}
	
	@GetMapping("/pedido/{id}")//http://localhost:8000/services/pedido/ID
	public List<Pedido> listarPedido(@PathVariable(value="id") int id) {
		return pedidoRepository.findById(id);
	}
	
	@GetMapping("/pedidostatus")//http://localhost:8000/services/pedidostatus
	public List<Pedido> findLastPedidos(){
		return pedidoRepository.findLastStatus();
	}
	
	@GetMapping("/pedidostatus/{id}")//http://localhost:8000/services/pedidostatus/ID
	public List<Pedido> findPedidoByStatus(@PathVariable(value="id") int id){
		return pedidoRepository.findPedidoByStatus(id);
	}
	
	@PostMapping("/pedido")//http://localhost:8000/services/pedido
    public Pedido addPedido(@RequestBody Pedido pedido) throws Exception {
        if(pedidoRepository.cotacaoExistente(pedido.getCotacaoId()) == 1) {
            return pedidoRepository.save(pedido);
        }else {
            throw new Exception();
        }
    }
	
	@DeleteMapping("/pedido")//http://localhost:8000/services/pedido
	public void removePedido(@RequestBody Pedido pedido) {
		pedidoRepository.delete(pedido);
	}
	
	@PutMapping("/pedido")//http://localhost:8000/services/pedido
	public Pedido changePedido(@RequestBody Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
}
