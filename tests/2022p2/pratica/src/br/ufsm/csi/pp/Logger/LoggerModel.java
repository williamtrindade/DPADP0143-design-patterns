package br.ufsm.csi.pp.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Classe modelo representando o Log que vai ser inserido no banco de dados.
 */
public class LoggerModel {
    private Long id;
    private final String tipo;
    private final Long idObjeto;
    private final String classe;

    public LoggerModel(String tipo, Long idObjeto, String classe) {
        this.tipo = tipo;
        this.idObjeto = idObjeto;
        this.classe = classe;
    }

    public LoggerModel(String tipo, String classe) {
        this.tipo = tipo;
        this.classe = classe;
        idObjeto = null;
    }

    /**
     * Método que realiza o insert na tabela logs, a implementação talvez precise de uma melhoria
     * dado a impossibilidade dos testes nesse momento
     *
     * @param connection
     * @throws SQLException
     */
    public void insert(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = (PreparedStatement) connection.createStatement();
        preparedStatement.setString(0, this.tipo);

        preparedStatement.setString(2, this.classe);
        // CREATE - ALL
        if (this.idObjeto != null) {
            preparedStatement.setLong(1, this.idObjeto);
            preparedStatement.execute("INSERT INTO logs (tipo, idObjeto, classe) values (?, ?, ?)");
        } else {
            // UPDATE - READ - DELETE
            preparedStatement.execute("INSERT INTO logs (tipo, classe) values (?, ?)");
        }
        preparedStatement.execute();
    }

    public Long getId() {
        return id;
    }
}
