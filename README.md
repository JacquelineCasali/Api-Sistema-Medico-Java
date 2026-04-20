# 🏥 API de Clínica Médica (Spring Boot)

API REST desenvolvida para gerenciamento de médicos, pacientes e agendamentos, com foco em boas práticas de arquitetura, segurança e organização de código.

## Imagem do Projeto
![Video_apimedico](./Video_apimedico.gif)

## 🛠 Tecnologias utilizadas

- **[Java 17]**
- **[Spring Boot 3]**
- **[Spring Data JPA / Hibernate]**
- **[MySQL]**
- **[Flyway (versionamento de banco)]**
- **[Lombok]**
- **[Maven]**
- **[Swagger (OpenAPI)]**
- **[Postman]**


## ⚙️ Funcionalidades

- [x] CRUD completo de médicos;
- [x] CRUD completo de pacientes;
- [x] Agendamento de consultas;
- [x] Cancelamento de consultas.
- [x] Validação de regras de negócio
- [x] Controle de conflitos de agendamento

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


# 📁 Acessar a aplicação

##### Enquanto o servidor está ligado, acesse o navegador e entre no endereço abaixo
http://localhost:8080/swagger-ui/index.html


## 👨🏻‍💻 Autenticação

Utilize o endpoint:
POST /login
Exemplo:
{
  "email": "ana.souza@voll.med",
  "senha": "123456"
}
```
## 📌 Diferenciais do projeto
Implementação de regras de negócio reais
Estrutura preparada para evolução e escalabilidade
Separação clara de responsabilidades
Uso de versionamento de banco com Flyway
Documentação interativa com Swagger

## 👩‍💻 Autora

Jacqueline Casali
🔗 https://github.com/JacquelineCasali
🔗 https://casali.vercel.app
