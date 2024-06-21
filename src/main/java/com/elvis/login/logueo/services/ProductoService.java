package com.elvis.login.logueo.services;

import com.elvis.login.logueo.models.Categoria;
import com.elvis.login.logueo.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listar();
    //Implemntamos un método para obtener el producto por
    //id
    Optional<Producto> porId(Integer id);
    //implementamos un metodo para guardar
    void guardar(Producto producto);
    //implementamos un metodo para eliminar
    void eliminar(Integer id);
    //implementamos el metodo para listar la categoria
    List<Categoria> listarCategorias();
    //implementamos el metodo para obtener el id de la categoria
    Optional<Categoria> porIdCategoria(Integer id);
}
