package com.microservices.pedidos.api.service;

import com.microservices.pedidos.api.entity.Pedido;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final Logger logger = LoggerFactory.getLogger(PedidoService.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    private final RabbitTemplate rabbitTemplate;

    public Pedido enfileirarPedido(Pedido pedido){
        rabbitTemplate.convertAndSend(
                exchangeName,
                "", //não precisamos passar a routingKey porque estamos utilizando a exchange do tipo Fanout
                pedido);
        logger.info("Pedido enfileirado: {}", pedido);
        return pedido;
    }
}
