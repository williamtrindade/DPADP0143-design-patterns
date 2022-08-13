package br.ufsm.csi.pp.Logger;

import javax.sql.DataSource;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Classe responsável por inserir os LOGS fazendo uso do Logger Model.
 */
public class DatabaseLogger {
    private DataSource dataSource;
    private Object classe;

    public DatabaseLogger(DataSource dataSource, Object classe) {
        this.dataSource = dataSource;
        this.classe = classe;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void createModel() throws SQLException {
        Connection connection = this.dataSource.getConnection();
        LoggerModel loggerModel = new LoggerModel("CRIAÇÃO", this.classe.toString());
        loggerModel.insert(connection);
    }
    public void readModel(Serializable id) throws SQLException {
        Connection connection = this.dataSource.getConnection();
        LoggerModel loggerModel = new LoggerModel("LEITURA", (Long) id, this.classe.toString());
        loggerModel.insert(connection);
    }
    public void updateModel() throws SQLException {
        Connection connection = this.dataSource.getConnection();
        LoggerModel loggerModel = new LoggerModel("ATUALIZAÇÃO", this.classe.toString());
        loggerModel.insert(connection);
    }
    public void deleteModel() throws SQLException {
        Connection connection = this.dataSource.getConnection();
        LoggerModel loggerModel = new LoggerModel("REMOÇÃO", this.classe.toString());
        loggerModel.insert(connection);
    }
}
