package com.microservices.pedidos.api.entity;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemPedido {

    private UUID id;
    private Produto produto;
    private Integer quantidade;
}
