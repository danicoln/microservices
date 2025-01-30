# Pedidos API

Esta é uma aplicação Spring Boot para gerenciamento de pedidos.

## Atualizações Recentes

### 1. Adição da Dependência SpringDoc
- Adicionada a dependência do SpringDoc OpenAPI para documentação automática da API.
- A dependência foi incluída no `pom.xml` com a versão `2.8.4`.

### 2. Resolução de Problema com Lombok
- Inicialmente, o Lombok estava causando problemas no projeto.
- A solução foi obtida ao adicionar a dependência do Lombok diretamente do site oficial, utilizando a versão mais atual (`1.18.36`).
- A dependência foi configurada com escopo `provided` e adicionada ao caminho do processador de anotações no `maven-compiler-plugin`.

### 3. Estrutura do Projeto
- O projeto foi configurado com as seguintes dependências principais:
    - `spring-boot-starter-amqp` para integração com RabbitMQ.
    - `spring-boot-starter-web` para desenvolvimento de aplicações web.
    - `spring-boot-devtools` para facilitar o desenvolvimento com reinicialização automática.
    - `spring-boot-starter-test` e `spring-rabbit-test` para testes.

### 4. Configurações do Maven
- O `maven-compiler-plugin` foi configurado para incluir o Lombok como um processador de anotações.
- O `spring-boot-maven-plugin` foi configurado para excluir o Lombok do empacotamento final.

## Próximos Passos
- Continuar o desenvolvimento da API de pedidos.
- Implementar testes unitários e de integração.
- Expandir a documentação da API utilizando o SpringDoc OpenAPI.
