## Desafio Prático | DB Server

#### Orientações
Projeto realizado com Gradle, Spring Boot, com banco H2 para persistência em memória, Java 8. Para desenvolvimento utilizei o IntelliJ como IDE em ambiente Linux Ubuntu (19.04).

Para acesso ao console do H2: http://localhost:8080/h2-console/

`base: testdb`

`usuário: sa`

`password: password`

#### Execução do Projeto
Para fins de teste, é realizada uma carga inicial de contas. As mesmas podem ser editadas na classe DataInitializr.java (pacote config).

Endpoint para teste: http://localhost:8080/servicos/transferencia

`Corpo do JSON (POST)`

`{
	"contaOrigem" : 300,
	"contaDestino" : 400,
	"valor" : 254.98
}`


Para testar o endpoint foi utilizado o Postman. A coleção contendo o método pode ser importado de: https://www.getpostman.com/collections/898719943f230e8b75d3

#### Validações
Para o método em questão foram validadas as seguintes situações:
- Conta Origem válida (existente no banco);
- Conta Destino válida;
- Conta Origem com saldo suficiente para a transferência;

#### Testes
Utilização do MockMVC para teste do RestController com cobertura de código em aproximadamente 85% (segundo o Code Coverage do IntelliJ).

#### Melhorias
Como melhorias futuras, posso citar:
- Validação de CPF para transferências;
- Token / Autenticação para a realização da transferência;
- Novos Endpoints para:
    - Listagem de Transações por CPF;
    - Listagem / Consulta de Contas;
    - Possibilidade de depósito para atualização de Saldo;
