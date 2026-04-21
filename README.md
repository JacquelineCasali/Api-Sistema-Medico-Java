```markdown
# 🏥 API de Clínica Médica (Spring Boot)

API REST para gerenciamento de médicos, pacientes e agendamentos, com foco em boas práticas de arquitetura, segurança e organização de código.

## 🎥 Demonstração da API
![Video_apimedico](./Video_apimedico.gif)

## 🛠 Tecnologias utilizadas

- Java 17
- Spring Boot 3
- Spring Data JPA / Hibernate
- MySQL
- Flyway
- Lombok
- Maven
- Swagger (OpenAPI)
- Postman


## ⚙️ Funcionalidades

- [x] CRUD completo de médicos
- [x] CRUD completo de pacientes
- [x] Agendamento de consultas
- [x] Cancelamento de consultas
- [x] Validação de regras de negócio
- [x] Controle de conflitos de agendamento
- [x] Implementação de autenticação segura com JWT

## 🔐 Segurança

- [x] Autenticação via JWT
- [x] Proteção de endpoints
- [x] Controle de acesso às funcionalidades

## 🧠 Arquitetura

- [x] Padrão MVC (Controller, Service, Repository)
- [x] Separação de responsabilidades por camada
- [x] Uso de DTOs para comunicação
- [x] Tratamento centralizado de exceções
- [x] Código estruturado seguindo boas práticas (Clean Code)

## 🗄 Banco de Dados

- [x] Modelagem relacional com MySQL
- [x] Controle de versão com Flyway
- [x] Relacionamentos entre entidades (médicos, pacientes, consultas)

## ▶️ Como executar o projeto

```bash
git clone https://github.com/JacquelineCasali/Api-Sistema-Medico-Java.git
cd Api-Sistema-Medico-Java
./mvnw spring-boot:run

```
## 📁 Acessar a aplicação

##### Acesse a documentação via Swagger:
http://localhost:8080/swagger-ui/index.html

## 👨🏻‍💻 Autenticação

Utilize o endpoint:

POST /login

Exemplo:
```json
{
  "email": "ana.souza@voll.med",
  "senha": "123456"
}
```
Após o login, copie o token retornado e utilize na opção Authorize do Swagger.

## 📌 Diferenciais do projeto
- [x] Implementação de regras de negócio reais
- [x] Estrutura preparada para evolução e escalabilidade
- [x] Separação clara de responsabilidades
- [x] Uso de versionamento de banco com Flyway
- [x] Documentação interativa com Swagger

## 👩‍💻 Autora

Jacqueline Casali
- 🔗 GitHub: https://github.com/JacquelineCasali  
- 🌐 Portfólio: https://casali.vercel.app
