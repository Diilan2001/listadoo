package com.elvis.login.logueo.models;

public class Categoria {
    private Integer idCategoria;
    private String nombre;
    private int condicion;

    public Categoria(){}
    public Categoria(Integer idCategoria, String nombre, int condicion) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.condicion = condicion;
            }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCondicion() {
        return condicion;
    }

    public void setCondicion(int condicion) {
        this.condicion = condicion;
    }
}
