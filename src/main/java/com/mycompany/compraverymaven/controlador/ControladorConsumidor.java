package com.mycompany.compraverymaven.controlador;

import com.mycompany.compraverymaven.biblioteca.formatoTablaListarProductos;
import com.mycompany.compraverymaven.vista.*;
import com.mycompany.compraverymaven.dao.*;
import com.mycompany.compraverymaven.dto.Consumidor;
import com.mycompany.compraverymaven.dto.Producto;
import com.sun.org.glassfish.external.probe.provider.annotations.Probe;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class ControladorConsumidor {

    //DAO PRINCIPALES
    private final DaoConsumidor daoconsumidor;
    private final DaoTrabajador daotrabajador;
    private final Consumidor_Menu consumidor_menu;
    private final Consumidor_Login consumidor_login;

    //DTOS PARA EL MANEJO DE DATOS
    private Consumidor consumidor = null;
    private Producto producto = null;

    private List<Integer> listaIdProductoInv = new ArrayList<>();

    //  private List< Producto> ListaProductosElegidos
    //variable global Id_orden_compra_consumidor
    private List< Producto> ListaProductosElegidos = new ArrayList<>();

    public static int idOrdenCom = 0;

    //VISTAS DE LOS INTERNAL FRAMES
    private final Consumidor_BusquedaSeleccionProducto consumidor_BusquedaSeleccionProducto = new Consumidor_BusquedaSeleccionProducto();
    private final Consumidor_DetallePedidos consumidor_detallePedidos = new Consumidor_DetallePedidos();
    private final Consumidor_HistorialPedidos consumidor_historialpedidos = new Consumidor_HistorialPedidos();
    private final Consumidor_Perfil consumidor_perfil = new Consumidor_Perfil();

    public ControladorConsumidor(DaoConsumidor daoconsumidor, DaoTrabajador daotrabajador, Consumidor_Menu consumidor_menu, Consumidor_Login consumidor_login) {
        this.daoconsumidor = daoconsumidor;
        this.daotrabajador = daotrabajador;
        this.consumidor_menu = consumidor_menu;
        this.consumidor_login = consumidor_login;
        this.idOrdenCom = daoconsumidor.obtenerUltimoId();
        InitView();

    }

    //  INICIAR EL LOGIN
    private void InitView() {
        consumidor_login.setVisible(true);
    }

    //METODOS DE LOS COMPONENTES COMO BOTONES DE LAS VISTAS 
    public void InitController() {

        //Metodo de login
        consumidor_login.getBtnIngresar().addActionListener(e -> login());

        //BOTONES DEL MENU PRINCIPAL
        consumidor_menu.getBtnPerfil().addActionListener(e -> mostrarPerfil());
        consumidor_menu.getBtnProductos().addActionListener(e -> mostarProductos());
        consumidor_menu.getBtnCarrito().addActionListener(e -> mostrarCarrito());
        consumidor_menu.getBtnHistorialPedidos().addActionListener(e -> mostrarHistorial());

        //BOTONES DEL LA VISTA Consumidor_BusquedaSeleccionProducto
        consumidor_BusquedaSeleccionProducto.getBtnBuscarProducto().addActionListener(e -> mostrarProductosBuscados());

        consumidor_BusquedaSeleccionProducto.getTablaProductos().addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                JTable tabla = consumidor_BusquedaSeleccionProducto.getTablaProductos();
                int clic = tabla.rowAtPoint(e.getPoint());

                int producto_inventario = listaIdProductoInv.get(clic);
                System.out.println(producto_inventario);
                int codigo = (int) tabla.getValueAt(clic, 0);
                String nombre = "" + tabla.getValueAt(clic, 1);
                double precio = (double) tabla.getValueAt(clic, 2);
                // String marca = "" + tabla.getValueAt(clic, 3);

                producto = new Producto();
                producto = daoconsumidor.getDatosProducto(producto_inventario);
                System.out.println(producto);

                consumidor_BusquedaSeleccionProducto.getTxtnombre_producto().setText(producto.getNombre());
                consumidor_BusquedaSeleccionProducto.getTxtPrecio().setText(String.valueOf(producto.getPrecio()));
                consumidor_BusquedaSeleccionProducto.getTxtDescripcion().setText(producto.getDescripcion());
                consumidor_BusquedaSeleccionProducto.getTxtPrecioOferta().setText(String.valueOf(producto.getPrecioOferta()));
                consumidor_BusquedaSeleccionProducto.getTxtIdProInv().setText(String.valueOf(producto.getId_pi()));

            }

        });

        consumidor_BusquedaSeleccionProducto.getBtnAgregarCarrito().addActionListener(e -> agregarDetalleProductoConsumidor());

        consumidor_detallePedidos.getBtnGenerarPedido().addActionListener(e -> agregarOrdenCompra());

    }

    //METODO DEL BOTON BTNINGRESAR  LA VISTA LOGIN_CONSUMIDOR 
    public Consumidor login() {
        String usuario = consumidor_login.getTxtUsuario().getText().trim();
        String password = consumidor_login.getTxtPassword().getText().trim();

        try {
            consumidor = daoconsumidor.login(usuario, password);

            if (consumidor != null) {
                consumidor_login.dispose();
                consumidor_menu.setVisible(true);
                inicio_total();
                abrir_internal("perfil");
                System.out.println("promero " + consumidor);
                System.out.println(usuario + " " + password);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario y/o Contraseña incorrecto", "ERROR",
                        JOptionPane.WARNING_MESSAGE);
                System.out.println(daoconsumidor.getMessage());
            }

        } catch (NullPointerException es) {
            JOptionPane.showMessageDialog(null, "INTENTE NUEVAMENTE", "ERROR DE LOGIN",
                    JOptionPane.ERROR_MESSAGE);

        }

        return consumidor;
    }

    //INICIO TOTAL AL PASARL EL LOGIN
    public void inicio_total() {
        consumidor_perfil.getTxtNombre().setText(consumidor.getNombre());
        consumidor_perfil.getTxtDireccion().setText(consumidor.getDireccion());
        consumidor_perfil.getTxtCelular().setText(consumidor.getCelular());
        consumidor_perfil.getTxtDni().setText(consumidor.getDni());

    }

    //  MANEJO DE LOS INTERNAL
    private void abrir_internal(String opcion) {
        //cargar los internalframe segun la opcion
        consumidor_menu.getJdpInterno().removeAll();

        switch (opcion) {
            case "perfil":
                cargarFrame(consumidor_perfil, consumidor_menu.getJdpInterno());
                break;
            case "productos":
                cargarFrame(consumidor_BusquedaSeleccionProducto, consumidor_menu.getJdpInterno());
                break;
            case "carrito":
                cargarFrame(consumidor_detallePedidos, consumidor_menu.getJdpInterno());
                break;
            case "historial":
                cargarFrame(consumidor_historialpedidos, consumidor_menu.getJdpInterno());
                break;
            default:
                throw new AssertionError();
        }
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

    //LIMPIAR LAS VENTANAS INTERNAS
    private void limpiar(String ventana) {
        switch (ventana) {
            case "perfil":

                break;

            case "productos":

                // notificaciones_refresh();
                break;
            case "carrito":

                break;
            case "historial":

                break;
            default:
                break;
        }

    }

    //BOTON PERFIL DEL MENU CONSUMIDOR
    public void mostrarPerfil() {
        abrir_internal("perfil");
        consumidor_perfil.getTxtNombre().setText(consumidor.getNombre());
        consumidor_perfil.getTxtDireccion().setText(consumidor.getDireccion());
        consumidor_perfil.getTxtCelular().setText(consumidor.getCelular());
        consumidor_perfil.getTxtDni().setText(consumidor.getDni());

    }

    //METODO PARA MOSTRAR LOS PRODUCTOS EN LA TABLA DE LA VISTA Consumidor_BusquedaSeleccionProducto
    public void visualizarProductos(JTable tabla, String nombrePro) {

        tabla.setDefaultRenderer(Object.class, new formatoTablaListarProductos());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("idproducto");
        dt.addColumn("nombre");
        dt.addColumn("precio");
        dt.addColumn("Foto");

        producto = new Producto();
        ArrayList<Producto> list = daoconsumidor.Listar_Productos();

        //Si no hay búsqueda de productos es Listar_Productos sino Buscar_Productos
        if (nombrePro == null) {
            list = daoconsumidor.Listar_Productos();
        } else {
            list = daoconsumidor.Buscar_Productos(nombrePro);
        }

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[5];
                producto = list.get(i);
                fila[0] = producto.getId();
                fila[1] = producto.getNombre();
                fila[2] = producto.getPrecio();
                listaIdProductoInv.add(producto.getId_pi());
                System.out.println("id de producto inv " + producto.getId_pi());
                try {
                    byte[] bi = producto.getFoto();
                    BufferedImage image = null;
                    InputStream in = new ByteArrayInputStream(bi);
                    image = ImageIO.read(in);
                    ImageIcon imgi = new ImageIcon(image.getScaledInstance(60, 60, 0));
                    fila[3] = new JLabel(imgi);

                } catch (Exception ex) {
                    fila[3] = new JLabel("No imagen");
                }
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(60);
        }
    }

    //Limpiar tabla
    public void limpiarTabla(JTable tabla) {
        DefaultTableModel modelillo = new DefaultTableModel();
        while (modelillo.getRowCount() > 0) {
            modelillo.removeRow(0);
        }

        tabla.setModel(modelillo);
    }

    //BOTON PRODUCTOS DEL MENU CONSUMIDOR
    public void mostarProductos() {
        listaIdProductoInv.clear();
        consumidor_BusquedaSeleccionProducto.getTxtNombreProducto().setText("");

        abrir_internal("productos");
        Producto producto = null;
        String nombreProducto = null;

        //mostrar los productos en la tabla
        visualizarProductos(consumidor_BusquedaSeleccionProducto.getTablaProductos(), nombreProducto);
        System.out.println(listaIdProductoInv);
        consumidor_BusquedaSeleccionProducto.getTxtFecha().setText(fechaActual());
    }

    public static String fechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
        return formato.format(fecha);
    }

    public void seleccionarProducto() {

    }

    public void mostrarProductosBuscados() {
        listaIdProductoInv.clear();
        limpiarTabla(consumidor_BusquedaSeleccionProducto.getTablaProductos());

        String nombrePro = consumidor_BusquedaSeleccionProducto.getTxtNombreProducto().getText().trim();
        visualizarProductos(consumidor_BusquedaSeleccionProducto.getTablaProductos(), nombrePro);
        System.out.println(listaIdProductoInv);
    }

    public void agregarDetalleProductoConsumidor() {
        System.out.println("agregar");
        int idConsumidor = consumidor.getId();
        String nombre = consumidor.getNombre();
        String fechaCompra = fechaActual();
        int idProInv = Integer.valueOf(consumidor_BusquedaSeleccionProducto.getTxtIdProInv().getText());
        int idOrdenCompra = idOrdenCom;
        int cant = (Integer) consumidor_BusquedaSeleccionProducto.getCantidad().getValue();

        double precio = Double.valueOf(consumidor_BusquedaSeleccionProducto.getTxtPrecio().getText());
        double precioOferta = Double.valueOf(consumidor_BusquedaSeleccionProducto.getTxtPrecioOferta().getText());
        double PrecioFinal;

        if (precio == precioOferta) {
            PrecioFinal = precio;
        } else {
            PrecioFinal = precioOferta;
        }

        daoconsumidor.registroDetalleCompraConsumidor(idConsumidor, fechaCompra, idProInv, idOrdenCompra, cant, PrecioFinal);
        System.out.println(daoconsumidor.getMessage());
        if (daoconsumidor.getMessage() == null) {
            JOptionPane.showMessageDialog(null, "Agregado Correctamente");
        }

        Producto pro = new Producto();

        pro.setNombre(consumidor_BusquedaSeleccionProducto.getTxtnombre_producto().getText());
        pro.setPrecio(PrecioFinal);
        pro.setCantidad(cant);

        ListaProductosElegidos.add(pro);

    }

    //METODO DEL BOTON CARRITO DE LA VISTA CONSUMIDOR_MENU
    public void mostrarCarrito() {
        abrir_internal("carrito");

        //     tabla.setDefaultRenderer(Object.class, new formatoTablaListarProductos());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        dt.addColumn("nombre");
        dt.addColumn("precio");
        dt.addColumn("Cantidad");

        if (ListaProductosElegidos.size() > 0) {
            for (int i = 0; i < ListaProductosElegidos.size(); i++) {
                Object fila[] = new Object[5];
                producto = ListaProductosElegidos.get(i);
                fila[0] = producto.getNombre();
                fila[1] = producto.getPrecio();
                fila[2] = producto.getCantidad();

                dt.addRow(fila);
            }
            consumidor_detallePedidos.getTablaPedidos().setModel(dt);
            consumidor_detallePedidos.getTablaPedidos().setRowHeight(60);
        }

    }

    public void agregarOrdenCompra() {

        JTable table =consumidor_detallePedidos.getTablaPedidos();

        for (int i = 0; i < table.getRowCount(); i++) {
            int columna = 2;
           
            System.out.println( table.getValueAt(i, columna));
               
        }
        

        idOrdenCom++;
        ListaProductosElegidos.clear();
        
        

    }

    //METODO DEL BOTON HISTORIAL DE PEDIDOS
    public void mostrarHistorial() {
        abrir_internal("historial");
    }

}
