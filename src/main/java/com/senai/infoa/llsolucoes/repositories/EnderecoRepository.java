package com.senai.infoa.llsolucoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.senai.infoa.llsolucoes.models.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

}