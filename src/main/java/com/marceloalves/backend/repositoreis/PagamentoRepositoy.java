package com.marceloalves.backend.repositoreis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marceloalves.backend.domain.Pagamento;

@Repository
public interface PagamentoRepositoy extends JpaRepository<Pagamento, Integer> {
		
}
