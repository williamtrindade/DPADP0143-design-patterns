### Exercice 2 / C
- Implemente um Pool Genérico (classe concreta) de objetos a partir da interface:  
    ```java
    public interface Pool<T> { 
        T acquire(); 
        void release(T t); 
    }  
    ```
- O pool deverá manter no mínimo 3 instâncias criadas e deverá instanciar no
máximo 20. 
- Caso algum cliente tente fazer acquire e o máximo já tenha sido
atingido, deverá esperar até que algum outro cliente devolva outro objeto

(problema dos produtores vs. Consumidores).