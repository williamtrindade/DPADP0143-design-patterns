## Class 2
## Java Collections Framework:
![Class diagram](https://www.codejava.net/images/articles/javacore/collections/collections%20framework%20overview.png)

- Robusta.
- Possui diversas implementações de Data structures.

### Interface java.util.List
- Permite objetos duplicados.
- Mantem a ordenação.
    - ### ArrayList
        - Implementa com array.
        - Mais rápida.
        - Mais computacionalmente económica.
        - Ideal para listas que não vão mudar de tamanho.
    - ### LinkedList
        - Menos computacionalmente económica.
        - Mais lesta para percorrer.
        - Mais rápida para inserir e remover.
        - Ideal para listas que vão mudar de tamanho.

### Interface java.util.Set
- Conjuntos (Aglomerado de objetos).
- Objetos não se repetem.
- A ordem não é mantida.
    - ### HashSet
        - Usa tabela de hash.
        - Não mantem ordem.
    - ### TreeSet
        - Usa árvore.
        - Mantém ordem crescente.
        - Objetos devem implementar Comparable ou Set deve receber um Comparator.
    - ### LinkedHashSet
        - Utiliza misto de LinkedList e Hash Table.
        - Rápido para buscar.
        - Lento para percorrer.

### Interface java.util.Collection
- Implementações não garantem ordem.
- Não se importa com a duplicidade.
- É uma coleção de objetos.
- É a interface pai de Set e List.

### Interface java.util.Map
- Ideal para fazer indices.
- Utiliza Set(conjunto) de chave.
- Utiliza Collection(coleção) de valores.
    - ### HashMap
        - Utiliza hash.
        - Não guarda ordem.
    - ### TreeMap
        - Chaves implementam Comparable.
        - Utiliza árvore.
        - Mantém a ordem nas chaves de forma crescente.
    - ### LinkedHashMap
        - Utiliza LinkedList e Hash Table.
        - Mantém a ordem de inserção.
### equals() e hashCode()
- Métodos da classe Object.
- Regra: Objetos iguais, devem gerar o mesmo hash code.
- ### equals()
    - Compara se dois valores são iguais.
    - Retorna true se as referencias forem iguais.
    - Pode se sobrescrever equals, para ter uma regra personalizada.
    - Sempre que sobrescrevo equals() devo sobrescrever hashCode().
- ### hashCode()
    - usado para encontrar um elemento na HashTable, por isso toda a classe já tem uma implementação dele.
    - Considera equals().
____
## Exceptions:
![](https://www.caelum.com.br/apostila-java-orientacao-objetos/images/excecoes/arvore_heranca_throwable.png)
    
- Toda a execução é jogada numa stack, onde é isolada a área de memória para aquele método.
- Quando a exceção não é tratada na aplicação, é jogada na saída, padrão.
- Toda a exceção gera um stack trace, mostrando a pilha de chamadas até o erro ocorrer.  

<strong style="color:green">Tratar exceptions:<strong>
``` java
    try {
        // code here
    } catch(Exception e) {
        // tratar
    }
```   
<strong style="color:green">Atirar exceptions:<strong>
``` java
    if (movement.getValue() > this.getLimit()) {
        throw new IllegalStateException("Value exced the limit");
    }
```

<strong style="color:green">Sempre atirar exceptions:<strong>
``` java
    try {
        // code here
    } catch(Exception e) {
        // tratar
    } finally {
        // sempre é executada, independente se deu exceção ou não
    }
```
### Categorias de exceções
- ### Runtime Exception
    - São exceções que ocorrem em tempo de execução, podem ser tratadas com try/catch, mas o tratamento é opcional.
- ### Checked Exception
    - São mais comuns, devem ser tratadas ou declaradas na assinatura do método.
- ### Error
    - São erros da JVM, não são atiráveis o que fazer para lhes tratar.
 