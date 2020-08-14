## Padrões estruturais
> Tratam da estrutura da relação entre os objetos.
___

### Decorator
> O Padrão do Decorator é usado para estender a funcionalidade de um objeto dinamicamente sem
  ter que alterar a origem da classe original ou usar herança.  
  Isso é conseguido criando um wrapper de objeto denominado “Decorator” em torno do objeto real.

https://refactoring.guru/pt-br/design-patterns/decorator

![](https://refactoring.guru/images/patterns/diagrams/decorator/structure.png)
___

### Adapter
> O Adapter é um padrão de projeto estrutural que permite objetos com interfaces 
  incompatíveis colaborarem entre si.  
> Em alguns casos uma classe pode prover o serviço que o cliente requer, 
  porém a interface não é o que este cliente espera.
> Nestes casos a interface existente precisa ser convertida para uma interface 
  mais amigável para o uso por aquele cliente.

https://refactoring.guru/pt-br/design-patterns/adapter

- ***Object Adaptern***  
![](https://refactoring.guru/images/patterns/diagrams/adapter/structure-object-adapter.png)

- ***Class Adaptern***  
![](https://refactoring.guru/images/patterns/diagrams/adapter/structure-class-adapter.png)
___

### Composite (Object Tree)
> O Composite é um padrão de projeto estrutural que permite que você componha 
  objetos em estruturas de árvores e então trabalhe com essas estruturas como
  se elas fossem objetos individuais.  
> O uso do padrão Composite faz sentido apenas quando o modelo principal do seu
  aplicativo pode ser representado como uma árvore.

https://refactoring.guru/pt-br/design-patterns/composite

![](https://refactoring.guru/images/patterns/diagrams/composite/structure-pt-br.png)
___