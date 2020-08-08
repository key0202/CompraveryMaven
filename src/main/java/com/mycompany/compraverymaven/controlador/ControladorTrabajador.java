package com.mycompany.compraverymaven.controlador;

import com.mycompany.compraverymaven.biblioteca.Funciones;
import com.mycompany.compraverymaven.vista.*;
import com.mycompany.compraverymaven.dao.*;
import com.mycompany.compraverymaven.dto.ComprasTiendaProveedor;
import com.mycompany.compraverymaven.dto.Producto;
import com.mycompany.compraverymaven.dto.Proveedor;
import com.mycompany.compraverymaven.dto.Trabajador;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class ControladorTrabajador {

    private final DaoConsumidor daoconsumidor;
    private final DaoTrabajador daotrabajador;
    private final Admin_Menu admin_menu;
    private final Admin_Login admin_login;

    private Trabajador trabajador = null;
    private Integer cantidadProveedor;
    private Integer cantidadCategoria;

    private Integer cantidadProductoProveedor;

    private final SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");

    //private Integer cantidadCargos;
    DefaultTableModel modelillos = new DefaultTableModel();

    //instanciando la clase de funciones
    Funciones fn = new Funciones();

    //private Integer cantidadCargos;
    private final Admin_Menu_Almacen admin_menu_almacen = new Admin_Menu_Almacen();
    private final Admin_Menu_AtencionPedido admin_menu_atencionpedido = new Admin_Menu_AtencionPedido();
    private final Admin_Menu_ComprasEstado admin_menu_comprasestado = new Admin_Menu_ComprasEstado();
    private final Admin_Menu_Empleados admin_menu_empleados = new Admin_Menu_Empleados();
    private final Admin_Menu_OfertasPrecios admin_menu_ofertasprecios = new Admin_Menu_OfertasPrecios();
    private final Admin_Menu_Perfil admin_menu_perfil = new Admin_Menu_Perfil();
    private final Admin_Menu_Proveedores admin_menu_proveedores = new Admin_Menu_Proveedores();
    private final Admin_Menu_Proveedores_Compras admin_menu_proveedores_compras = new Admin_Menu_Proveedores_Compras();
    private final Admin_Menu_Ventas admin_menu_ventas = new Admin_Menu_Ventas();
    private final Admin_Anadir_Empleados admin_anadir_empleados = new Admin_Anadir_Empleados();
    private final Admin_Anadir_Productos admin_anadir_productos = new Admin_Anadir_Productos();
    private final Admin_Anadir_Proveedores admin_anadir_proveedores = new Admin_Anadir_Proveedores();

    public ControladorTrabajador(DaoConsumidor daoconsumidor, DaoTrabajador daotrabajador, Admin_Menu admin_menu, Admin_Login admin_login) {
        this.daoconsumidor = daoconsumidor;
        this.daotrabajador = daotrabajador;
        this.admin_menu = admin_menu;
        this.admin_login = admin_login;
        InitView();
    }

    private void InitView() {
        admin_login.setVisible(true);
    }

    public void InitController() {

        admin_anadir_empleados.getBtnAgregar().addActionListener(e -> anadir("empleados"));
        admin_anadir_empleados.getBtnRegresar().addActionListener(e -> regresar("empleados"));

        admin_anadir_productos.getBtnRegresar().addActionListener(e -> regresar("producto"));
        admin_anadir_productos.getBtnAgregar().addActionListener(e -> anadir("producto"));
        admin_anadir_productos.getBtnImagen().addActionListener(e -> cargarimagen());

        admin_anadir_proveedores.getBtnAgregar().addActionListener(e -> anadir("proveedores"));
        admin_anadir_proveedores.getBtnRegresar().addActionListener(e -> regresar("proveedores"));

        admin_login.getBtnIniciarSesion().addActionListener(e -> login());

        admin_menu.getBtnAlmacen().addActionListener(e -> abrir_internal("almacen"));
        admin_menu.getBtnPedidosCliente().addActionListener(e -> abrir_internal("pedidos"));
        admin_menu.getBtnCompras().addActionListener(e -> abrir_internal("compras"));
        admin_menu.getBtnEmpleados().addActionListener(e -> abrir_internal("empleados"));
        admin_menu.getBtnOfertas().addActionListener(e -> abrir_internal("ofertas"));
        admin_menu.getBtnPerfil().addActionListener(e -> abrir_internal("perfil"));
        admin_menu.getBtnProveedores().addActionListener(e -> abrir_internal("proveedores"));
        admin_menu.getBtnVentas().addActionListener(e -> abrir_internal("ventas"));
        admin_menu.getBtnProductos().addActionListener(e -> abrir_internal("productos"));

        admin_menu_almacen.getBtnBuscar().addActionListener(e -> buscarproducto());
        admin_menu_almacen.getBtnGenerarReporte().addActionListener(e -> reporteexcel("almacen"));

        admin_menu_atencionpedido.getBtnImprimir().addActionListener(e -> reportepdf("pedidos"));

        admin_menu_comprasestado.getBtnImprimir().addActionListener(e -> reporteexcel("comprasestado"));

        admin_menu_comprasestado.getCmbEstadoPedido().addActionListener(e -> comboconsulta("mis_compras"));

        admin_menu_empleados.getBtnAgregarEmpleado().addActionListener(e -> abrir_frame("anadirempleado"));
        admin_menu_empleados.getBtnExportarExcel().addActionListener(e -> reportepdf("empleados"));
        admin_menu_empleados.getCmbCargoEmpleado().addItemListener(e -> comboconsulta("empleados"));
        admin_menu_proveedores.getCmbCategoria().addActionListener(e -> comboconsulta("proveedores"));

        admin_menu_ofertasprecios.getBtnGuardar().addActionListener(e -> actualizar("producto"));
        admin_menu_ofertasprecios.getBtnGuardarOferta().addActionListener(e -> guardaroferta());

        admin_menu_proveedores.getBtnAgregarProovedor().addActionListener(e -> abrir_frame("anadirproveedor"));
        admin_menu_proveedores.getjMenuProductosProveedor().addActionListener(e -> abrir_internal("ordencompra"));

        admin_menu_proveedores_compras.getBtnAgregar().addActionListener(e -> agregarproductoAtabla());
        admin_menu_proveedores_compras.getBtnComprar().addActionListener(e -> comprarproductos());
        admin_menu_proveedores_compras.getBtnImprimir().addActionListener(e -> reportepdf("ordencompra"));

        admin_menu_proveedores_compras.getCmbCategoria().addActionListener(e -> comboconsulta("productos"));
        admin_menu_proveedores_compras.getBtnImporte().addActionListener(e -> ImporteCalculado());

        admin_menu_ventas.getBtnGenerarResumen().addActionListener(e -> reporteexcel("ventas"));

    }

    //Codigo Abel:
    private void comboconsulta(String opcion) {

        switch (opcion) {
            case "empleados":

                if (admin_menu_empleados.getCmbCargoEmpleado().getSelectedIndex() == 0) {
                    limpiar_tabla(opcion);
                } else {
                    cargar_tabla(opcion);
                }

                break;

            case "proveedores":

                if (admin_menu_proveedores.getCmbCategoria().getSelectedIndex() == 0) {
                    limpiar_tabla(opcion);
                } else {
                    cargar_tabla(opcion);
                }

                break;

            case "productos":

                String prov = (String) admin_menu_proveedores.getTablaProveedores().
                        getModel().getValueAt(admin_menu_proveedores.getTablaProveedores().
                                getSelectedRow(), 0);
                if (admin_menu_proveedores_compras.getCmbCategoria().getSelectedIndex() != 0) {
                    admin_menu_proveedores_compras.getCmbProducto().setSelectedIndex(0);
                    admin_menu_proveedores_compras.getCmbProducto().setEnabled(true);
                    String categoSeleccion = admin_menu_proveedores_compras.getCmbCategoria().getSelectedItem().toString();
                    List<Producto> productos = daotrabajador.Cargar_producto_catego_proveedor(prov, categoSeleccion);
                    cantidadProductoProveedor = productos.size();

                    for (int i = 0; i < cantidadProductoProveedor; i++) {
                        admin_menu_proveedores_compras.getCmbProducto().addItem(productos.get(i).getNombre());
                    }

                    admin_menu_proveedores_compras.getBtnAgregar().setEnabled(true);
                }

                break;

            case "mis_compras":
                if (admin_menu_comprasestado.getCmbEstadoPedido().getSelectedIndex() == 0) {
                    limpiar_tabla(opcion);
                } else {
                    cargar_tabla(opcion);
                }

            case "asistencias":
//                for (int i = 0; i <= cantidad_salones; i++) {
//                    if (listita.getCmbSalon().getSelectedIndex() == 0) {
//                        listita.getBtnExportar().setEnabled(false);
//                    } else {
//                                               
//                        listita.getBtnExportar().setEnabled(true);
//                        cargar_tabla(ventana);
//                    }
//                }

                break;
            default:
                break;
        }

    }

    private void login() {
        //logeo del administrador
        String nick = admin_login.getTxtUsuario().getText();
        String clave = admin_login.getTxt_password().getText();
        try {
            trabajador = daotrabajador.login(nick, clave);
            if (trabajador != null) {
                admin_login.dispose();
                inicio_total();
                cargarFrame(admin_menu_perfil, admin_menu.getJdpContenedor());
                admin_menu.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, daotrabajador.getMessage(), "ERROR",
                        JOptionPane.WARNING_MESSAGE);
                admin_login.getTxt_password().setText("");
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "INTENTE NUEVAMENTE", "ERROR DE LOGIN",
                    JOptionPane.ERROR_MESSAGE);

        }

    }

    private void inicio_total() {
        admin_menu_perfil.getLblDatos().setText(trabajador.getNombre());
        admin_menu_perfil.getLblDireccion().setText(trabajador.getDireccion());
        admin_menu_perfil.getLblDni().setText(trabajador.getDni());
        admin_menu_perfil.getLblCelular().setText(trabajador.getCelular());
        admin_menu_perfil.getLblCargo().setText(trabajador.getCargo());

        //cargando los comboBox con los proveedores:
        String opcion = "Seleccione un proveedor";
        admin_anadir_productos.getCmbProveedor().removeAll();
        admin_anadir_productos.getCmbProveedor().addItem(opcion);

        List<Proveedor> prove = daotrabajador.Cargar_comboProveedores();
        cantidadProveedor = prove.size();
        for (int i = 0; i < cantidadProveedor; i++) {
            // admin_anadir_productos.getCmbProveedor().addItem(String.valueOf(prove.get(i)));
            admin_anadir_productos.getCmbProveedor().addItem(prove.get(i).getRazonsocial());
        }

        //cargando los comboBox de categoriaProductos:
        String catego = "Seleccione una categoria";
        admin_menu_proveedores.getCmbCategoria().removeAll();
        admin_menu_ventas.getCmbCategoria().removeAll();
        admin_menu_ofertasprecios.getCmbCategoria().removeAll();
        admin_menu_proveedores.getCmbCategoria().addItem(catego);
        admin_menu_ventas.getCmbCategoria().addItem(catego);
        admin_menu_ofertasprecios.getCmbCategoria().addItem(catego);

        List<Producto> produc = daotrabajador.Cargar_categoriaProducto();
        cantidadCategoria = produc.size();
        for (int i = 0; i < cantidadCategoria; i++) {
            admin_menu_proveedores.getCmbCategoria().addItem(produc.get(i).getCategoria());
            admin_menu_ventas.getCmbCategoria().addItem(produc.get(i).getCategoria());
            admin_menu_ofertasprecios.getCmbCategoria().addItem(produc.get(i).getCategoria());
        }

        //Agregar columna a la tabla menu_compras_admin:
        modelillos.addColumn("Producto");
        modelillos.addColumn("Cantidad");
        modelillos.addColumn("Precio c/u");
        modelillos.addColumn("importe");
        admin_menu_proveedores_compras.getTablaProductosCompras().setModel(modelillos);

        //Agregar columnas a la tabla menu_comprasEstado:
        DefaultTableModel modelilla = new DefaultTableModel();
        modelilla.addColumn("N°Orden Compra");
        modelilla.addColumn("Proveedor");
        modelilla.addColumn("Fecha Pedido");
        modelilla.addColumn("Fecha Entrada");
        admin_menu_comprasestado.getTablaComprasEstado().setModel(modelilla);

    }

    private void anadir(String opcion) {
        //crear un nuevo registro
        switch (opcion) {
            case "empleados":
                Trabajador registrar_empleados = new Trabajador();

                registrar_empleados.setNombre(admin_anadir_empleados.getTxtApellidos().getText());
                registrar_empleados.setDni(admin_anadir_empleados.getTxtDNI().getText());
                registrar_empleados.setDireccion(admin_anadir_empleados.getTxtDireccion().getText());
                registrar_empleados.setCelular(admin_anadir_empleados.getTxtCelular().getText());
                registrar_empleados.setCargo(admin_anadir_empleados.getTxtCargo().getText());
                SimpleDateFormat fechazaI = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat fechazaF = new SimpleDateFormat("yyyy-MM-dd");
                String fecha1 = fechazaI.format(admin_anadir_empleados.getFechaInicio().getDate());
                String fecha2 = fechazaF.format(admin_anadir_empleados.getFechaFinal().getDate());
                registrar_empleados.setFecha_ingreso(LocalDate.parse(fecha1));
                registrar_empleados.setFecha_cese(LocalDate.parse(fecha2));

                JOptionPane.showMessageDialog(null, "Empleado registrado correctamente");
                daotrabajador.registrar_empleado(registrar_empleados);

                admin_anadir_empleados.getTxtApellidos().setText("");
                admin_anadir_empleados.getTxtDNI().setText("");
                admin_anadir_empleados.getTxtDireccion().setText("");
                admin_anadir_empleados.getTxtCelular().setText("");
                admin_anadir_empleados.getTxtCargo().setText("");
                admin_anadir_empleados.getFechaInicio().setDate(Date.valueOf(LocalDate.now()));
                admin_anadir_empleados.getFechaFinal().setDate(Date.valueOf(LocalDate.now()));

                System.out.println(registrar_empleados.toString());

                break;
            case "producto":
                Producto producto_nuevo = new Producto();

                producto_nuevo.setNombre(admin_anadir_productos.getTxtNombreProducto().getText());
                producto_nuevo.setDescripcion(admin_anadir_productos.getTxaDescripcion().getText());
                producto_nuevo.setProveedor(admin_anadir_productos.getCmbProveedor().getSelectedItem().toString());

                producto_nuevo.setCategoria(admin_anadir_productos.getCmbCategoria().getSelectedItem().toString());

                File ruta = new File(admin_anadir_productos.getTxtruta().getText());

                try {

                    byte[] icono = new byte[(int) ruta.length()];
                    InputStream input = new FileInputStream(ruta);
                    input.read(icono);
                    producto_nuevo.setImagen(icono);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "No se ha guardado la imagen");
                }
                JOptionPane.showMessageDialog(null, "Producto registrado correctamente");
                daotrabajador.registrar_producto(producto_nuevo);
                //borrando los datos para el proximo ingreso:
                admin_anadir_productos.getTxtNombreProducto().setText("");
                admin_anadir_productos.getTxaDescripcion().setText("");
                admin_anadir_productos.getCmbProveedor().setSelectedIndex(0);
                admin_anadir_productos.getCmbCategoria().setSelectedIndex(0);
                admin_anadir_productos.getTxtruta().setText("");
                admin_anadir_productos.getLblImagen().setText("");

                break;
            case "proveedores":
                Proveedor proveedorcito = new Proveedor();
                proveedorcito.setRazonsocial(admin_anadir_proveedores.getTxtRazonSocial().getText());
                proveedorcito.setDireccion(admin_anadir_proveedores.getTxtDireccion().getText());
                proveedorcito.setTelefono(admin_anadir_proveedores.getTxtTelefono().getText());
                proveedorcito.setCorreo(admin_anadir_proveedores.getTxtCorreo().getText());
                proveedorcito.setRuc(admin_anadir_proveedores.getTxtRUC().getText());

                JOptionPane.showMessageDialog(null, "Proveedor registrado correctamente");
                daotrabajador.registrar_proveedor(proveedorcito);

                admin_anadir_proveedores.getTxtRazonSocial().setText("");
                admin_anadir_proveedores.getTxtDireccion().setText("");
                admin_anadir_proveedores.getTxtTelefono().setText("");
                admin_anadir_proveedores.getTxtCorreo().setText("");
                admin_anadir_proveedores.getTxtRUC().setText("");

                break;
            default:
                throw new AssertionError();
        }

    }

    private void regresar(String opcion) {
        //todos los que usen este metodo van a retornar al menu principal
        switch (opcion) {
            case "empleados":
                admin_anadir_empleados.dispose();

                break;
            case "producto":
                admin_anadir_productos.dispose();

                break;
            case "proveedores":
                admin_anadir_proveedores.dispose();

                break;
            default:
                throw new AssertionError();
        }

    }

    private void cargarimagen() {
        //asignar una imagen para el producto
        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        j.setFileFilter(fil);

        int s = j.showOpenDialog(admin_anadir_productos);
        if (s == JFileChooser.APPROVE_OPTION) {
            String ruta = j.getSelectedFile().getAbsolutePath();
            admin_anadir_productos.getTxtruta().setText(ruta);
            admin_anadir_productos.getLblImagen().setIcon(new ImageIcon(ruta));
        }

    }

    private void cargar_tabla(String opcion) {
        switch (opcion) {
            case "empleados":
                String cargo = admin_menu_empleados.getCmbCargoEmpleado().getSelectedItem().toString();
                List<Trabajador> trab = daotrabajador.listar_trabajadores(cargo);
                DefaultTableModel modelo_local = (DefaultTableModel) admin_menu_empleados.getTablaEmpleados().getModel();
                modelo_local.setNumRows(0);
                trab.forEach((i) -> {
                    modelo_local.addRow(new Object[]{
                        i.getNombre(),
                        i.getDni(),
                        i.getCelular(),
                        i.getDireccion(),
                        i.getFecha_ingreso(),
                        i.getFecha_cese()
                    });
                });
                break;
            case "proveedores":

                String catego = admin_menu_proveedores.getCmbCategoria().getSelectedItem().toString();
                List<Proveedor> traba2 = daotrabajador.mostrar_proveedores(catego);

                DefaultTableModel modelo_local2 = (DefaultTableModel) admin_menu_proveedores.getTablaProveedores().getModel();
                modelo_local2.setNumRows(0);
                traba2.forEach((i) -> {
                    modelo_local2.addRow(new Object[]{
                        i.getRazonsocial(),
                        i.getRuc(),
                        i.getDireccion(),
                        i.getTelefono(),
                        i.getCorreo()
                    });
                });

                break;

            case "mis_compras":
                String estd = admin_menu_comprasestado.getCmbEstadoPedido().getSelectedItem().toString();
                List<ComprasTiendaProveedor> resolviendo = daotrabajador.ver_estado_orden_compra(estd);

                DefaultTableModel model_local3 = (DefaultTableModel) admin_menu_comprasestado.getTablaComprasEstado().getModel();
                model_local3.setNumRows(0);
                resolviendo.forEach((i) -> {
                    model_local3.addRow(new Object[]{
                        i.getId(),
                        i.getProveedor(),
                        i.getFecha_compra(),
                        i.getFecha_ingresar()
                    });
                });

                break;
            default:
                throw new AssertionError();
        }

    }

    private void limpiar_tabla(String opcion) {
        DefaultTableModel modelillo = new DefaultTableModel();
        while (modelillo.getRowCount() > 0) {
            modelillo.removeRow(0);
        }

        switch (opcion) {
            case "empleados":
                modelillo.addColumn("Nombre y Apellidos");
                modelillo.addColumn("DNI");
                modelillo.addColumn("Celular");
                modelillo.addColumn("Direccion");
                modelillo.addColumn("Fecha_ingreso");
                modelillo.addColumn("Fecha_cese");

                admin_menu_empleados.getTablaEmpleados().setModel(modelillo);

                break;
            case "proveedores":
                modelillo.addColumn("Razon Social");
                modelillo.addColumn("RUC");
                modelillo.addColumn("Direccion");
                modelillo.addColumn("Telefono");
                modelillo.addColumn("Correo");
                admin_menu_proveedores.getTablaProveedores().setModel(modelillo);

                break;

            case "mis_compras":
                modelillo.addColumn("N°Orden Compra");
                modelillo.addColumn("Proveedor");
                modelillo.addColumn("Fecha Pedido");
                modelillo.addColumn("Fecha Entrada");
                admin_menu_comprasestado.getTablaComprasEstado().setModel(modelillo);

                break;
            default:
                throw new AssertionError();
        }

    }

    private void abrir_internal(String opcion) {
        //cargar los internalframe segun la opcion
        switch (opcion) {
            case "almacen":

                break;
            case "pedidos":

                break;
            case "compras":

                cargarFrame(admin_menu_comprasestado, admin_menu.getJdpContenedor());
                admin_menu_comprasestado.setVisible(true);

                break;
            case "empleados":
                cargarFrame(admin_menu_empleados, admin_menu.getJdpContenedor());

                break;
            case "ofertas":

                break;
            case "perfil":

                break;

            case "proveedores":
                cargarFrame(admin_menu_proveedores, admin_menu.getJdpContenedor());

                admin_menu_proveedores.setVisible(true);

                break;
            case "ventas":

                break;
            case "productos":

                admin_anadir_productos.setVisible(true);

                break;

            case "ordencompra":

                try {
                    String catego = "Seleccione una categoria";
                    admin_menu_proveedores_compras.getCmbCategoria().removeAllItems();
                    admin_menu_proveedores_compras.getCmbCategoria().addItem(catego);

                    Integer orden = daotrabajador.ordencompramasuno();
                    String prov = (String) admin_menu_proveedores.getTablaProveedores().
                            getModel().getValueAt(admin_menu_proveedores.getTablaProveedores().
                                    getSelectedRow(), 0);
                    System.out.println(LocalDate.now().toString());

                    String ruc = (String) admin_menu_proveedores.getTablaProveedores().
                            getModel().getValueAt(admin_menu_proveedores.getTablaProveedores().
                                    getSelectedRow(), 1);

                    //Visualizar en un nuevo frame los datos elegidos por medio del popup menu
                    cargarFrame(admin_menu_proveedores_compras, admin_menu.getJdpContenedor());

                    obtenerFecha();

                    //Para cargar el comboBox con las categorias de producto:
                    List<Producto> produc = daotrabajador.Cargar_categorias_Proveedor(prov);
                    cantidadCategoria = produc.size();
                    for (int i = 0; i < cantidadCategoria; i++) {

                        admin_menu_proveedores_compras.getCmbCategoria().addItem(produc.get(i).getCategoria());
                    }
                    String produC = "Seleccione un producto";
                    admin_menu_proveedores_compras.getCmbProducto().removeAllItems();
                    admin_menu_proveedores_compras.getCmbProducto().addItem(produC);
                    admin_menu_proveedores_compras.getCmbProducto().setEnabled(false);

                    admin_menu_proveedores_compras.getTxtNumeroOrdenCompra().setText(orden.toString());
                    admin_menu_proveedores_compras.getTxtProveedor().setText(prov);
                    //  admin_menu_proveedores_compras.getTxtFechaCompra().setText(fecha_compra);
                    admin_menu_proveedores_compras.getTxtRUC().setText(ruc);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                break;
            default:
                throw new AssertionError();
        }

    }

    //Metodo para cargar la fecha en el frame de menu_proveedores_compra
    private void obtenerFecha() {
        LocalDate myObj = LocalDate.now();
        admin_menu_proveedores_compras.getLbFechaActual().setText(String.valueOf(myObj));
        //      listita.getjXFechaza().setDate(Date.valueOf(LocalDate.now()));
        admin_menu_proveedores_compras.getjXFechaActual().setDate(Date.valueOf(LocalDate.now()));

    }

    private void abrir_frame(String opcion) {
        //carga los frame segun la opcion
        switch (opcion) {
            case "anadirempleado":

                admin_anadir_empleados.setVisible(true);

                break;
            case "anadirproducto":

                break;
            case "anadirproveedor":
                admin_anadir_proveedores.setVisible(true);

                break;
            default:
                throw new AssertionError();
        }

    }

    private void buscarproducto() {
        //busca productos para tabla segun operacion, categoria, fechas inicial y final

    }

    private void reporteexcel(String opcion) {
        //genera un excel segun la tabla enviada

        switch (opcion) {
            case "almacen":

                break;
            case "comprasestado":

                break;
            case "ventas":

                break;
            case "empleados":
                fn.exportarexcel(admin_menu_empleados.getTablaEmpleados());
                InputStream plantilla = Ejecutable_Trabajador.class.getClassLoader().getResourceAsStream("informes/empleados.jrxml");
                fn.exportarpdf(plantilla);

                break;
            default:
                throw new AssertionError();
        }
    }

    private void reportepdf(String opcion) {
        //genera un reporte en pdf
        switch (opcion) {
            case "empleados":
                fn.exportarpdf2(admin_menu_empleados.getTablaEmpleados());

                break;
            case "ordencompra":
                String norden = admin_menu_proveedores_compras.getTxtNumeroOrdenCompra().getText();
                String proveedor = admin_menu_proveedores_compras.getTxtProveedor().getText();
                String fcompra = admin_menu_proveedores_compras.getLbFechaActual().getText();
                String ruc = admin_menu_proveedores_compras.getTxtRUC().getText();
                String producto = "";
                String cantidad = "";
                String preciocu = "";
                String importe = "";
                String total = admin_menu_proveedores_compras.getTxtTotal().getText();

                fn.exportarpdf3(admin_menu_proveedores_compras.getTablaProductosCompras(),
                        norden,proveedor,fcompra,ruc,total);

                break;
            default:
                throw new AssertionError();
        }
    }

    private void actualizar(String opcion) {
        //actualizar los registros seleccionados segun las tablas
        switch (opcion) {
            case "producto":

                break;
            default:
                throw new AssertionError();
        }

    }

    private void guardaroferta() {
        //guarda la oferta segun producto seleccionado

    }

    private void agregarproductoAtabla() {
        String producto = admin_menu_proveedores_compras.getCmbProducto().getSelectedItem().toString();

        String llenado[] = new String[1];

        llenado[0] = producto;
        modelillos.addRow(llenado);

    }

    private void ImporteCalculado() {
        double acumulador = 0;

        int filas = admin_menu_proveedores_compras.getTablaProductosCompras().getRowCount();
        for (int i = 0; i < filas; i++) {
            String impor = String.valueOf(admin_menu_proveedores_compras.getTablaProductosCompras().getValueAt(i, 3));
            acumulador += Double.parseDouble(impor);
        }
        admin_menu_proveedores_compras.getTxtTotal().setText(String.valueOf(acumulador));
    }

    private void comprarproductos() {
        //cambia estado de orden de compra y traspasa cada detalle hacia productoinventario
        ComprasTiendaProveedor compritas = new ComprasTiendaProveedor();
        String ruc = admin_menu_proveedores_compras.getTxtRUC().getText();
        SimpleDateFormat fechazaF = new SimpleDateFormat("yyyy-MM-dd");
        String fecha2 = fechazaF.format(admin_menu_proveedores_compras.getjXFechaActual().getDate());
        compritas.setFecha_compra(LocalDate.parse(fecha2));
        Double importe = Double.parseDouble(admin_menu_proveedores_compras.getTxtTotal().getText());
        daotrabajador.generar_compra_proveedor(ruc, compritas, importe);

        //Para grabar los detalles de la orden de compra
        int num_orden_compr = Integer.parseInt(admin_menu_proveedores_compras.getTxtNumeroOrdenCompra().getText());
        int NumeFilas = admin_menu_proveedores_compras.getTablaProductosCompras().getRowCount();

        for (int i = 0; i < NumeFilas; i++) {
            Producto producto = new Producto();
            producto.setNombre(admin_menu_proveedores_compras.getTablaProductosCompras().getValueAt(i, 0).toString());
            Integer cantidad = Integer.parseInt(admin_menu_proveedores_compras.getTablaProductosCompras().getValueAt(i, 1).toString());
            Double preciouni = Double.parseDouble(admin_menu_proveedores_compras.getTablaProductosCompras().getValueAt(i, 2).toString());
            daotrabajador.detalle_orden_compra(num_orden_compr, producto, cantidad, preciouni);
        }
        JOptionPane.showMessageDialog(null, "Compra realizada correctamente");
        cargarFrame(admin_menu_comprasestado, admin_menu.getJdpContenedor());

    }

    private void cargarFrame(JInternalFrame frame, JDesktopPane jdp) {
        jdp.removeAll();
        jdp.add(frame);
        BasicInternalFrameUI bi = (BasicInternalFrameUI) frame.getUI();
        bi.setNorthPane(null);
        try {
            frame.setMaximum(true);
        } catch (PropertyVetoException e) {
        };
        Dimension contenedor = jdp.getSize();
        Dimension contenido = frame.getSize();
        frame.setLocation(
                (contenedor.width - contenido.width) / 2,
                (contenedor.height - contenido.height) / 2);
        frame.show();
    }

}
