package com.marceloalves.backend.repositoreis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marceloalves.backend.domain.ItemPedido;

@Repository
public interface ItemPedidoRepositoy extends JpaRepository<ItemPedido, Integer> {
		
}
