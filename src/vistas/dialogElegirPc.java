
package vistas;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class dialogElegirPc extends java.awt.Dialog {

    public dialogElegirPc(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocation(parent.getLocation().x + 1200, parent.getLocation().y + 370);
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        tablaPcDisponibles.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPcDisponibles = new javax.swing.JTable();

        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        tablaPcDisponibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1"},
                {"2"},
                {null},
                {null}
            },
            new String [] {
                "Nro de PC"
            }
        ));
        tablaPcDisponibles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaPcDisponibles.setRowHeight(25);
        tablaPcDisponibles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPcDisponiblesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPcDisponibles);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void tablaPcDisponiblesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPcDisponiblesMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_tablaPcDisponiblesMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPcDisponibles;
    // End of variables declaration//GEN-END:variables
}
