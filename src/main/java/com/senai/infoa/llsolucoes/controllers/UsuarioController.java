package com.senai.infoa.llsolucoes.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.senai.infoa.llsolucoes.models.Usuario;
import com.senai.infoa.llsolucoes.services.UsuarioService;



import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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

    @PutMapping("atualizar/usuario")
    public String atualizarUsuario(@RequestBody Usuario u, @RequestParam Integer usuario_id) {
        
        Usuario update = usuarioService.atualizarUsuario(u, usuario_id);
        if (update != null)
        {
            return "Usuário salvo com sucesso";
        } else {
            return "Falha ao atualizar usuário";
        }
    }

    //TODO: Adicionar método de buscar usuário (feito)

    @GetMapping("buscar/usuario/{id}")
    public ResponseEntity<?> buscarUsuario(@PathVariable("id") Integer usuario_id){
        Usuario u = usuarioService.buscarUsuario(usuario_id);

        if (u != null){
            return ResponseEntity.ok(u);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Esse usuário não existe");
        }
    }
}

