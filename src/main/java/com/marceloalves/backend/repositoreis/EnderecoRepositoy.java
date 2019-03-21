package com.marceloalves.backend.repositoreis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marceloalves.backend.domain.Endereco;

@Repository
public interface EnderecoRepositoy extends JpaRepository<Endereco, Integer> {
		
}
