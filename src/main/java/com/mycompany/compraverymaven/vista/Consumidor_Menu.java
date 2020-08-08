
package com.mycompany.compraverymaven.vista;

import javax.swing.JButton;
import javax.swing.JDesktopPane;


public class Consumidor_Menu extends javax.swing.JFrame {

    public Consumidor_Menu() {
        initComponents();
    }

    public JButton getBtnCarrito() {
        return btnCarrito;
    }

    public JButton getBtnHistorialPedidos() {
        return btnHistorialPedidos;
    }

    public JButton getBtnPerfil() {
        return btnPerfil;
    }

    public JButton getBtnProductos() {
        return btnProductos;
    }

    public JDesktopPane getJdpInterno() {
        return jdpInterno;
    }
    
    
    
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        btnProductos = new javax.swing.JButton();
        btnCarrito = new javax.swing.JButton();
        btnHistorialPedidos = new javax.swing.JButton();
        btnPerfil = new javax.swing.JButton();
        jdpInterno = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 0, 410));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnProductos.setText("Productos");
        jPanel1.add(btnProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 130, 70));

        btnCarrito.setText("Carrito");
        jPanel1.add(btnCarrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 130, 70));

        btnHistorialPedidos.setText("Historial Pedidos");
        jPanel1.add(btnHistorialPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 130, 80));

        btnPerfil.setText("Mi perfil");
        jPanel1.add(btnPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 130, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 550));
        getContentPane().add(jdpInterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 900, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    
    
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCarrito;
    private javax.swing.JButton btnHistorialPedidos;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JButton btnProductos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JDesktopPane jdpInterno;
    // End of variables declaration//GEN-END:variables
}
