
package com.mycompany.compraverymaven.vista;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JRootPane;
import javax.swing.JTable;


public class Consumidor_DetallePedidos extends javax.swing.JInternalFrame {

    public Consumidor_DetallePedidos() {
        initComponents();
    }

    public JButton getBtnGenerarPedido() {
        return btnGenerarPedido;
    }

    public JTable getTablaPedidos() {
        return tablaPedidos;
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPedidos = new javax.swing.JTable();
        btnGenerarPedido = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 87, 34));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MIS PEDIDOS ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 300, -1));

        tablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaPedidos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 630, 210));

        btnGenerarPedido.setBackground(new java.awt.Color(3, 169, 244));
        btnGenerarPedido.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnGenerarPedido.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarPedido.setText("GENERAR PEDIDO");
        btnGenerarPedido.setBorder(null);
        getContentPane().add(btnGenerarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 600, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPedidos;
    // End of variables declaration//GEN-END:variables
}
