## Reflexão
- `javax.reflection` é um pacote que permite criar chamadas em `runtime`.
- ### Algumas possibilidades
    - Listar atributos de uma classe.
    - Retornar valores de atributos das classes.
    - Instanciar classe em runtime.
    - Chamar métodos em runtime.
    - Descobrir se o código tem @annotations.
- ### Classe Class
    - Possibilita acessar dados de uma classe em runtime.
    - #### Formas de pegar dados de uma classe:
        - ##### Pela instância do objeto
        ```java
        User user = new User();
        Class<User> class = user.getClass();
        ```
        - ##### Pelo atributo estático .class da classe
        ```java
        Class<User> class = User.class;
        ```
        - ##### Pelo Class.forName (pelo nome)
        ```java
        Class class = Class.forName("User");
        ```