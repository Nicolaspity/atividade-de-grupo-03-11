package com.senai.infoa.llsolucoes.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    
    public Endereco buscarViaCep(String cep){
        RestTemplate template = new RestTemplate();
        Endereco endereco = template.getForObject("https://viacep.com/ws/{cep}/json", Endereco.class, cep);
        return endereco;
    }
    public void salvarEndereco(Integer usuario_id, String cep, Integer numero, String referencia){
        
        Usuario u = usuarioRepository.findById(usuario_id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(u);
        Endereco endereco = buscarViaCep(cep);
        endereco.setUsuario(usuarios);
        endereco.setNumero(numero);
        endereco.setReferencia(referencia);
        enderecoRepository.save(endereco);
    }
}
    