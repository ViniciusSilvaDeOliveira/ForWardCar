#language: pt
Funcionalidade: Casos de Teste escolhidos que envolvem o login
#  Contexto:
#    * acessar a url "http://localhost:3434/cars-app/#/home"

  @%CT001
  Cenario: Realizar cadastro de Login
    Dado que acesso a url "http://localhost:3434/cars-app/#/home"
    Quando clico em Guest
    E seleciono register
    E prencho as informações de cadastro confirmando o registro
    Entao sou redirecionado para a tela de login
