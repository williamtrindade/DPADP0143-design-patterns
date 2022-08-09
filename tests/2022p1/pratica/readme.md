### Enunciado:

O aluno dever� desenvolver uma implementa��o da interface br.ufsm.csi.pp.PersistenceLayer que dado
um objeto gera um comando INSERT ou UPDATE para este objeto na base de dados. A classe do objeto dever� estar
devidamente anotadas com as seguintes anota��es:

    @Tabela(nome = "nome_da_tabela"):
        Anota��o para a classe com a identifica��o do nome da tabela.

    @ChavePrimaria
            Anota��o para identificar o getter da propriedade que representa a chave prim�ria da classe/tabela.

    @Coluna(nome = "nome_da_coluna", tipo = "tipo_coluna_no_bd", size = "tamanho", unique = "true|false"):
        Anota��o para cada getter da classe que representa um atributo que deve ser persistido no SGBD.
        Atributos:
            nome: Nome da coluna a ser criada na tabela.
            tipo: Tipo da coluna a ser criada. Deve ser um tipo nativo do SGBD.
            size: Tamanho da coluna passado no tipo entre par�nteses. Usado apenas nos tipos que suportam tamanho.
                Ex. varchar(255), int(11).
            unique: Informa se a coluna deve ser criada como unique.

O m�todo implementado no PersistenceLayer dever� gerar um comando insert sempre que o valor do atributo Chave Prim�ria
do objeto for null. Se existir valor de chave prim�ria, ent�o o PersistenceLayer dever� gerar um comando update. Para os
INSERTs presuma que as chaves prim�rias no SGBD s�o do tipo autoincremento, e n�o far�o parte do INSERT.

Ap�s a implementa��o do PersistenceLayer, o aluno dever� alterar a classe de teste Main, colocando uma inst�ncia
da sua classe para teste com a classe "ClasseExemplo". Ap�s o teste dever� imprimir na sa�da padr�o
comandos semelhantes a estes:

    INSERT INTO CLASSE_EXEMPLO (CODIGO, ATRIBUTO1, ATRIBUTO2) values (123456, 'valor 1', 'valor 2');

    UPDATE CLASSE_EXEMPLO set CODIGO = 123456, ATRIBUTO1 = 'valor1', ATRIBUTO2 = 'valor 2' where ID = 1;


Avalia��o:

1) Gera��o do comando INSERT/UPDATE [3,0]
2) Detalhes do SQL: valores, where, etc. [2,0]
4) Organiza��o e Padroniza��o do c�digo (code conventions) [1,0]