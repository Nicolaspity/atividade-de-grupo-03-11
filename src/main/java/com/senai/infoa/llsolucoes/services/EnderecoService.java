package com.senai.infoa.llsolucoes.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        HttpHeaders headers = new HttpHeaders();
        // pedir explicitamente JSON ao ViaCEP
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Void> entity = new HttpEntity<>(headers);
        try {
            ResponseEntity<String> resp = template.exchange(
                "https://viacep.com.br/ws/{cep}/json/",
                HttpMethod.GET,
                entity,
                String.class,
                cep
            );
            String body = resp.getBody();
            if (body == null || body.isBlank()) {
                throw new RuntimeException("Resposta vazia do ViaCEP");
            }
            // desserializa manualmente para Endereco (mais tolerante ao content-type)
            ObjectMapper mapper = new ObjectMapper();
            try {
                return mapper.readValue(body, Endereco.class);
            } catch (JsonProcessingException je) {
                throw new RuntimeException("Falha ao parsear JSON do ViaCEP: " + je.getMessage());
            }
        } catch (RestClientException ex) {
            throw new RuntimeException("Erro ao consultar o ViaCEP: " + ex.getMessage(), ex);
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
