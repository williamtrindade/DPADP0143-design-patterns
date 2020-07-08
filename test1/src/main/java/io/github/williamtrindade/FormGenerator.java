package br.ufsm.csi.pp;

import java.util.Map;

/**
 * Interface que representa o serviço que deverá ser provido por um gerador de form html
 */
public interface FormGenerator {

    /**
     * Gera o código em html para um formulário do objeto recebido como parâmetro
     * O formulário deverá vir preenchido, caso o objeto tenha valores nos parâmetros
     *
     * @param objeto objeto que será utilizado para gerar o form e preencher os valores, caso existam
     * @return a string html que representa o formulário
     */
    String generateForm(Object objeto);

    /**
     * Gera o código em html para exibição do objeto recebido como parâmetro.
     * Poderá ser um formulário preenchido e read-only ou um HTML apenas exibindo nomes das
     * propriedades e valores.
     *
     * @param objeto objeto que será utilizado para gerar o HTML com os valores
     * @return a string html que representa o documento
     */
    String generateReadOnlyView(Object objeto);


    /**
     * Preenche um objeto com os parâmetros recebidos do formulário.
     *
     * @param parametrosRequisicao mapa dos parâmetros do formulário
     * @param classe classe do objeto que será instanciado e preenchido
     * @return o objeto com as propriedades preenchidas do form.
     */
    Object populateObject(Map<String, String> parametrosRequisicao, Class classe);

}
