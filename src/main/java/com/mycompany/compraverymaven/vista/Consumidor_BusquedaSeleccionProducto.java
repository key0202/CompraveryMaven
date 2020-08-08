
package com.mycompany.compraverymaven.vista;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Consumidor_BusquedaSeleccionProducto extends javax.swing.JInternalFrame {


    public Consumidor_BusquedaSeleccionProducto() {
        initComponents();
    }

    public JButton getBtnAgregarCarrito() {
        return btnAgregarCarrito;
    }

    public JButton getBtnBuscarProducto() {
        return btnBuscarProducto;
    }

    public JSpinner getCantidad() {
        return cantidad;
    }

    public JLabel getLabelImagen() {
        return labelImagen;
    }

    public JTable getTablaProductos() {
        return tablaProductos;
    }

    public JLabel getTextoOferta() {
        return textoOferta;
    }

    public JLabel getTextoPrecio() {
        return textoPrecio;
    }

    public JTextArea getTxtDescripcion() {
        return txtDescripcion;
    }

    public JTextField getTxtNombreProducto() {
        return txtNombreProducto;
    }

    public JLabel getTxtPrecio() {
        return txtPrecio;
    }

    public JLabel getTxtPrecioOferta() {
        return txtPrecioOferta;
    }

    public JRootPane getRootPane() {
        return rootPane;
    }

    public boolean isRootPaneCheckingEnabled() {
        return rootPaneCheckingEnabled;
    }

    public boolean isClosable() {
        return closable;
    }

    public boolean isIsClosed() {
        return isClosed;
    }

    public boolean isMaximizable() {
        return maximizable;
    }

    public boolean isIsMaximum() {
        return isMaximum;
    }

    public boolean isIconable() {
        return iconable;
    }

    public boolean isIsIcon() {
        return isIcon;
    }

    public boolean isResizable() {
        return resizable;
    }

    public boolean isIsSelected() {
        return isSelected;
    }

    public Icon getFrameIcon() {
        return frameIcon;
    }

    public String getTitle() {
        return title;
    }

    public JDesktopIcon getDesktopIcon() {
        return desktopIcon;
    }

    public static String getCONTENT_PANE_PROPERTY() {
        return CONTENT_PANE_PROPERTY;
    }

    public static String getMENU_BAR_PROPERTY() {
        return MENU_BAR_PROPERTY;
    }

    public static String getTITLE_PROPERTY() {
        return TITLE_PROPERTY;
    }

    public static String getLAYERED_PANE_PROPERTY() {
        return LAYERED_PANE_PROPERTY;
    }

    public static String getROOT_PANE_PROPERTY() {
        return ROOT_PANE_PROPERTY;
    }

    public static String getGLASS_PANE_PROPERTY() {
        return GLASS_PANE_PROPERTY;
    }

    public static String getFRAME_ICON_PROPERTY() {
        return FRAME_ICON_PROPERTY;
    }

    public static String getIS_SELECTED_PROPERTY() {
        return IS_SELECTED_PROPERTY;
    }

    public static String getIS_CLOSED_PROPERTY() {
        return IS_CLOSED_PROPERTY;
    }

    public static String getIS_MAXIMUM_PROPERTY() {
        return IS_MAXIMUM_PROPERTY;
    }

    public static String getIS_ICON_PROPERTY() {
        return IS_ICON_PROPERTY;
    }
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        btnBuscarProducto = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        txtPrecio = new javax.swing.JLabel();
        textoPrecio = new javax.swing.JLabel();
        textoOferta = new javax.swing.JLabel();
        cantidad = new javax.swing.JSpinner();
        btnAgregarCarrito = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPrecioOferta = new javax.swing.JLabel();
        labelImagen = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaProductos);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 480, 340));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Nombre Producto :");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 110, -1));

        txtNombreProducto.setBorder(null);
        jPanel3.add(txtNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 170, 30));

        btnBuscarProducto.setText("Buscar Producto");
        jPanel3.add(btnBuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 120, 30));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 10, 440));

        jLabel2.setText("Producto Seleccionado");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 130, 20));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 270, 210, 60));
        jPanel3.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 340, 80, 20));

        textoPrecio.setText("Precio Normal");
        jPanel3.add(textoPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, -1, -1));

        textoOferta.setText("Precio  Oferta");
        jPanel3.add(textoOferta, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 380, -1, -1));
        jPanel3.add(cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 420, 70, -1));

        btnAgregarCarrito.setBackground(new java.awt.Color(255, 87, 34));
        btnAgregarCarrito.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        btnAgregarCarrito.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarCarrito.setText("Añadir a carrito de compra");
        btnAgregarCarrito.setBorder(null);
        jPanel3.add(btnAgregarCarrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 480, 290, 30));

        jPanel2.setBackground(new java.awt.Color(3, 169, 244));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("SELECCIÓN DE PRODUCTOS");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 50));

        jLabel6.setText("Descripción");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 270, -1, -1));

        jLabel7.setText("Cantidad");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 420, -1, -1));
        jPanel3.add(txtPrecioOferta, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 370, 80, 20));

        labelImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel3.add(labelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, 170, 160));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 170, 10));

        jLabel9.setText("S/.");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 340, -1, -1));

        jLabel11.setText("S/.");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 380, 20, -1));

        jLabel3.setText("Unidades");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 420, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCarrito;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JSpinner cantidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelImagen;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JLabel textoOferta;
    private javax.swing.JLabel textoPrecio;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JLabel txtPrecio;
    private javax.swing.JLabel txtPrecioOferta;
    // End of variables declaration//GEN-END:variables
}
