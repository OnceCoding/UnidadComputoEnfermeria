
package vistas;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class dialogElegirPc extends java.awt.Dialog {

    private int x, y;
    
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
        barra = new javax.swing.JPanel();
        bttSalir = new javax.swing.JButton();

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

        barra.setBackground(new java.awt.Color(34, 70, 135));
        barra.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white));
        barra.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                barraMouseDragged(evt);
            }
        });
        barra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barraMousePressed(evt);
            }
        });

        bttSalir.setBackground(new java.awt.Color(34, 70, 135));
        bttSalir.setForeground(new java.awt.Color(255, 255, 255));
        bttSalir.setText("X");
        bttSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttSalir.setFocusable(false);
        bttSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout barraLayout = new javax.swing.GroupLayout(barra);
        barra.setLayout(barraLayout);
        barraLayout.setHorizontalGroup(
            barraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barraLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bttSalir)
                .addGap(4, 4, 4))
        );
        barraLayout.setVerticalGroup(
            barraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(bttSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 16, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
            .addComponent(barra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(barra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
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

    private void bttSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttSalirActionPerformed
        dispose();
    }//GEN-LAST:event_bttSalirActionPerformed

    private void barraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_barraMouseDragged

    private void barraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraMousePressed
        this.x = evt.getX();
        this.y = evt.getY();
    }//GEN-LAST:event_barraMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barra;
    private javax.swing.JButton bttSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPcDisponibles;
    // End of variables declaration//GEN-END:variables
}
