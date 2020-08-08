package com.mycompany.compraverymaven.controlador;

import com.mycompany.compraverymaven.vista.*;
import com.mycompany.compraverymaven.dao.*;
import com.mycompany.compraverymaven.dto.ProductoInventario;
import com.mycompany.compraverymaven.dto.Trabajador;
import java.awt.Dimension;
import java.beans.PropertyVetoException;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class ControladorAlmacenero {

    private final DaoConsumidor daoconsumidor;
    private final DaoTrabajador daotrabajador;
    private final Almacenero_Menu almacenero_menu;
    private final Almacenero_Login almacenero_login;

    private Trabajador trabajador = null;
    DefaultTableModel modelillos = new DefaultTableModel();

    private final Almacenero_Menu_Perfil almacenero_menu_perfil = new Almacenero_Menu_Perfil();
    private final Almacenero_Menu_Inventario almacenero_menu_inventario = new Almacenero_Menu_Inventario();

    public ControladorAlmacenero(DaoConsumidor daoconsumidor, DaoTrabajador daotrabajador, Almacenero_Menu almacenero_menu, Almacenero_Login almacenero_login) {
        this.daoconsumidor = daoconsumidor;
        this.daotrabajador = daotrabajador;
        this.almacenero_menu = almacenero_menu;
        this.almacenero_login = almacenero_login;
        InitView();
    }

    private void InitView() {
        almacenero_login.setVisible(true);
    }


          
      

    public void InitController() {

        almacenero_login.getBtnIniciarSesion().addActionListener(e -> login());

        almacenero_menu_inventario.getBtn_buscar().addActionListener(e -> cargar_tabla());
        almacenero_menu_inventario.getBtn_confirmar().addActionListener(e -> confirmarcion());

        almacenero_menu.getBtnPerfil().addActionListener(e -> abrir_internal("perfil"));
        almacenero_menu.getBtnInventario().addActionListener(e -> abrir_internal("inventario"));
        almacenero_menu.getBtnClose().addActionListener(e -> exit());

    }

    //Metodo para logear almacenero
    private Trabajador login() {
        String nick = almacenero_login.getTxtUsuario().getText();
        String clave = almacenero_login.getTxt_password().getText();
        try {
            trabajador = daotrabajador.login(nick, clave);
            if (trabajador != null) {
                almacenero_login.dispose();
                inicio_total();
                cargarFrame(almacenero_menu_perfil, almacenero_menu.getjDesktopPane1());
                almacenero_menu.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, daotrabajador.getMessage(), "ERROR",
                        JOptionPane.WARNING_MESSAGE);
                almacenero_login.getTxt_password().setText("");
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "INTENTE NUEVAMENTE", "ERROR DE LOGIN",
                    JOptionPane.ERROR_MESSAGE);
        }
        return trabajador;

    }
    //Metodo para cerrar el programa:

    private void exit() {
        System.exit(0);
    }

    //Metodo para Grabar en la tabla producto inventario y actualizar el estado de las compras:
    private void confirmarcion() {
        Integer confirm = Integer.parseInt(almacenero_menu_inventario.getTxt_ordenCompra().getText());
        daotrabajador.actualizarEstado(confirm);

        //Grabar en la tabla productoInventario:
        int numer_registros = almacenero_menu_inventario.getTbl_detalleCompras().getRowCount();
        for (int i = 0; i < numer_registros; i++) {
            ProductoInventario produc = new ProductoInventario();
            produc.setId(Integer.parseInt(almacenero_menu_inventario.getTbl_detalleCompras().getValueAt(i, 0).toString()));
            produc.setLote(almacenero_menu_inventario.getTbl_detalleCompras().getValueAt(i, 4).toString());
            produc.setStock(Integer.parseInt(almacenero_menu_inventario.getTbl_detalleCompras().getValueAt(i, 3).toString()));
            produc.setFecha_vencimiento(LocalDate.parse(almacenero_menu_inventario.getTbl_detalleCompras().getValueAt(i, 5).toString()));
            daotrabajador.grabar_productos_inventario(produc);

        }
        JOptionPane.showMessageDialog(null, "Se han confirmado los ingresos de estos productos");

        DefaultTableModel modelillo = new DefaultTableModel();
        while (modelillo.getRowCount() > 0) {
            modelillo.removeRow(0);
        }
        modelillo.addColumn("Curso");
        modelillo.addColumn("Profesor(a)");
        modelillo.addColumn("Salon");
        almacenero_menu_inventario.getTbl_detalleCompras().setModel(modelillo);
        
        almacenero_menu_inventario.getTxt_ordenCompra().setText("");
    }

        //Metodo para iniciar datos:
    private void inicio_total() {
        almacenero_menu_perfil.getLblName().setText(trabajador.getNombre());
        almacenero_menu_perfil.getLblDireccion().setText(trabajador.getDireccion());
        almacenero_menu_perfil.getLblDni().setText(trabajador.getDni());
        almacenero_menu_perfil.getLblCell().setText(trabajador.getCelular());
        almacenero_menu_perfil.getLblCargo().setText(trabajador.getCargo());

        //Diseño de la tabla:
        modelillos.addColumn("Id");
        modelillos.addColumn("Producto");
        modelillos.addColumn("Fecha_pedido");
        modelillos.addColumn("Cantidad");
        modelillos.addColumn("Lote");
        modelillos.addColumn("Fecha_vencimiento");
        almacenero_menu_inventario.getTbl_detalleCompras().setModel(modelillos);

    }

    private void abrir_internal(String opcion) {
        //cargar los internalframe segun la opcion
        switch (opcion) {

            case "perfil":
                cargarFrame(almacenero_menu_perfil, almacenero_menu.getjDesktopPane1());

                break;
            case "inventario":
                cargarFrame(almacenero_menu_inventario, almacenero_menu.getjDesktopPane1());

                break;
            default:
                throw new AssertionError();
        }

    }

    //Metodo para visualizar las existencias compradas por el administrador y confirmar su ingreso:
    private void cargar_tabla() {
        Integer id_ordenCompra = Integer.parseInt(almacenero_menu_inventario.getTxt_ordenCompra().getText());
        List<ProductoInventario> almacenerito = daotrabajador.productoCompra_buscar(id_ordenCompra);
        DefaultTableModel modelo_local = (DefaultTableModel) almacenero_menu_inventario.getTbl_detalleCompras().getModel();
        modelo_local.setNumRows(0);
        almacenerito.forEach((i) -> {
            modelo_local.addRow(new Object[]{
                i.getId(),
                i.getNombre(),
                i.getFecha_compra(),
                i.getStock()
            });
        });

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
