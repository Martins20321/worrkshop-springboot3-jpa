# Spring Boot E-commerce REST API

## Visão Geral do Projeto

Este projeto é uma API RESTful completa desenvolvida com **Spring Boot** para simular um sistema de gerenciamento de pedidos e vendas (e-commerce).

**Este é o meu primeiro projeto prático utilizando o Spring Boot**, e estou muito feliz em compartilhar ele.

Os principais conceitos dominados incluem:
* **Modelagem de Domínio com JPA/Hibernate:** Implementação de um modelo de domínio complexo com associações One-to-One, One-to-Many e Many-to-Many (com atributos extras)
* **Estrutura de Camadas (Resource, Service, Repository):** Organização lógica do código em camadas Resource, Service e Repository
* **Implementação de funcionalidades CRUD (Create, Retrieve, Update, Delete):** Configuração e povoamento do banco de dados de teste H2 com Spring Data JPA/Hibernate
* **Tratamento de Exceções:** Implementação de um sistema de exceções personalizado para retornar códigos HTTP corretos

A arquitetura do projeto segue o padrão de três camadas:
* **Recursos (`resources`):** Controladores REST que expõem os endpoints da API.
* **Serviços (`services`):** Regras de negócio e lógica de transação.
* **Repositórios (`repositories`):** Acesso e manipulação de dados via Spring Data JPA.

## 📊 Modelo de Domínio (Entidades)

O modelo de dados segue a estrutura de um sistema de pedidos, com a entidade `OrderItem` fazendo a associação Many-to-Many entre `Order` e `Product`. 

* **Entidades Principais:** `User`, `Order`, `Product`, `Category`, `Payment`.
* **Associações:** One-to-One (`Order` para `Payment`), One-to-Many (`User` para `Order`), Many-to-Many com atributos extras (`Order` e `Product` via `OrderItem`).



<img width="1479" height="581" alt="image" src="https://github.com/user-attachments/assets/d7ed03ad-ba38-41aa-b646-8df99311903a" />


## 🛠️ Tecnologias Utilizadas

| Categoria | Tecnologia | Detalhe |
| :--- | :--- | :--- |
| **Framework** | Spring Boot | Desenvolvimento rápido de APIs REST. |
| **Linguagem** | Java | Linguagem base do projeto. |
| **Persistência** | Spring Data JPA / Hibernate | Mapeamento Objeto-Relacional. |
| **Banco de Dados** | H2 Database | Banco de dados **em memória** para teste e desenvolvimento local. |
| **Build Tool** | Apache Maven | Gerenciamento de dependências. |
| **Testes** | Postman | Utilizado para testar os endpoints da API. |

## ⚙️ Como Executar a API Localmente

O projeto está configurado para usar o perfil `test` e o banco de dados H2 para que o banco seja inicializado e populado automaticamente.

1.  **Pré-requisitos:** Certifique-se de ter o **JDK** e o **Maven** instalados.
2.  **Importar:** Clone o projeto e importe-o como um **Projeto Maven** no seu IDE (Ex: STS/Eclipse, IntelliJ).
3.  **Configuração do H2:** O console do H2 é habilitado para visualização.
    * **JDBC URL:** `jdbc:h2:mem:testdb` 
    * **Console:** `http://localhost:8080/h2-console` 
4.  **Executar:** Execute a classe principal `CourseApplication.java` como uma aplicação Spring Boot.
5.  **Acesso à API:** A API estará rodando em `http://localhost:8080`.

## 🛡️ Tratamento de Exceções

O projeto utiliza um `ResourceExceptionHandler` (via `@ControllerAdvice`) para interceptar exceções e retornar respostas HTTP padronizadas (JSON de erro), garantindo que a API não retorne erros internos 500 para falhas esperadas.

| Exceção de Serviço | Código HTTP | Descrição |
| :--- | :--- | :--- |
| `ResourceNotFoundException` | **404 Not Found** | Recurso não encontrado (ex: `GET /users/99`). |
| `DatabaseException` | **400 Bad Request** | Erro de integridade de dados (ex: tentar excluir um recurso com associações ativas). |

## 🔗 Endpoints Principais (Exemplos no Postman)

| Recurso | Método | URI | Ação | Status de Sucesso |
| :--- | :--- | :--- | :--- | :--- |
| **User** | `GET` | `/users` | Listar todos os usuários. | `200 OK` |
| **User** | `GET` | `/users/{id}` | Buscar usuário por ID. | `200 OK` / `404 Not Found` |
| **User** | `POST` | `/users` | Inserir um novo usuário. | `201 Created` |
| **User** | `PUT` | `/users/{id}` | Atualizar os dados de um usuário (Nome, Email, Telefone). | `200 OK` / `404 Not Found` |
| **User** | `DELETE` | `/users/{id}` | Remover um usuário (com tratamento 404). | `204 No Content` / `404 Not Found` |
| **Order** | `GET` | `/orders/{id}` | Buscar um pedido, incluindo items e produtos. | `200 OK` |
| **Product** | `GET` | `/products` | Listar todos os produtos. | `200 OK` |
| **Product** | `GET` | `/products/{id}` | Buscar produto por ID. | `200 OK` / `404 Not Found` |
| **Category** | `GET` | `/categories` | Listar todas as categorias. | `200 OK` |
| **Category** | `GET` | `/categories/{id}` | Buscar categoria por ID. | `200 OK` / `404 Not Found` |

---
*Projeto baseado no curso Java COMPLETO do Dr. Nélio Alves.*
*Desenvolvido por: (https://github.com/Martins20321)*
