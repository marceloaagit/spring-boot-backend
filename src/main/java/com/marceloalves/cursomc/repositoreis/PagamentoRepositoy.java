package com.marceloalves.cursomc.repositoreis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marceloalves.cursomc.domain.Pagamento;

@Repository
public interface PagamentoRepositoy extends JpaRepository<Pagamento, Integer> {
		
}
