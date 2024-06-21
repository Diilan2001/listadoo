package com.elvis.login.logueo.repositorio;

import com.elvis.login.logueo.models.Categoria;
import com.elvis.login.logueo.models.Producto;
import jakarta.servlet.annotation.WebServlet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositoryJdbcImplement implements Repositorys<Producto>{

    private Connection conn;

    public ProductoRepositoryJdbcImplement(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Producto> listar() throws SQLException {
        List<Producto> productos = new ArrayList<>();

        // crea la coneccion y genera la consulta
        try (Statement smt = conn.createStatement();
             ResultSet rs = smt.executeQuery("SELECT articulo.idcategoria,articulo.idarticulo,articulo.nombre,articulo.stock,articulo.descripcion,articulo.precio,categoria.condicion, categoria.nombre AS nombre_categoria FROM articulo INNER JOIN categoria ON articulo.idcategoria = categoria.idcategoria;")) {
            // el next trae los datos
            // mediante una condiacion rteferenter a la consulta que estoy realizando

            while (rs.next()) {
                Producto p = getProducto(rs);
                productos.add(p);
            }

        }
        return productos;

    }

    @Override
    public Producto porId(Integer id) throws SQLException {
        Producto producto = null;
        try (PreparedStatement smt = conn.prepareStatement("SELECT p.*, c.nombre as nombre_categoria FROM articulo as p inner join categoria as c ON(p.idcategoria=c.idcategoria) WHERE p.idarticulo=?")) {
            smt.setInt(1, id);
            try (ResultSet rs = smt.executeQuery()) {
                if (rs.next()) {
                    producto = getProducto(rs);
                }
            }

        }
        return producto;
    }

    @Override
    public void guardar(Producto producto) throws SQLException {
        String sql;
        if(producto.getIdProducto()!= null && producto.getIdProducto()>0){
            sql = "UPDATE producto SET nombre=?, categoria=?,descripcion=?,precio=? WHERE idarticulo = ?;";
        }else{
            sql = "INSERT INTO producto (nombre,categoria,descripcion,precio,condicion) VALUES (?,?,?,?,?,1);";
        }
        try(PreparedStatement smt = conn.prepareStatement(sql)){
            smt.setString(1, producto.getNombre());
            smt.setInt(2, producto.getCategoria().getIdCategoria());
            smt.setString(3, producto.getDescripcion());
            smt.setDouble(4, producto.getPrecio());
            if(producto.getIdProducto()!=null && producto.getIdProducto()>0){
                smt.setInt(5, producto.getIdProducto());
            }
            smt.executeUpdate();
        }
    }

    @Override
    public void eliminar(Integer id) throws SQLException {
        String sql="DELETE FROM producto WHERE idarticulo = ?;";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }

    }

    @Override
    public Producto activar(Integer id) throws SQLException {
        return null;
    }

    @Override
    public Producto desactivar(Integer id) throws SQLException {
        return null;
    }

    private static Producto getProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setIdProducto(rs.getInt("idarticulo"));
        p.setNombre(rs.getString("nombre"));
        p.setDescripcion(rs.getString("descripcion"));
        p.setPrecio(rs.getDouble("precio"));
        Categoria c= new Categoria();
        c.setIdCategoria(rs.getInt("idcategoria"));
        c.setNombre(rs.getString("nombre_categoria"));
        p.setCategoria(c);
        return p;
    }
}
