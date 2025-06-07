# Moeda API

## Descrição

A Moeda API é uma aplicação Spring Boot que fornece uma lista de países e suas respectivas moedas, incluindo informações como código, nome, país, código do país e a bandeira em formato base64. Ideal para projetos de frontend, estudos de consumo de API ou qualquer sistema que exija dados monetários do mundo todo.

## Funcionalidades

- Listar todas as moedas disponíveis.
- Buscar moeda por código.
- Obter a bandeira do país da moeda em formato de imagem PNG.

## Endpoints

- `GET /moedas`  
  Retorna uma lista com todas as moedas.

- `GET /moedas/{code}`  
  Retorna os detalhes de uma moeda específica pelo código.

- `GET /moedas/{code}/flag`  
  Retorna a bandeira do país da moeda em formato PNG.

## Como executar

1. **Pré-requisitos:**  
   - Java 17+  
   - Maven

2. **Clone o repositório:**
   ```sh
   git clone https://github.com/vitorh07/moedas-api.git
   cd moedas-api

3. **Instale as dependências e execute o projeto:**
    ```sh
    ./mvnw spring-boot:run
    ```
4. **Acesse a API:**
    - O serviço estará disponível em:
    http://localhost:8080/moedas

## Estrutura do Projeto
    src/
    main/
        java/
        com/prjvitor/moedas_api/
            controllers/
            models/
            repositories/
            services/
        resources/
        application.properties
        moedas.json
