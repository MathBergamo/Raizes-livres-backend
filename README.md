# Raízes Livres - Projeto Integrador Generation Brasil

## Descrição do Projeto

Este é um projeto integrador desenvolvido como parte do programa Generation Brasil. O projeto Raízes Livres tem como objetivo criar uma aplicação para gerenciar categorias, produtos e usuários. A API oferece operações como criar, recuperar, atualizar e excluir para cada uma dessas entidades.

## Swagger

A documentação da API está disponível via Swagger. Para acessar, utilize o seguinte link:

- [Documentação Swagger](https://blogpessoal-83of.onrender.com/swagger-ui/index.html)

## Configuração do Swagger

A configuração do Swagger pode ser encontrada na classe `SwaggerConfig`. Ela define informações sobre a API, como título, descrição, versão e licença. Além disso, são fornecidos links para documentação externa e informações de contato.

## Endpoints

### Categoria

- **GET /categoria/{id}**: Recupera uma categoria pelo ID.
- **GET /categoria**: Recupera todas as categorias.
- **POST /categoria**: Cria uma nova categoria.
- **PUT /categoria**: Atualiza uma categoria existente.
- **DELETE /categoria/{id}**: Exclui uma categoria pelo ID.
- **GET /categoria/nome/{categoria}**: Recupera produtos por nome de categoria.

### Login

- **GET /login/all**: Recupera todos os usuários.
- **GET /login/{id}**: Recupera um usuário pelo ID.
- **POST /login**: Autentica um usuário.
- **POST /login/cadastrar**: Cadastra um novo usuário.
- **PUT /login/atualizar**: Atualiza um usuário existente.
- **DELETE /login/{id}**: Exclui um usuário pelo ID.

### Produto

- **GET /produto/{id}**: Recupera um produto pelo ID.
- **GET /produto**: Recupera todos os produtos.
- **POST /produto**: Cria um novo produto.
- **PUT /produto**: Atualiza um produto existente.
- **DELETE /produto/{id}**: Exclui um produto pelo ID.
- **GET /produto/nome/{produto}**: Recupera um produto por nome.

### Tratamento de Exceções

Há um tratamento global de exceções implementado na classe `GlobalExceptionHandler`. Ele trata exceções comuns, como erro interno do servidor, conflitos, recursos não encontrados e solicitações inválidas.

## Modelo de Dados

O projeto utiliza as seguintes entidades:

### Categoria

- **id**: Identificador único.
- **nome**: Nome da categoria.
- **ativo**: Indica se a categoria está ativa.

### Produto

- **id**: Identificador único.
- **nome**: Nome do produto.
- **preco**: Preço do produto.
- **descricao**: Descrição do produto.
- **foto**: URL da foto do produto.
- **categoria**: Categoria à qual o produto pertence.
- **usuario**: Usuário que cadastrou o produto.

### Usuario

- **id**: Identificador único.
- **nome**: Nome do usuário.
- **email**: Endereço de e-mail do usuário.
- **senha**: Senha do usuário (criptografada).
- **ativo**: Indica se o usuário está ativo.
- **foto**: URL da foto do usuário.
- **produto**: Lista de produtos cadastrados pelo usuário.

### Login

- **id**: Identificador único.
- **nome**: Nome do usuário.
- **usuario**: Nome de usuário (para autenticação).
- **senha**: Senha do usuário (não retornada nas consultas).
- **foto**: URL da foto do usuário.
- **token**: Token de autenticação.

## Executando o Projeto

- O aplicativo estará disponível em http://localhost:8080.

Observação: Certifique-se de ter o Docker instalado em seu sistema.
O projeto está configurado para ser construído e executado usando o Docker. Utilize o seguinte comando para construir e executar o contêiner:

```bash
docker build -t raizes-livres .
docker run -p 8080:8080 raizes-livres
```
## Contribuições
Este projeto foi desenvolvido como parte do programa Generation Brasil. Contribuições são bem-vindas e encorajadas. Sinta-se à vontade para criar pull requests ou abrir issues para melhorias e correções.
