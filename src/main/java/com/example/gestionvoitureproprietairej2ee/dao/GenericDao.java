package com.example.gestionvoitureproprietairej2ee.dao;

import java.sql.SQLException;
import java.util.Collection;

public interface GenericDao<T, ID> {
        public T save(T t) throws SQLException;
        public T update(T t) throws SQLException;
        public void delete(ID id) throws SQLException;
        public T findById(ID id) throws SQLException;
        public Collection<T> findAll() throws SQLException;
}
