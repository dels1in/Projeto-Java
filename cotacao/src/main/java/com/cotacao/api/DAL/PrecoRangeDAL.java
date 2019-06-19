package com.cotacao.api.DAL;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cotacao.api.model.PrecoRange;

public interface PrecoRangeDAL extends JpaRepository<PrecoRange, Integer>{
	PrecoRange findById(int id);
	
	@Query(value="SELECT * FROM preco_range where :cep BETWEEN cep_min AND cep_max",
			nativeQuery=true)
	List<PrecoRange> findByCepRange(@Param("cep") int cep);
}
