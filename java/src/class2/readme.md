## Class 2
## Java Collections Framework
![Class diagram](https://www.codejava.net/images/articles/javacore/collections/collections%20framework%20overview.png)

- Robusta.
- Possui diversas implementações de Data structures.

### Interface java.util.List
- Permite objetos duplicados.
- Mantem a ordenação.
  - ### ArrayList
    - Implementa com array.
    - Mais rápida.
    - Mais computacionalmente economica.
    - Ideal para listas que não vão mudar de tamanho.
  - ### LinkedList
    - Menos computacionalmente economica.
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
        - Mantem ordem crescente.
        - Objetos devem implmentar Comparable ou Set deve receber um Comparator.
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
        - Chaves implentam Comparable.
        - Utiliza árvore.
        - Mantem a ordem nas chaves de forma crescente.
    - ### LinkedHashhMap
        - Utiliza LinkedList e Hash Table.
        - Mantem a ordem de inserção.
### equals() e hashCode()
- Métodos da classe Object.
- Regra: Objetos iguais, devem gerar o mesmo hash code.
- ### equals()
    - Compara se dois valores são iguais.
    - Retorna true se as referencias forem iguais.
    - Pode se sobreescrever equals, para ter uma regra personalizada.
    - Sempre que sobreescrevo equals() devo sobreescrever hashCode().
- ### hashCode()
    - usado para encontrar um elemento na HashTable, por isso toda classe já tem uma implentação de dele.
    - Leva em consideração equals().