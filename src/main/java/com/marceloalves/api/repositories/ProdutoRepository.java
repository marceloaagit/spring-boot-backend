package com.marceloalves.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marceloalves.api.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
