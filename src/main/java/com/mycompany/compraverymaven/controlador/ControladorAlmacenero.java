package com.mycompany.compraverymaven.controlador;

import com.mycompany.compraverymaven.vista.*;
import com.mycompany.compraverymaven.dao.*;
import com.mycompany.compraverymaven.dto.Trabajador;
import java.awt.Dimension;
import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class ControladorAlmacenero {

  
    private final DaoConsumidor daoconsumidor;
    private final DaoTrabajador daotrabajador;
    private final Almacenero_Menu almacenero_menu;
    private final Almacenero_Login almacenero_login;
    
    private Trabajador trabajador=null ;

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

     //Metodo para iniciar datos:
    private void inicio_total() {
        almacenero_menu_perfil.getLblName().setText(trabajador.getNombre());
        almacenero_menu_perfil.getLblDireccion().setText(trabajador.getDireccion());
        almacenero_menu_perfil.getLblDni().setText(trabajador.getDni());
        almacenero_menu_perfil.getLblCell().setText(trabajador.getCelular());
        almacenero_menu_perfil.getLblCargo().setText(trabajador.getCargo());
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
