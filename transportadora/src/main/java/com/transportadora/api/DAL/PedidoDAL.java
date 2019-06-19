package com.transportadora.api.DAL;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.transportadora.api.model.Pedido;


public interface PedidoDAL extends JpaRepository<Pedido, Integer>{
	/* Interface que será usada para fazer Persistencia no banco */
	@Query(value="SELECT * FROM pedido WHERE pedido_id = :id",
			 nativeQuery=true)
	List<Pedido> findById(@Param("id") int id);
	
	
	@Query(value="SELECT p.* FROM pedido p\r\n" + 
			"INNER JOIN (SELECT pedido_id, MAX(item_id) AS item_id FROM pedido GROUP BY pedido_id) groupedp\r\n" + 
			"ON p.pedido_id = groupedp.pedido_id\r\n" + 
			"AND p.item_id = groupedp.item_id ORDER BY pedido_id",
			nativeQuery=true)
	List<Pedido> findLastStatus();
	
	
	@Query(value="SELECT * FROM pedido WHERE pedido_id = :id AND item_id = (SELECT MAX(item_id) from pedido where pedido_id = :id) ORDER BY pedido_id;",
			nativeQuery=true)
	List<Pedido> findPedidoByStatus(@Param("id") int id);

	@Query(value="SELECT EXISTS(SELECT cotacao_id FROM cotacao WHERE cotacao_id = :id);", 
			nativeQuery=true)
    int cotacaoExistente(@Param("id") int id);
}
