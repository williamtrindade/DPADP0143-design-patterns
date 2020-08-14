### Exercise 4:
1. Implementar a mesma funcionalidade de Logs do Banco (exercício anterior), 
porém através de um Proxy dinâmico.  
    a) Nos logs deverá haver o tempo decorrido na invocação de cada
       método.  
    b) Alterar o método factory estático getInstancia(), para entregar um
       proxy do Banco.
2. Re-implementar o exercício do Pool Genérico, porém:  
    2.1. O pool não será mais genérico. Será um Pool para Conexões com
        um SGBD qualquer (java.sql.Connection).   
    2.2. O pool não terá o método release().  
    2.3. Ao invés disso o cliente recebe um proxy para uma conexão, e 
        quando este invocar “close()” isto terá o mesmo efeito de release.  
    2.4. Faça o Pool receber um DataSource como parâmetro, para criação das conexões.