package br.ufsm.csi.pp;

/**
 * Interface que representa o nível de persistência de dados da aplicação.
 * Deve ser implementada por um framework de persistência de dados (mapeamento objeto-relacional).
 *
 * Created by Rafael on 06/06/2022.
 */
public interface PersistenceLayer {

    /**
     * método que recebe um objeto gerando um insert caso ele não possua valor de chave primária, ou um update caso ele já possua.
     * @param o objeto para gerar o insert/update.
     * @return string contendo o insert/update'
     */
    String generateInsertUpdate(Object o);

}
