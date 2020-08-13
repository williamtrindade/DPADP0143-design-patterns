## Padrões criacionais
> Tratam da criação de objetos.
___

### Factory Method
> Dentre uma hierarquia de classes ajuda a escolher qual classe a classe cliente deve utilizar.

https://refactoring.guru/design-patterns/factory-method

![](https://refactoring.guru/images/patterns/diagrams/factory-method/structure.png)
___

### Singleton
> Define que só pode haver uma instância de uma determinada classe no ciclo de vida da aplicação.  
 
https://refactoring.guru/design-patterns/singleton  

![](https://refactoring.guru/images/patterns/diagrams/singleton/structure-en.png)  
___

### Multiton (não GoF)
> Uma pequena variação do Singleton que permite a criação de uma
quantidade limitada de instâncias, de acordo com alguma regra de
negócio.
___

### Object Pool (não GoF)
> Facilita o reaproveitamento de instâncias de objetos, ao invez de criar e destruir objetos 
podemos usar o pool.

https://sourcemaking.com/design_patterns/object_pool

![](https://sourcemaking.com/files/v2/content/patterns/Object_pool1.png)
___

### Abstract Factory
> Fornece uma interface para construir uma familia de objetos.

https://refactoring.guru/design-patterns/abstract-factory

![](https://refactoring.guru/images/patterns/diagrams/abstract-factory/structure.png)
___


### Prototype
> Criar um objeto antecipadamente e designar ele como objeto protótipo. E criar outros objetos
simplesmente fazendo uma cópia desse objeto protótipo fazendo as modificações necessárias.

https://refactoring.guru/design-patterns/prototype

- ***Basic implementation***  
![](https://refactoring.guru/images/patterns/diagrams/prototype/structure.png)  
- ***Prototype registry implementation***    
![](https://refactoring.guru/images/patterns/diagrams/prototype/structure-prototype-cache.png)  
___

### Builder
> Qunado construir uma classe é um processo complexo. Podemos aplicar o builder.  
Ele separa o proceso de contrução de objeto da sua representação.

https://refactoring.guru/design-patterns/builder

![](https://refactoring.guru/images/patterns/diagrams/builder/structure.png)
___