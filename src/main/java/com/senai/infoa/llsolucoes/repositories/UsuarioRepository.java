package com.senai.infoa.llsolucoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.senai.infoa.llsolucoes.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    @Query(value = "SELECT * FROM usuario WHERE email = :email", nativeQuery = true)
    public Usuario findUserByEmail(@Param("email") String email);

}
