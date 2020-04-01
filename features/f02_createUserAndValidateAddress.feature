Feature: Preciso cadastrar uma nova conta de usuario e validar se endereco preenchido no cadastro e o mesmo do de entrega

Scenario: Cadastro de uma nova conta de usuario e validacao de endereco
  Given Dado seja inserido o e-mail e clicado no botao Nova Conta 
  And e seja preenchido os campos obrigatorios do cadastro
  When Ao clicar no botao Registrar
  Then Sera validado a seguir o endereco de entrega e 
  And aceito os Termos de Servico