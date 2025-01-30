package com.microservices.pedidos.api.controller;

import com.microservices.pedidos.api.entity.Pedido;
import com.microservices.pedidos.api.entity.enums.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    private final Logger logger = LoggerFactory.getLogger(PedidoController.class);

    @PostMapping
    public ResponseEntity<Pedido> criar(@RequestBody Pedido obj) {
        Pedido pedido = new Pedido();

        pedido.setCliente(obj.getCliente());
        pedido.setItens(obj.getItens());
        pedido.setEmailNotificacao(obj.getEmailNotificacao());
        pedido.setValorTotal(obj.getValorTotal());

        pedido.setId(UUID.randomUUID());
        pedido.setDataHora(LocalDateTime.now());
        pedido.setStatus(Status.EM_PROCESSAMENTO);
        logger.info("Pedido recebido: {}", pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }
}
