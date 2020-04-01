Feature: Preciso validar o valor total da compra, selecionar o metodo de pagamento, confirmar e finalizar o valor total da compra

Scenario: Validar total de compra, escolher metodo de pagamento e finalizar compra
  Given Dado que o total da compra seja validado 
  And e selecionado o metodo de pagamento
  When Ao confirmar a compra
  Then Validar se a compra foi finalizada com sucesso