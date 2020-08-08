package com.mycompany.compraverymaven.dao;

import com.mycompany.compraverymaven.dto.*;
import java.time.LocalDate;
import java.util.List;

public interface DaoTrabajador {

    public Trabajador login(String user, String pass);

    default List<DetalleOrdenProducto> verCompraProveedor(ComprasTiendaProveedor id) {
        throw new UnsupportedOperationException("No implementado");
    }

    default void confirmarCompra(ComprasTiendaProveedor id) {
        throw new UnsupportedOperationException("No implementado");
    }

    default void registrar_proveedor(Proveedor proveedor) {
        throw new UnsupportedOperationException("No implementado");
    }

    default String registrar_empleado(Trabajador trabajador) {
        throw new UnsupportedOperationException("No implementado");
    }

    default void registrar_producto(Producto producto) {
        throw new UnsupportedOperationException("No implementado");
    }

    default List<ComprasTiendaProveedor> ver_estado_orden_compra(String estado) {
        throw new UnsupportedOperationException("No implementado");
    }

    default List<ProductoInventario> ver_movimientos_almacen(String estado, Producto categoria, LocalDate fecha_inicial, LocalDate fecha_final) {
        throw new UnsupportedOperationException("No implementado");
    }

    default List<Proveedor> mostrar_proveedores(String categoria) {
        throw new UnsupportedOperationException("No implementado");
    }

    default List<Producto> ver_categorias_proveedor(Integer id_proveedor) {
        throw new UnsupportedOperationException("No implementado");
    }

    default List<Producto> ver_productos_categoria_proveedor(Integer id_proveedor, Producto categoria) {
        throw new UnsupportedOperationException("No implementado");
    }

    default void generar_compra_proveedor(String ruc, ComprasTiendaProveedor fecha_compra, Double importe) {
        throw new UnsupportedOperationException("No implementado");
    }

    default void detalle_orden_compra(Integer id_compra_proveedor, Producto producto, Integer cantidad, Double precio) {
        throw new UnsupportedOperationException("No implementado");
    }

    default List<Trabajador> listar_trabajadores(String cargo) {
        throw new UnsupportedOperationException("No implementado");
    }

    default List<DetalleCompraConsumidor> resumen_ventas(LocalDate fecha_inicial, LocalDate fecha_final, String categoria) {
        throw new UnsupportedOperationException("No implementado");
    }

    default void fijar_orfertas(Integer id_producto_inventario, LocalDate fecha_inicial, LocalDate fecha_final, Double precio_oferta) {
        throw new UnsupportedOperationException("No implementado");
    }

    default List<DetalleCompraConsumidor> ver_pedidos_clientes() {
        throw new UnsupportedOperationException("No implementado");
    }

    default void asignar_repartidor(Integer id_pedido, Integer id_repartidor) {
        throw new UnsupportedOperationException("No implementado");
    }

    default public String getMessage() {
        throw new UnsupportedOperationException("No implementado");

    }

    default List<Proveedor> Cargar_comboProveedores() {
        throw new UnsupportedOperationException("No implementado");
    }

    default List<Producto> Cargar_categoriaProducto() {
        throw new UnsupportedOperationException("No implementado");
    }

    default List<Producto> Cargar_categorias_Proveedor(String proveedor) {
        throw new UnsupportedOperationException("No implementado");
    }

    default List<Producto> Cargar_producto_catego_proveedor(String proveedor, String categoria) {
        throw new UnsupportedOperationException("No implementado");
    }

    default Integer ordencompramasuno() {
        throw new UnsupportedOperationException("No implementado");
    }

    default void actualizarEstado(Integer id_ordenCompra) {

    }

    default List<ProductoInventario> productoCompra_buscar(Integer id) {
        throw new UnsupportedOperationException("No implementado");
    }

    default void grabar_productos_inventario(ProductoInventario datos) {
        throw new UnsupportedOperationException("No implementado");
    }

    default List<OrdenCompraConsumidor> verordenespendientes() {
        throw new UnsupportedOperationException("No implementado");
    }

    default List<DetalleCompraConsumidor> verdetallesconsumidor(Integer idorden) {
        throw new UnsupportedOperationException("No implementado");
    }
}
