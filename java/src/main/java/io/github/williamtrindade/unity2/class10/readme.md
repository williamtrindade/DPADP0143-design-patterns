## Padrões comportamentais
> São voltados aos algoritmos e a designação de responsabilidades entre objetos.
___

### Command
> O Command é um padrão de projeto comportamental que transforma
um pedido em um objeto independente que contém toda a informação 
sobre o pedido.  
> Essa transformação permite que você parametrize métodos com 
diferentes pedidos, atrase ou coloque a execução do pedido em uma
fila, e suporte operações que não podem ser feitas.

https://refactoring.guru/pt-br/design-patterns/command

![](https://refactoring.guru/images/patterns/diagrams/command/structure.png)

#### Personagens do padrão
- ##### Command
    Define uma interface para a execução dos métodos do Receiver.
- ##### ConcreteCommand
    Classe que implementa Command e modela uma operação específica
    do Receiver
- ##### Invoker
    Classe que armazena os Commands que devem ser executados.
- ##### Receiver
    Define os objetos que terão as chamadas aos seus métodos
    controladas
- ##### Client
    Instancia os Commands associando-os ao Receiver e armazena-os no
    Invoker
___

### Chain of Responsability (CoR)
> O Chain of Responsibility é um padrão de projeto comportamental
que permite que você passe pedidos por uma corrente de handlers.  
> Ao receber um pedido, cada handler decide se processa o pedido ou
o passa adiante para o próximo handler na corrente.

https://refactoring.guru/pt-br/design-patterns/chain-of-responsibility

![](https://refactoring.guru/images/patterns/diagrams/chain-of-responsibility/structure.png)
___

### Mediator
> O Mediator é um padrão de projeto comportamental que permite 
que você reduza as dependências caóticas entre objetos.  
> O padrão restringe comunicações diretas entre objetos e os 
força a colaborar apenas através do objeto mediador.

https://refactoring.guru/pt-br/design-patterns/mediator

![](https://refactoring.guru/images/patterns/diagrams/mediator/structure.png)

#### Mediator vs Facade
- ##### Semelhanças
    - Façade é usado para abstrair a complexidade de um
      subsistema completo de componentes.  
    - Quando um objeto deseja utilizar um serviço daquele
      subsistema, poderá fazê-lo invocando apenas o objeto
      Façade.
- ##### Diferenças
    - Objetos de dentro do subsistema não conhecem o Façade e
      nunca utilizam o seu serviço.
    - Comunicação é sempre unidirecional (cliente-facade ->
      subsistema).
___

### Observer
> O Observer permite que você defina um mecanismo de assinatura para notificar múltiplos
objetos sobre quaisquer eventos que aconteçam com o objeto que eles estão observando.

https://refactoring.guru/pt-br/design-patterns/observer

![](https://refactoring.guru/images/patterns/diagrams/observer/structure.png)

#### Observer vs Mediator
- O Mediator concentra todas as interações entre os objetos.  
  Não existe o ato de um objeto de subscrever no mediador.

- O padrão Observer geralmente é mais elegante e gera
  menor acoplamento do que o Mediator, porém.  
  No Observer cada objeto Subscriber precisa tratar os eventos
  aos quais se subscreveu.