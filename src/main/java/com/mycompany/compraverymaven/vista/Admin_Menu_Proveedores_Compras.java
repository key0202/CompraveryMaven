package com.mycompany.compraverymaven.vista;

import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import org.jdesktop.swingx.JXDatePicker;

public class Admin_Menu_Proveedores_Compras extends javax.swing.JInternalFrame {

    /**
     * Creates new form Admin_Menu_Proveedores_Compras
     */
    public Admin_Menu_Proveedores_Compras() {       
        initComponents();
        jXFechaActual.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductosCompras = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNumeroOrdenCompra = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cmbProducto = new javax.swing.JComboBox<>();
        btnComprar = new javax.swing.JButton();
        LbFechaActual = new javax.swing.JLabel();
        txtProveedor = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtTotal = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtRUC = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnImporte = new javax.swing.JButton();
        jXFechaActual = new org.jdesktop.swingx.JXDatePicker();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaProductosCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaProductosCompras);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 510, 180));

        jPanel2.setBackground(new java.awt.Color(3, 169, 244));

        jLabel14.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("MIS COMPRAS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(211, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, -1));

        jLabel1.setText("N° Orden de Compra");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        txtNumeroOrdenCompra.setText("001");
        jPanel1.add(txtNumeroOrdenCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 50, 20));

        jLabel3.setText("Fecha Compra");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 100, 30));

        jLabel4.setText("Proveedor : ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel5.setText("Categoría :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 70, 20));

        cmbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCategoriaItemStateChanged(evt);
            }
        });
        jPanel1.add(cmbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 170, -1));

        jLabel6.setText("Producto  :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 60, -1));

        jPanel1.add(cmbProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 170, -1));

        btnComprar.setText("Comprar");
        jPanel1.add(btnComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 476, 510, 36));

        LbFechaActual.setText("04/04/2020");
        jPanel1.add(LbFechaActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 80, 30));

        txtProveedor.setText("Proveedor Prueba SAC");
        jPanel1.add(txtProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 130, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 560, 10));
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 440, 100, 20));

        jLabel11.setText("S/.");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 440, -1, -1));

        jLabel12.setText("RUC :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 70, -1));

        txtRUC.setText("12345678901");
        jPanel1.add(txtRUC, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 110, -1));

        btnAgregar.setText("Agregar");
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, -1, -1));

        btnImporte.setText("Importe a pagar");
        jPanel1.add(btnImporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));
        jPanel1.add(jXFechaActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(93, 93, 93))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCategoriaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCategoriaItemStateChanged

    public JButton getBtnAgregar() {
        return btnAgregar;
    }
    

    public JXDatePicker getjXFechaActual() {
        return jXFechaActual;
    }
    

    public JButton getBtnComprar() {
        return btnComprar;
    }

    public JComboBox<String> getCmbCategoria() {
        return cmbCategoria;
    }

    public JComboBox<String> getCmbProducto() {
        return cmbProducto;
    }

    public JTable getTablaProductosCompras() {
        return tablaProductosCompras;
    }

    public JLabel getTxtFechaCompra() {
        return LbFechaActual;
    }

    public JLabel getTxtNumeroOrdenCompra() {
        return txtNumeroOrdenCompra;
    }

    public JLabel getTxtProveedor() {
        return txtProveedor;
    }

    public JButton getBtnImporte() {
        return btnImporte;
    }
    

    public JLabel getTxtRUC() {
        return txtRUC;
    }

    public JLabel getTxtTotal() {
        return txtTotal;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LbFechaActual;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnImporte;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private org.jdesktop.swingx.JXDatePicker jXFechaActual;
    private javax.swing.JTable tablaProductosCompras;
    private javax.swing.JLabel txtNumeroOrdenCompra;
    private javax.swing.JLabel txtProveedor;
    private javax.swing.JLabel txtRUC;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
