package com.senai.infoa.llsolucoes.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infoa.llsolucoes.models.Endereco;
import com.senai.infoa.llsolucoes.models.Usuario;
import com.senai.infoa.llsolucoes.repositories.EnderecoRepository;
import com.senai.infoa.llsolucoes.repositories.UsuarioRepository;

@Service
public class EnderecoService{

    @Autowired 
    EnderecoRepository enderecoRepository;
    UsuarioRepository usuarioRepository;

    public Endereco getEnderecoPorUsuario(Integer usuario_id){
        Endereco e;
        e = enderecoRepository.findAddressByUserId(usuario_id);
        return e;
    }

    public void salvarEndereco(Endereco endereco, Integer usuario_id){
        Usuario u = usuarioRepository.findById(usuario_id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(u);
        endereco.setUsuario(usuarios);
        enderecoRepository.save(endereco);
    }
}
    

