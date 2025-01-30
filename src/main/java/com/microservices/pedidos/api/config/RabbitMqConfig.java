package com.microservices.pedidos.api.config;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    /**Propriedade para pegar o nome da exchange*/
    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    /**Bean para criar a exchange que devolve uma Exchange do tipo Fanout*/
    @Bean
    public Exchange pedidosExchange() {
        return new FanoutExchange(exchangeName);
    }

    /**Bean do tipo RabbitADMIN que recebe uma connectionFactory e retorna o objeto*/
    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    /**Bean MessageConverter para converter o objeto em JSON*/
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    /**Bean responsável por enviar a mensagem*/
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory,
                                         MessageConverter messageConverter){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }

    /**Bean para ouvir a aplicação, para inicializar o rabbitAdmin*/
    @Bean
    public ApplicationListener<ApplicationReadyEvent> applicationReadyEventApplicationListener(
            RabbitAdmin rabbitAdmin){
        return event -> rabbitAdmin.initialize();
    }

}
