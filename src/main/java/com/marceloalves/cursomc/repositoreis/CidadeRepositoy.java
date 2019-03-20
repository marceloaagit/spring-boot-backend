package com.marceloalves.cursomc.repositoreis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marceloalves.cursomc.domain.Cidade;

@Repository
public interface CidadeRepositoy extends JpaRepository<Cidade, Integer> {
		
}
