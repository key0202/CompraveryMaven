
package com.mycompany.compraverymaven.vista;

import javax.swing.JButton;
import javax.swing.JTextArea;
import org.jdesktop.swingx.JXDatePicker;


public class Consumidor_HistorialPedidos extends javax.swing.JInternalFrame {


    public Consumidor_HistorialPedidos() {
        initComponents();
    }

    public JButton getBtn_buscar() {
        return btn_buscar;
    }

    public JXDatePicker getJdate_fechafinal() {
        return jdate_fechafinal;
    }

    public JXDatePicker getJdate_fechainicial() {
        return jdate_fechainicial;
    }

    public JTextArea getTxta_historial() {
        return txta_historial;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jdate_fechainicial = new org.jdesktop.swingx.JXDatePicker();
        jdate_fechafinal = new org.jdesktop.swingx.JXDatePicker();
        btn_buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txta_historial = new javax.swing.JTextArea();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HISTORIAL DE COMPRAS <EL FAST>");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 440, -1));

        jLabel2.setText("FECHA INICIAL:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel3.setText("FECHA FINAL:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, -1));
        getContentPane().add(jdate_fechainicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 150, -1));
        getContentPane().add(jdate_fechafinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 150, -1));

        btn_buscar.setText("BUSCAR");
        getContentPane().add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 590, -1));

        txta_historial.setColumns(20);
        txta_historial.setRows(5);
        jScrollPane1.setViewportView(txta_historial);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 590, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jdate_fechafinal;
    private org.jdesktop.swingx.JXDatePicker jdate_fechainicial;
    private javax.swing.JTextArea txta_historial;
    // End of variables declaration//GEN-END:variables
}
