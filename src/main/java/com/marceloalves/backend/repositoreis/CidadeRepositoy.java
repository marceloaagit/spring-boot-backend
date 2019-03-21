package com.marceloalves.backend.repositoreis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marceloalves.backend.domain.Cidade;

@Repository
public interface CidadeRepositoy extends JpaRepository<Cidade, Integer> {
		
}
