package com.senai.infoa.llsolucoes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infoa.llsolucoes.models.Usuario;
import com.senai.infoa.llsolucoes.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;


    public Usuario cadastrarUsuario(Usuario u, String confSenha){
        
        if (u.getSenha().equals(confSenha)){
            return usuarioRepository.save(u);
        }
        return null;
    }

    public boolean loginUsuarioBoolean(String email, String senha){
        
        Usuario u = usuarioRepository.findUserByEmail(email);

        if (u.getSenha().equals(senha)){
            return true;
        } else {
            return false;
        }
    }
    public Usuario getEmailPorUsuario(String email){
        Usuario u = usuarioRepository.findUserByEmail(email);
        return u;
    }

    public void atualizarUsuario(Usuario u, Integer usuario_id){
        
        Usuario updatableUser = usuarioRepository.findById(usuario_id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        updatableUser.setNome(u.getNome());
        updatableUser.setEmail(u.getEmail());
        updatableUser.setSenha(u.getSenha());
        updatableUser.setContato(u.getContato());
        updatableUser.setDataNascimento(u.getDataNascimento());
        return usuarioRepository.save(updatableUser);

    }

}
