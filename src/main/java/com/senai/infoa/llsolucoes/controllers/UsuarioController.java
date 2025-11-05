package com.senai.infoa.llsolucoes.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.senai.infoa.llsolucoes.models.Usuario;
import com.senai.infoa.llsolucoes.services.UsuarioService;



import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;

    @PostMapping("cadastrar/usuario")
    public Usuario cadastrarUsuario(@RequestBody Usuario u, @RequestParam String confSenha) {
        return usuarioService.cadastrarUsuario(u, confSenha);
    }

    @PostMapping("login/usuario")
    public String loginUsuario(@RequestParam String email, @RequestParam String senha){
        if (usuarioService.loginUsuarioBoolean(email, senha)){
            return usuarioService.getEmailPorUsuario(email).toString();
        } else {
            return "Falha ao realizar login";
        }
    }
}

