package com.microservices.pedidos.api.entity;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Produto {

    private UUID id = UUID.randomUUID();
    private String nome;
    private Double valor;
}
