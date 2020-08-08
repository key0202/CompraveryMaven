
package com.mycompany.compraverymaven.vista;

import javax.swing.JButton;
import javax.swing.JLabel;


public class Consumidor_Perfil extends javax.swing.JInternalFrame {

    public Consumidor_Perfil() {
        initComponents();
    }

    public JButton getBtnCerrarSesion() {
        return btnCerrarSesion;
    }

    public JLabel getLabelImagen() {
        return labelImagen;
    }

    public JLabel getTxtCelular() {
        return txtCelular;
    }

    public JLabel getTxtDireccion() {
        return txtDireccion;
    }

    public JLabel getTxtDni() {
        return txtDni;
    }

    public JLabel getTxtNombre() {
        return txtNombre;
    }
    
    
    

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelImagen = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JLabel();
        txtCelular = new javax.swing.JLabel();
        txtDni = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 87, 34));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(labelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 180, 180));

        jLabel2.setForeground(new java.awt.Color(255, 87, 34));
        jLabel2.setText("Nombre Completo :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, -1, 20));

        jLabel3.setForeground(new java.awt.Color(255, 87, 34));
        jLabel3.setText("Dirección  :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 70, 20));

        jLabel4.setForeground(new java.awt.Color(255, 87, 34));
        jLabel4.setText("Celular  :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 60, 20));

        jLabel6.setForeground(new java.awt.Color(255, 87, 34));
        jLabel6.setText("DNI :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, -1, -1));

        txtNombre.setForeground(new java.awt.Color(255, 87, 34));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 180, 30));

        txtDireccion.setForeground(new java.awt.Color(255, 87, 34));
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 180, 30));

        txtCelular.setForeground(new java.awt.Color(255, 87, 34));
        jPanel1.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 180, 30));

        txtDni.setForeground(new java.awt.Color(255, 87, 34));
        jPanel1.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, 160, 30));

        jPanel2.setBackground(new java.awt.Color(3, 169, 244));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("MIS DATOS");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 40));

        btnCerrarSesion.setText("Cerrar Sesión");
        jPanel1.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 400, 140, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelImagen;
    private javax.swing.JLabel txtCelular;
    private javax.swing.JLabel txtDireccion;
    private javax.swing.JLabel txtDni;
    private javax.swing.JLabel txtNombre;
    // End of variables declaration//GEN-END:variables
}
