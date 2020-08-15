### Exercise 5:
1. Implementar o padrão Observer no problema das contas bancárias do módulo anterior.
    - Cada conta será observável.
    - E sempre que o saldo for negativo o Observer inclui o cliente na lista do Serasa.
2. Implementar o padrão Command para um controle de videogame que possui os seguintes
   botões.  
    2.1. A e B  
    2.2. Direcional: cima, baixo, esquerda, direita    
    - Os receivers são os diferentes jogos que podem ser utilizados com o videogame e na 
    saída padrão quando apertado cada botão, um resultado diferente será apresentado dependendo 
    do jogo.
3. Implementar o padrão Command para um DAO com métodos simples como: remover,
   atualizar, inserir e selecionar
    - Cada um destes métodos do DAO gera um comando SQL que precisa ser processado pelo SGBD.
    - Implementar o padrão Command para abstrair os comandos SQL, considerando a conexão JDBC
      como sendo o receiver.
    - Implementar um invoker de comandos SQL, que permite a execução em lote.
    - Os métodos do DAO devem ser assíncronos, sendo que os retornos são implementados em
      Callbacks.