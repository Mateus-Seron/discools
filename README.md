# Discools

Loja de discos feita com Spring Boot. O catálogo fica no MySQL.

## Branches

- `main`: código original, antes da manutenção de código limpo.
- `manutencao`: as mesmas telas, com as seis premissas do Capítulo 2 aplicadas em `PovoaBanco.java` e `carrinho.js`. O relatório dessa comparação está nessa branch, no arquivo `relatorio-codigo-limpo.md`.

Para trocar de versão:

```powershell
git checkout main
git checkout manutencao
```

## Como executar

É preciso ter, antes do comando:

- Java 17
- Maven (`mvn` no terminal)
- MySQL ligado em `localhost:3306`, com o banco `discools` já criado

O usuário e a senha estão em `src/main/resources/application.properties`. Neste projeto o usuário é `root`. Se o MySQL dessa máquina tiver senha, troque `spring.datasource.password`.

Na pasta do projeto:

```powershell
mvn spring-boot:run
```

Abra http://localhost:5000.

Na primeira vez o Maven baixa as bibliotecas da internet. Com o banco vazio, a aplicação cria as tabelas e grava o catálogo. Sem o MySQL ligado, ou sem o banco `discools`, a aplicação não sobe.
