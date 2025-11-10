package com.senai.infoa.llsolucoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.senai.infoa.llsolucoes.models.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

    @Query(value="SELECT * FROM endereco e WHERE e.usuario_id = :usuario_id ", nativeQuery = true)
    public Endereco findAddressByUserId(@Param("usuario_id") Integer usuario_id);
}