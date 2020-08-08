package com.mycompany.compraverymaven.dao;

import com.mycompany.compraverymaven.dto.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface DaoConsumidor {

    default public Consumidor login(String usuario, String password) {
        throw new UnsupportedOperationException("No implementado");
    }

    default public ArrayList<Producto> Listar_Productos() {
        throw new UnsupportedOperationException("No implementado");
    }

    default public ArrayList<Producto> Buscar_Productos(String nombreProducto) {
        throw new UnsupportedOperationException("No implementado");
    }

    default public String getMessage() {
        throw new UnsupportedOperationException("No implementado");
    }

    default List<ProductoInventario> BuscarProducto(String nombre) {
        throw new UnsupportedOperationException("No implementado");
    }

    default ProductoInventario verProducto(Integer posicion) {
        throw new UnsupportedOperationException("No implementado");
    }

//Controlador
    default void agregarProductoCarrito(Integer id, String nombre, Integer cantidad, Double precio) {
        throw new UnsupportedOperationException("No implementado");
    }

//Metodo_InsertOrdenCompra
    default Integer generarOrdenCompra(Integer id_consumidor, LocalDate fecha_compra, Double ImporteTotal) {
        throw new UnsupportedOperationException("No implementado");
    }

//Metodo_DetallePedido//MetodoUpdate
    default void generarPedido(Integer id_ProductoInventario, Integer id_ordenCompra, String nombre_producto, Integer cantidad, Oferta precio) {
        throw new UnsupportedOperationException("No implementado");
    }

    default String historialCompra(LocalDate fech_init, LocalDate fech_fin, Integer id) {
        throw new UnsupportedOperationException("No implementado");
    }

    default Consumidor cambiarClave(Persona usuario, String clave, String newclave) {
        throw new UnsupportedOperationException("No implementado");
    }

    default Void registrarConsumidor(Consumidor consumidor) {
        throw new UnsupportedOperationException("No implementado");
    }

    default List<OrdenCompraConsumidor> verordenesconsumidor(Integer id, LocalDate fecha1, LocalDate fecha2) {
        throw new UnsupportedOperationException("No implementado");
    }

}
