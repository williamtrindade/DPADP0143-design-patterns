## Padrões comportamentais
> São voltados aos algoritmos e a designação de responsabilidades entre objetos.
___

### Memento
> O Memento é um padrão de projeto comportamental que permite que você salve e restaure o estado anterior de um objeto sem revelar os detalhes de sua implementação.

https://refactoring.guru/pt-br/design-patterns/memento

- #### Implementação baseada em classes aninhadas  
![](https://refactoring.guru/images/patterns/diagrams/memento/structure1.png)

- #### Implementação baseada em uma interface intermediária / PHP  
![](https://refactoring.guru/images/patterns/diagrams/memento/structure2.png)

- #### Implementação com um encapsulamento ainda mais estrito  
![](https://refactoring.guru/images/patterns/diagrams/memento/structure3.png)
___

### Interpreter
> Dado um idioma, define uma representação para sua gramática 
junto com um intérprete que usa a representação para interpretar
sentenças no idioma.  
> Mapeia um domínio para um idioma, o idioma para uma gramática,
e a gramática para um design orientado a objetos hierárquico.

https://sourcemaking.com/design_patterns/interpreter

![](https://sourcemaking.com/files/v2/content/patterns/Interpreter1.png)
___

### State
> O State permite que um objeto altere seu comportamento 
quando seu estado interno muda.  
> Parece como se o objeto mudasse de classe.

https://refactoring.guru/pt-br/design-patterns/state

![](https://refactoring.guru/images/patterns/diagrams/state/structure-pt-br.png)
___

### Strategy
> O padrão de Strategy é útil quando há um conjunto de
  algoritmos relacionados e um objeto cliente precisa
  ser capaz de escolher dinamicamente um algoritmo
  desse conjunto.

> Ele permite que você defina uma família de algoritmos, 
coloque-os em classes separadas, 
e faça os objetos deles intercambiáveis.

https://refactoring.guru/pt-br/design-patterns/strategy

![](https://refactoring.guru/images/patterns/diagrams/strategy/structure.png)

#### Strategy vs. State
- State cria subclasses que relacionam estado com comportamento do objeto.
- Strategy cria subclasses para agrupar algoritmos que são similares entre si.
- A escolha de um State é feita com base no estado do objeto de contexto.
- A escolha de um Strategy é feita com base nas necessidades do objeto de contexto,
  apenas. A instância de Strategy utilizada no contexto não guarda nenhuma relação com o
  estado do objeto
___

### Null Object
> A intenção desse padrão é encapsular a ausência de um objeto, 
fornecendo uma alternativa substituível que oferece um comportamento padrão 
adequado para não fazer nada.   
Em suma, um design onde "nada virá do nada".

https://sourcemaking.com/design_patterns/null_object

![](https://sourcemaking.com/files/v2/content/patterns/Null_Object2.png)
___
