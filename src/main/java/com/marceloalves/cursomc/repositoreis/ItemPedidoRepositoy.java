package com.marceloalves.cursomc.repositoreis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marceloalves.cursomc.domain.ItemPedido;

@Repository
public interface ItemPedidoRepositoy extends JpaRepository<ItemPedido, Integer> {
		
}
