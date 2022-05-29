## Padrões de projeto
### Introdução
> A OOP trouxe os benefícios de:
- Encapsulamento
- Modularidade
- Polimorfismo

### Padrões GOF
> São divididos em categorias:
- Padrões de criação
- Padrões estruturais
- Padrões comportamentais

### Padrões de projeto básicos
#### Interface
> É um contrato de prestação de serviço.
```java
public interface Model {
    public String getTable();
}
```

#### Abstract parent class
> É como uma `interface` provem um serviço com implementação comum entre classes.
```java
abstract class Animal {
  public abstract void animalSound();
  public void sleep() {
    System.out.println("Zzz");
  }
}
```

#### Private methods
> Serve para o encapsulamento de funcionalidade de uma classe, que apenas servem para o provedor do serviço.
```java
public class User {
    private Model findById() {}
        //
    }
}
```
#### Accessor Methods
> Permite acessar o estado de um objeto usando métodos específicos.
```java
public class User {
    private Integer id;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
```

#### Constant data manager
> Permite centralizar dados constantes.
```java
public final class ConstantDataManager {
    public static final String VALID_CC_CHARS = "0123456789";
    public static final String MASTER = "MASTER";
    public static final String VISA = "VISA";
    public static final String DISCOVER = "DISCOVER";

    private ConstantDataManager (){
       throw new AssertionError();
    }
}
```

#### Immutable Object
> Serve para garantir que um estado não pode ser alterado.
```java
class Money {
    private final double amount;
    private final Currency currency;

    public Money(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }
 
    public Currency getCurrency() {
        return currency;
    }
 
    public double getAmount() {
        return amount;
    }
}
```
__________

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