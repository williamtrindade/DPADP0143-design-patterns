package br.ufsm.csi.pp;

/**
 * Interface que representa o n�vel de persist�ncia de dados da aplica��o.
 * Deve ser implementada por um framework de persist�ncia de dados (mapeamento objeto-relacional).
 *
 * Created by Rafael on 06/06/2022.
 */
public interface PersistenceLayer {

    /**
     * m�todo que recebe um objeto gerando um insert caso ele n�o possua valor de chave prim�ria, ou um update caso ele j� possua.
     * @param o objeto para gerar o insert/update.
     * @return string contendo o insert/update'
     */
    String generateInsertUpdate(Object o);

}
