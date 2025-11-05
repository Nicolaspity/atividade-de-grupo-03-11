package com.senai.infoa.llsolucoes.configs;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "L&L Soluções",
        version = "1.0",
        description = "Loja de roupas tecnológica. Contato: @mathias.souza@aluno.senai.br"
                
    )
)
public class Swagger {

}