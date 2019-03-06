package com.marceloalves.cursomc.repositoreis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marceloalves.cursomc.domain.Categoria;

@Repository
public interface CategoriaRepositoy extends JpaRepository<Categoria, Integer> {
		
}
