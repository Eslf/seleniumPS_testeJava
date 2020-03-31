Feature: Preciso selecionar um item e adiciona-lo ao carrinho

Scenario: Selecionar item e colocar no carrinho de compras

Given Acessada a pagina da loja
Given E acessado os detalhes do item
When Ao clicar no botao de adicionar ao carrinho
When E clicar no botao para o resumo da compra  
Then O site abre a pagina do carrinho de compras
