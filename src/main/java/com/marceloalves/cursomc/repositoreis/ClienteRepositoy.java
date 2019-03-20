package com.marceloalves.cursomc.repositoreis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marceloalves.cursomc.domain.Cliente;

@Repository
public interface ClienteRepositoy extends JpaRepository<Cliente, Integer> {
		
}
