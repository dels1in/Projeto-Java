package com.transportadora.api.DAL;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transportadora.api.model.Transportadora;

public interface TransportadoraDAL extends JpaRepository<Transportadora, Integer>{
	Transportadora findById(int id);
}
