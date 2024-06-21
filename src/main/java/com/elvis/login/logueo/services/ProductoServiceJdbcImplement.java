package com.elvis.login.logueo.services;

import com.elvis.login.logueo.models.Categoria;
import com.elvis.login.logueo.models.Producto;
import com.elvis.login.logueo.repositorio.CategoriaRepositoryJdbcImplement;
import com.elvis.login.logueo.repositorio.ProductoRepositoryJdbcImplement;
import com.elvis.login.logueo.repositorio.Repositorys;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProductoServiceJdbcImplement implements ProductoService {

    private Repositorys<Producto> repositoryJdbc;
    private Repositorys<Categoria> repositoryCategoriaJdbc;

    public ProductoServiceJdbcImplement(Connection connection) {
        this.repositoryJdbc = new ProductoRepositoryJdbcImplement(connection);
        this.repositoryCategoriaJdbc = new CategoriaRepositoryJdbcImplement(connection);
    }

    @Override
    public List<Producto> listar() {
        try{
            return repositoryJdbc.listar();
        }catch (SQLException throwables){
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public Optional<Producto> porId(Integer id) {
        try{
            return Optional.ofNullable(repositoryJdbc.porId(id));
        }catch (SQLException throwables){
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }

    }

    @Override
    public void guardar(Producto producto) {

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Categoria> listarCategorias() {
        try {
            return repositoryCategoriaJdbc.listar();
        }catch (SQLException throwables){
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public Optional<Categoria> porIdCategoria(Integer id) {
        try{
            return Optional.ofNullable(repositoryCategoriaJdbc.porId(id));

        }catch (SQLException throwables){
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }
}
