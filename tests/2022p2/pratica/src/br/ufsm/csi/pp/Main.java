package br.ufsm.csi.pp;

import br.ufsm.csi.pp.dao.DAOGenerico;
import br.ufsm.csi.pp.dao.DAOGenericoInterface;
import br.ufsm.csi.pp.decorator.DAOLogDecorator;
import br.ufsm.csi.pp.model.Cliente;

import java.sql.SQLException;

/**
 * Classe para realização dos testes.
 */
public class Main {
    public static void main(String[] args) throws SQLException {

        Cliente clientModel = new Cliente();

        DAOGenerico clientDAO = new DAOGenerico(clientModel.getClass());

        DAOGenericoInterface daoLogDecorator = new DAOLogDecorator(clientDAO);

        clientModel.setNome("WIll");
        /**
         * - Cria o registro no banco
         * - Como faz uso do decorator o mesmo registra uma tupla na tabela logs no banco de dados
         */
        daoLogDecorator.create(clientModel);
    }
}
