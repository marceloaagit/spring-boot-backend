package com.marceloalves.cursomc.repositoreis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marceloalves.cursomc.domain.Endereco;

@Repository
public interface EnderecoRepositoy extends JpaRepository<Endereco, Integer> {
		
}
