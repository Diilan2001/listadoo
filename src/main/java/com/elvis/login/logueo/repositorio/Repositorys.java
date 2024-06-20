package com.elvis.login.logueo.repositorio;

import java.sql.SQLException;
import java.util.List;

public interface Repositorys <T>{
    List<T> listar() throws SQLException;
    T porId(Integer id) throws SQLException;

    // varable q se va a utilizar
    void guardar (T t) throws SQLException;
    void eliminar(Integer id) throws SQLException;

    //activar y desactivar
    T activar (Integer id) throws SQLException;
    T desactivar (Integer id) throws SQLException;



}
