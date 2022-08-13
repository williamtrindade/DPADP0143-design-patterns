package br.ufsm.csi.pp.dao;

import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.SQLException;

public interface DAOGenericoInterface<T> {
    T getById(Serializable id) throws SQLException;

    void update(T t) throws SQLException;

    void remove(T t) throws SQLException;

    void create(T t) throws SQLException;

    DataSource getDataSource();

    Class<T> getClasse();
}
