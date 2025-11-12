package com.senai.infoa.llsolucoes.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.senai.infoa.llsolucoes.models.Endereco;
import com.senai.infoa.llsolucoes.models.Usuario;
import com.senai.infoa.llsolucoes.repositories.EnderecoRepository;
import com.senai.infoa.llsolucoes.repositories.UsuarioRepository;

@Service
public class EnderecoService{

    @Autowired 
    EnderecoRepository enderecoRepository;
    
    @Autowired
    UsuarioRepository usuarioRepository;

    public Endereco getEnderecoPorUsuario(Integer usuario_id){
        Usuario u = usuarioRepository.findById(usuario_id)
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        
        return u.getEndereco(); 
    }
    
    public Endereco buscarViaCep(String cep) {
        RestTemplate template = new RestTemplate();
        try {
            return template.getForObject("https://viacep.com.br/ws/{cep}/json/", Endereco.class, cep);
        } catch (RestClientException ex) {
            throw new RuntimeException("Erro ao consultar o ViaCEP: " + ex.getMessage());
        }
    }

    public Endereco salvarEndereco(String cep, Integer numero, String referencia) {
        Endereco e = buscarViaCep(cep);
        e.setNumero(numero);
        e.setReferencia(referencia); 
        return enderecoRepository.save(e);
    }

    public void deletarTodosEnderecos(){
        enderecoRepository.deleteAll();
    }
}
    