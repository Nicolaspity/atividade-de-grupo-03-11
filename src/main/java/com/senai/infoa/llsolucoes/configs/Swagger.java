package com.senai.infoa.llsolucoes.configs;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "L&L Soluções",
        version = "1.0",
        description = "Loja de roupas tecnológica. Integrantes do grupo: Mathias, Nicolas, Guilherme Moraes e João Victor"
                
    )
)
public class Swagger {

}
