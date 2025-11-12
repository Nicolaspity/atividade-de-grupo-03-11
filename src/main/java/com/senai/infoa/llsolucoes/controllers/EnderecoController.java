package com.senai.infoa.llsolucoes.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.senai.infoa.llsolucoes.models.Endereco;
import com.senai.infoa.llsolucoes.services.EnderecoService;

@RestController
public class EnderecoController {
    
    @Autowired
    EnderecoService enderecoService;

    @PostMapping("salvar/endereco") 
    public String salvarEndereco(@RequestParam Integer usuario_id, @RequestParam String cep, @RequestParam Integer numero, @RequestParam String referencia){
        
        try
        {
            enderecoService.salvarEndereco(usuario_id, cep, numero, referencia);
            return "Endereço salvo com sucesso";
        } catch (Exception ex)
        {
            return ex.toString();
        }
    }

    @GetMapping("buscar/endereco")
    public Endereco buscarEndereco(Integer usuario_id){
        return enderecoService.getEnderecoPorUsuario(usuario_id);
    }

    @DeleteMapping("deletar/todos/enderecos")
    public String deletarTodosEnderecos(){
        enderecoService.deletarTodosEnderecos();
        return "Todos os endereços foram deletados";
    }
}
