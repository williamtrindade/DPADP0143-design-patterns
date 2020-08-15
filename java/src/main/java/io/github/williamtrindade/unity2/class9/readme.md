## Padrões estruturais
> Tratam da estrutura da relação entre os objetos.
___

### Facade
> O Facade é um padrão de projeto estrutural que fornece uma interface 
simplificada para uma biblioteca, um framework, ou qualquer conjunto 
complexo de classes.
> Fornece um nível superior: interface simplificada para um subsistema resultando em
reduzida complexidade e dependência

https://refactoring.guru/pt-br/design-patterns/facade

![](https://refactoring.guru/images/patterns/diagrams/facade/structure.png)
___

### Proxy
> O Proxy é um padrão de projeto estrutural que permite que você forneça
um substituto ou um espaço reservado para outro objeto.  
> Um proxy controla o acesso ao objeto original, permitindo que você faça algo ou antes 
ou depois do pedido chegar ao objeto original.

https://refactoring.guru/pt-br/design-patterns/proxy

![](https://refactoring.guru/images/patterns/diagrams/proxy/structure.png)

- #### Diferenças entre o Proxy e outros padrões:
    - ##### Decorator:
        - No Decorator o cliente pode acessar o objeto diretamente. 
        Ele o faz através do Decorator pois este adiciona alguma funcionalidade que o interessa.
        - No caso do Proxy o cliente acessa-o pensando que está acessando o objeto original.
        - O Proxy geralmente gerencia o ciclo de vida de seu objeto de serviço por conta própria, 
        enquanto a composição de Decorators é sempre controlada pelo cliente.
    - ##### Facade:
        - O Proxy sempre refere-se a um único objeto.  
        - Ainda que desencorajado, o cliente se precisar pode acessar os objetos do subsistema 
        diretamente.
    - ##### Chain of Responsibility Pattern:
        - O Proxy refere-se a um único objeto.
        - Requisições são recebidas diretamente pelo Proxy, mas nunca são processadas por ele.
        - No CoR a resposta à requisição não é obrigatória.
___

### Bridge
> O padrão Bridge promove a separação da uma interface de abstração de sua implementação.  
> O Bridge permite que você divida uma classe grande ou um conjunto de classes intimamente ligadas
em duas hierarquias separadas—abstração e implementação, 
que podem ser desenvolvidas independentemente umas das outras.

https://refactoring.guru/pt-br/design-patterns/bridge

![](https://refactoring.guru/images/patterns/diagrams/bridge/structure-pt-br.png)
___

### Resumo dos padrões estruturais:
- #### Decorator: 
    Adicionar funcionalidade a um objeto dinamicamente.
- #### Adapter: 
    Permitir que um objeto seja substituído por outro que, apesar de realizar a mesma tarefa, 
    possui uma interface diferente.
- #### Composite: 
    Estrutura (por composição) de objetos com relação hierárquica (pai-filho).
- #### Façade: 
    Prover uma interface simplificada para a utilização de várias interfaces de um subsistema.
- #### Proxy: 
    Controlar as chamadas a um objeto através de outro objeto de mesma interface.
- #### Bridge: 
    Separar uma abstração de sua representação, de forma que ambos possam variar e produzir 
    tipos de objetos diferentes.
___