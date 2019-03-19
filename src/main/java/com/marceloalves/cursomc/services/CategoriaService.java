package com.marceloalves.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marceloalves.cursomc.domain.Categoria;
import com.marceloalves.cursomc.repositoreis.CategoriaRepositoy;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepositoy repo;

	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
