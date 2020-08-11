## Reflexão
> `javax.reflection` é um pacote que permite criar chamadas em `runtime`.
- ### Algumas possibilidades
    - Listar atributos de uma classe.
    - Retornar valores de atributos das classes.
    - Instanciar classe em runtime.
    - Chamar métodos em runtime.
    - Descobrir se o código tem @annotations.
___
- ### Classe Class
    > Possibilita acessar dados de uma classe em runtime.
    - #### Formas de pegar a Class:
        - ##### Pela instância do objeto
        ```java
        User user = new User();
        Class<User> class = user.getClass();
        ```
        - ##### Pelo atributo estático .class da classe
        ```java
        Class<User> class = User.class;
        ```
        - ##### Pelo Class.forName (pelo nome da classe)
        ```java
        Class class = Class.forName("User");
        ```
        > Para chamar a classe ela deve estar carregada no sistema ( class loader )

    - #### Carregar uma classe no classloader em runtime via jar
    ```java
    URLClassLoader child = new URLClassLoader(myJar.toURL(), this.getClass().getClassLoader());
    Class classToLoad = Class.forName("com.MyClass", true, child);
    Method method = classToLoad.getDeclaredMethod("myMethod");
    Object instance = classToLoad.newInstance();
    Object result = method.invoke(instance);
    ```
___
- ### Formas de usar reflexão
    - #### Pegar campos de uma Class
    ```java
    Clas class = User.class;
    for(Field field: class.getDeclaredFields()) {
      field.get(instance); // tenho que passar a instância
      field.set(instance, null); 
    }   
    ```
    - #### Pegar métodos de uma Class
    ```java
    Class class = User.class;
    for(Method method: class.getDeclaredMethods()) {
      method.invoke("p1", "p2");
    }   
    ```
    - #### Pegar campo de uma Class pelo nome
    ```java
    Class class = User.class;
    Field field = class.getDeclaredField("fieldName");
    field.set(instance, "value");
    ```
    - #### Pegar método de uma Class pelo nome
    ```java
    Class class = User.class;
    Method method = class.getDeclaredMethod("methodName", String.class);
    method.invoke(instance, "param");
    ```
       
  