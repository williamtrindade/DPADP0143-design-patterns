### Enunciado:

O aluno deverá desenvolver uma implementação da interface br.ufsm.csi.pp.PersistenceLayer que dado
um objeto gera um comando INSERT ou UPDATE para este objeto na base de dados. A classe do objeto deverá estar
devidamente anotadas com as seguintes anotações:

    @Tabela(nome = "nome_da_tabela"):
        Anotação para a classe com a identificação do nome da tabela.

    @ChavePrimaria
            Anotação para identificar o getter da propriedade que representa a chave primária da classe/tabela.

    @Coluna(nome = "nome_da_coluna", tipo = "tipo_coluna_no_bd", size = "tamanho", unique = "true|false"):
        Anotação para cada getter da classe que representa um atributo que deve ser persistido no SGBD.
        Atributos:
            nome: Nome da coluna a ser criada na tabela.
            tipo: Tipo da coluna a ser criada. Deve ser um tipo nativo do SGBD.
            size: Tamanho da coluna passado no tipo entre parênteses. Usado apenas nos tipos que suportam tamanho.
                Ex. varchar(255), int(11).
            unique: Informa se a coluna deve ser criada como unique.

O método implementado no PersistenceLayer deverá gerar um comando insert sempre que o valor do atributo Chave Primária
do objeto for null. Se existir valor de chave primária, então o PersistenceLayer deverá gerar um comando update. Para os
INSERTs presuma que as chaves primárias no SGBD são do tipo autoincremento, e não farão parte do INSERT.

Após a implementação do PersistenceLayer, o aluno deverá alterar a classe de teste Main, colocando uma instância
da sua classe para teste com a classe "ClasseExemplo". Após o teste deverá imprimir na saída padrão
comandos semelhantes a estes:

    INSERT INTO CLASSE_EXEMPLO (CODIGO, ATRIBUTO1, ATRIBUTO2) values (123456, 'valor 1', 'valor 2');

    UPDATE CLASSE_EXEMPLO set CODIGO = 123456, ATRIBUTO1 = 'valor1', ATRIBUTO2 = 'valor 2' where ID = 1;


Avaliação:

1) Geração do comando INSERT/UPDATE [3,0]
2) Detalhes do SQL: valores, where, etc. [2,0]
4) Organização e Padronização do código (code conventions) [1,0]