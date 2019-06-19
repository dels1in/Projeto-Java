package com.transportadora.api.DAL;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transportadora.api.model.ListStatus;

public interface ListStatusDAL extends JpaRepository<ListStatus, Integer>{
	ListStatus findById(int id);
}
