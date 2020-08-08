
package com.mycompany.compraverymaven.vista;

import javax.swing.JButton;
import javax.swing.JDesktopPane;


public class Consumidor_Menu extends javax.swing.JFrame {

    public Consumidor_Menu() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnPerfil = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnCarrito = new javax.swing.JButton();
        btnHistorialPedidos = new javax.swing.JButton();
        jdpInterno = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPerfil.setText("Perfil");
        jPanel1.add(btnPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 125, 116, 63));

        btnProductos.setText("Productos");
        jPanel1.add(btnProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 226, 120, 60));

        btnCarrito.setText("Mi carrito");
        jPanel1.add(btnCarrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 120, 60));

        btnHistorialPedidos.setText("Mi Historial");
        jPanel1.add(btnHistorialPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 130, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 590));

        javax.swing.GroupLayout jdpInternoLayout = new javax.swing.GroupLayout(jdpInterno);
        jdpInterno.setLayout(jdpInternoLayout);
        jdpInternoLayout.setHorizontalGroup(
            jdpInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );
        jdpInternoLayout.setVerticalGroup(
            jdpInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );

        getContentPane().add(jdpInterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 810, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCarrito;
    private javax.swing.JButton btnHistorialPedidos;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JButton btnProductos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JDesktopPane jdpInterno;
    // End of variables declaration//GEN-END:variables
}
