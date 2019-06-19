package com.cotacao.api.DAL;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cotacao.api.model.Cotacao;

public interface CotacaoDAL extends JpaRepository<Cotacao, Integer>{
	Cotacao findById(int id);
	
	@Query(value="SELECT valor FROM preco_range where :cep BETWEEN cep_min AND cep_max AND :peso BETWEEN peso_min AND peso_max", nativeQuery=true)
	float addCotacao(@Param("cep") int cep, @Param("peso") int peso);
}
