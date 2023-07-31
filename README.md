# Desafio BTG
Desafio técnico para o programa de estágio em tecnologia do BTG Pactual.

Considerando que você precisa desenvolver um novo sistema de contas digitais. Para isso, inicialmente
você terá de modelar as entidades básicas que irão compor esse novo sistema. Você deverá modelar um
banco de dados relacional que armazene as seguintes informações:

- Dados do cliente
- Dados da conta
- Dados de movimentação (apenas depósitos e saques)


Demais artefatos:
- Diagrama Entidade Relacionamento
- Modelo Entidade Relacionamento
- Scripts DDL e DML
- API
  - Cadastro/atualização de conta/cliente
  - Cadastro de movimentações
  - Consulta por conta/cliente
  - Consulta por movimentações de uma conta

Especifique o banco de dados que está utilizando (MySQL, PostgreSQL, Oracle etc);
A entrega deverá ser um link para um repositório público no Github contendo os artefatos. Adicione um
README ao projeto.

**Configuração do Banco de dados:** Postgresql.

Adicionando dependência do Postgresql no arquivo pom.xml:

```
<dependency>
	<groupId>org.postgresql</groupId>
	<artifactId>postgresql</artifactId>
	<scope>runtime</scope>
</dependency>
```   
Configuração do application.properties:

```
spring.datasource.url= jdbc:postgresql://localhost:5432/Desafio_BTG
spring.datasource.username= postgres
spring.datasource.password= 1234

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation= true
spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.PostgreSQLDialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto= update
``` 

**Arquitetura:** Model-View-Controller (MVC).

**Framework:** Spring Boot.

**Exemplos de features:**

Cadastrando um cliente:

POST/ http://localhost:8080/cliente
```
{
    "cpf": "12345678999",
    "nomeCompleto": "Maria Souza",
    "telefone": "1199845734",
    "email": "maria.souza@gmail.com",
    "endereco": "Rua Amélia Barros, 322"
}
```
Cadastrando uma conta:

POST/ http://localhost:8080/conta
```
{
    "cliente": {
        "cpf": "12345678999"
    },
    "tipoConta": "corrente",
    "saldo": 1000.00
}
```
Consulta por movimentações através do ID da conta:

GET/ http://localhost:8080/conta/252/transacoes

(Nesse exemplo temos os saques e depósitos da conta 252)
```
[
{
"id": 54,
"valor": -95.00
},
{
"id": 55,
"valor": 100.00
},
{
"id": 102,
"valor": 100.00
}
]
```
# Scripts DDL e DML

**Comandos DDL**

Usados para modificar ou alterar a estrutura da base de dados:

CREATE, ALTER, DROP, TRUNCATE, RENAME.

   
Criar tabela
```
(   CREATE TABLE Cliente
    Cpf character varying (255) CONSTRAINT PK_Cpf PRIMARY KEY,    
    Nome_completo character varying (255),    
    Telefone character varying (255),    
    Email character varying (255),  
    Endereco character varying (255),   
) ; 
```
 


Alterar tabela - adicionar, deletar ou modificar colunas, adicionar ou excluir constraints
```
ALTER TABLE Cliente
DROP  Endereco character varying (255);
```
```
ALTER TABLE Cliente
ADD   Idade_cliente integer;
```

Renomear coluna
```
ALTER TABLE Cliente
RENAME COLUMN Cpf to Cpf_cliente;
``` 

Truncar base - remove TODAS as linhas do banco de dados e, dificilmente pode ser revertido
```
TRUNCATE TABLE Cliente;
```


**Comandos DML**

Usados para operações nas tabelas do banco de dados, como armazenar, alterar, recuperar
e deletar dados:

INSERT, SELECT, UPDATE, DELETE.


Inserir dados nas colunas da tabela
```
INSERT INTO Cliente (Cpf, Nome_completo, Telefone, Email, Endereco)
VALUES ('34597834533', 'Rafaela Denari', '11946573847', 'rafaela.denari@gmail.com, 'Rua Giramundo, 313') 
```

Aqui os valores serão preenchidos na ordem das colunas da tabela
```
INSERT INTO Cliente
VALUES ('34597834533', 'Rafaela Denari', '11946573847', 'rafaela.denari@gmail.com, 'Rua Giramundo, 313') 
```

Selecionar dados específicos da tabela
```
SELECT Cpf, Nome_completo, ...
FROM Cliente
```

Selecionar todos os dados da tabela
```
 SELECT * FROM Cliente;
```
Modificar/atualizar dados da tabela
```
UPDATE Cliente
SET Cpf = '77597834533'
WHERE Nome_completo = 'Rafaela Denari';
```

Deletar dados da tabela
```
DELETE FROM Cliente
WHERE Cpf = '77597834533';
```
Deletar TODOS os dados da tabela
```
DELETE FROM Cliente;
```



![Diagrama Entidade Relacionamento.png](..%2F..%2F..%2FUsers%2Fdebor%2FDownloads%2FDiagrama%20Entidade%20Relacionamento.png)


### Modelo Entidade Relacionamento

![Modelo Entidade Relacionamento vf.png](..%2F..%2F..%2FUsers%2Fdebor%2FDownloads%2FModelo%20Entidade%20Relacionamento%20vf.png)
