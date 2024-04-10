Livraria API
Descrição
Esta é uma API para gerenciar uma livraria, permitindo o gerenciamento de livros, revistas, compras e informações sobre a livraria em si.

Funcionalidades
Livros
Adicionar Livro: Adiciona um novo livro ao estoque da livraria.
Listar Livros: Retorna uma lista de todos os livros disponíveis na livraria.
Atualizar Livro: Atualiza as informações de um livro existente no estoque.
Excluir Livro: Remove um livro do estoque da livraria.
Revistas
Adicionar Revista: Adiciona uma nova revista ao estoque da livraria.
Listar Revistas: Retorna uma lista de todas as revistas disponíveis na livraria.
Atualizar Revista: Atualiza as informações de uma revista existente no estoque.
Excluir Revista: Remove uma revista do estoque da livraria.
Livraria
Informações da Livraria: Retorna informações sobre a livraria, como nome, endereço, telefone, etc.
Compras
Processar Compra: Permite aos clientes realizar compras na livraria, fornecendo detalhes como nome, sobrenome, forma de pagamento e item desejado. Os estudantes recebem um desconto de 50%.
Endpoints
Livros

POST /livros: Adiciona um novo livro ao estoque.
GET /livros: Lista todos os livros disponíveis.
GET /livros/{id}: Retorna as informações de um livro específico.
PUT /livros/{id}: Atualiza as informações de um livro existente.
DELETE /livros/{id}: Remove um livro do estoque.
Revistas

POST /revistas: Adiciona uma nova revista ao estoque.
GET /revistas: Lista todas as revistas disponíveis.
GET /revistas/{id}: Retorna as informações de uma revista específica.
PUT /revistas/{id}: Atualiza as informações de uma revista existente.
DELETE /revistas/{id}: Remove uma revista do estoque.

Livraria
Adicionar Livro: Adiciona uma nova livros ao sistema.
Listar Livro: Retorna uma lista de todas as livros cadastradas.
Detalhes da Livro: Retorna informações detalhadas sobre uma livros específica.
Atualizar Livro: Atualiza as informações de uma livros existente.
Excluir Livro: Remove uma livros do sistema.
Os endpoints correspondentes são:

POST /livraria: Adiciona uma nova livro.
GET /livraria: Lista todas as livro.
GET /livraria/{id}: Retorna detalhes de uma livr0 específica.
PUT /livraria/{id}: Atualiza informações de uma livro existente.
DELETE /livraria/{id}: Remove uma livro.
Compras

POST /compra: Processa uma compra na livraria.
Swagger
A documentação da API está disponível no Swagger UI. Você pode acessá-la através da rota http://localhost:8080/swagger-ui/index.html#. O Swagger fornece uma interface interativa para visualizar e testar os endpoints da API.