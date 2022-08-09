package io.github.williamtrindade;

import java.util.Map;

/**
 * Interface que representa ou presta serviços a quem é fornecido por um gerador de formulário html
 */
public interface FormGenerator {

    /**
     * Gera o código em html para um formulário do objeto recebido como parâmetro
     * O formulário deverá vir preenchido, caso o objeto tenha valores nos parâmetros
     *
     * @param object objeto que será utilizado para gerar o form e preencher os valores, caso existam
     * @return a string html que representa o formulário
     */
    String generateForm(Object object);

    /**
     * Gera o código em html para exibição do objeto recebido como parâmetro.
     * Poderá ser um formulário preenchido e read-only ou um HTML apenas exibindo nomes das
     * propriedades e valores.
     *
     * @param object objeto que será utilizado para gerar o HTML com os valores
     * @return a string html que representa o documento
     */
    String generateReadOnlyView(Object object);


    /**
     * Preenche um objeto com os parâmetros recebidos do formulário.
     *
     * @param requestParams mapa dos parâmetros do formulário
     * @param ObjClass classe do objeto que será instanciado e preenchido
     * @return o objeto com as propriedades preenchidas do form.
     */
    Object populateObject(Map<String, String> requestParams, Class<?> objClass);

}
