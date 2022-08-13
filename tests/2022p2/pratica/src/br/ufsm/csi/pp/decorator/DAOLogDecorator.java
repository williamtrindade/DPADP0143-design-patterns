package br.ufsm.csi.pp.decorator;

import br.ufsm.csi.pp.Logger.DatabaseLogger;
import br.ufsm.csi.pp.dao.DAOGenericoInterface;
import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.SQLException;

/**
 * Decorator que implementa a interface do objeto oculto.
 * Estende a funcionalidade definida em DAOGenericoInterface.
 */
public class DAOLogDecorator implements DAOGenericoInterface {
    /** DAO decorado **/
    private DAOGenericoInterface DAODecorated;
    private DatabaseLogger databaseLogger;

    public DAOLogDecorator(DAOGenericoInterface DAODecorated) {
        this.DAODecorated = DAODecorated;
        this.databaseLogger = new DatabaseLogger(this.getDataSource(), this.getClasse());
    }

    @Override
    public Object getById(Serializable id) throws SQLException {
        this.databaseLogger.readModel(id);
        return this.DAODecorated.getById(id);
    }

    @Override
    public void update(Object o) throws SQLException {
        this.databaseLogger.updateModel();
        this.DAODecorated.update(o);
    }

    @Override
    public void remove(Object o) throws SQLException {
        this.databaseLogger.deleteModel();
        this.DAODecorated.remove(o);
    }

    @Override
    public void create(Object o) throws SQLException {
        this.databaseLogger.createModel();
        this.DAODecorated.create(o);
    }

    @Override
    public DataSource getDataSource() {
        return this.DAODecorated.getDataSource();
    }

    @Override
    public Class getClasse() {
        return this.DAODecorated.getClasse();
    }
}
