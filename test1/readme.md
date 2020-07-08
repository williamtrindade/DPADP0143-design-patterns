#### Enunciado:

> O aluno deverá desenvolver uma implementação da interface br.ufsm.csi.pp.FormGenerator que dada uma classe, esta deverá gerar o código HTML para um formulário desta classe. As classes deverão estar devidamente anotadas com as seguintes anotações:
___
```java
@Form(name = "nomeForm", action = "/action", submitButton = "Enviar")
```
> Anotação para a classe com informações do formulário. Se uma classe não tiver esta anotação, não poderá ser gerado um form a partir dela.
- Atributos:
    - Name: Atributo que será copiado para a tag form.
    - Action: Atributo que também será copiado para a tag form.
    - SubmitButton: Nome do botão submit, que ficará no final do formulário
___
```java
@Field(name = "attrib", type = Field.FieldType.TEXT, label = "Atributo", size = 100)
```
> Anotação para um método getter, que caso existente, deverá gerar um campo no formulário HTML. Se uma método get não tiver esta anotação, não será gerado nenhum campo no form para ele.
- Atributos:
    - Name: name e id do campo de formulário.
    - Type: tipo do campo de formulário. Opções possíveis: text, textarea e hidden. Caso o tipo de retorno do método get na classe seja java.lang.Boolean este valor será ignorado e o campo sempre será checkbox.
    - Label: Label do campo do formulário.
    - Size: atributo que será copiado para a tag input.
___
> Foi disponibilizada uma classe exemplo, bem como o resultado esperado em HTML, da execução do FormGenerator. Use a classe exemplo e o resultado esperado para testar a sua implementação.

> A interface FormGenerator tem um método "generateReadOnlyView" que funciona de forma semelhante ao "generateForm" porém deverá gerar apenas uma visualização do objeto, sem formulário, ou com formulário somente-leitura.

> A interface FormGenerator tem um método "populateObject" que serve para preencher o objeto com os valores, depois que o formulário é submetido. Será instanciado um novo objeto da classe recebida por parâmetro e setados os atributos @Field nos campos da classe com os valores retirados do map "parametrosRequisicao".

> A implementação de FormGenerator deverá ser um SINGLETON.
___
##### Avaliação Prática (Peso 5,0):

1) Geração do formulário [1,5]
2) Geração do formulário read-only [1,5]
3) Implementação do método "populateObject" [1,5]
4) Implementação do SINGLETON, Organização e Padronização do código (code conventions) [0,5]