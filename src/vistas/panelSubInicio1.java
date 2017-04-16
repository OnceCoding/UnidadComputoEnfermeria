
package vistas;

import java.awt.Frame;

public class panelSubInicio1 extends javax.swing.JPanel {

    public panelSubInicio1() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnNuevaSesion = new javax.swing.JButton();
        btnDetenerSesion = new javax.swing.JButton();
        btnDetenerTodo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSesiones = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txtHoraInicioSeleccionado = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtNroPCSelecionado = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(34, 34, 34));

        btnNuevaSesion.setBackground(new java.awt.Color(34, 70, 135));
        btnNuevaSesion.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        btnNuevaSesion.setForeground(java.awt.Color.white);
        btnNuevaSesion.setText("NUEVA SESIÓN");
        btnNuevaSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevaSesion.setFocusable(false);
        btnNuevaSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaSesionActionPerformed(evt);
            }
        });

        btnDetenerSesion.setBackground(new java.awt.Color(34, 70, 135));
        btnDetenerSesion.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        btnDetenerSesion.setForeground(java.awt.Color.white);
        btnDetenerSesion.setText("DETENER SESIÓN");
        btnDetenerSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetenerSesion.setFocusable(false);

        btnDetenerTodo.setBackground(new java.awt.Color(34, 70, 135));
        btnDetenerTodo.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        btnDetenerTodo.setForeground(java.awt.Color.white);
        btnDetenerTodo.setText("DETENER TODO");
        btnDetenerTodo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetenerTodo.setFocusable(false);

        tablaSesiones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(2), "O", "12:00:00", null, null},
                { new Integer(3), "wrwre", "23432", null, null},
                { new Integer(4), "rwer", null, null, null},
                { new Integer(5), null, null, null, null},
                { new Integer(6), null, null, null, null},
                { new Integer(78), null, null, null, null},
                { new Integer(8), null, null, null, null},
                { new Integer(9), null, null, null, null},
                { new Integer(10), null, null, null, null},
                { new Integer(11), null, null, null, null},
                { new Integer(12), null, null, null, null},
                { new Integer(13), null, null, null, null},
                { new Integer(14), null, null, null, null}
            },
            new String [] {
                "#", "Codigo de Usuario", "Nombres y Apellidos", "Nro de PC", "Hora Inicio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaSesiones.setGridColor(new java.awt.Color(34, 70, 135));
        tablaSesiones.setMaximumSize(new java.awt.Dimension(2147483647, 2502121));
        tablaSesiones.setMinimumSize(new java.awt.Dimension(45, 250));
        tablaSesiones.setOpaque(false);
        tablaSesiones.setPreferredSize(new java.awt.Dimension(165, 225));
        tablaSesiones.setRequestFocusEnabled(false);
        tablaSesiones.setRowHeight(25);
        tablaSesiones.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaSesiones);

        jPanel4.setBackground(new java.awt.Color(34, 34, 34));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white), "Sesión Seleccionada", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.white)); // NOI18N

        txtHoraInicioSeleccionado.setBackground(new java.awt.Color(34, 34, 34));
        txtHoraInicioSeleccionado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtHoraInicioSeleccionado.setForeground(java.awt.Color.white);
        txtHoraInicioSeleccionado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHoraInicioSeleccionado.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white));
        txtHoraInicioSeleccionado.setCaretColor(new java.awt.Color(255, 255, 255));

        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("HORA INICIO:");

        txtNroPCSelecionado.setBackground(new java.awt.Color(34, 34, 34));
        txtNroPCSelecionado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNroPCSelecionado.setForeground(java.awt.Color.white);
        txtNroPCSelecionado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNroPCSelecionado.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white));
        txtNroPCSelecionado.setCaretColor(new java.awt.Color(255, 255, 255));

        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("N° DE PC:");

        btnModificar.setBackground(new java.awt.Color(34, 70, 135));
        btnModificar.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        btnModificar.setForeground(java.awt.Color.white);
        btnModificar.setText("MODIFICAR");
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.setFocusable(false);

        btnEliminar.setBackground(new java.awt.Color(34, 70, 135));
        btnEliminar.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        btnEliminar.setForeground(java.awt.Color.white);
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setFocusable(false);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(184, 207, 229));
        jLabel23.setText("El N° de PC debe figurar en la tabla");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(184, 207, 229));
        jLabel24.setText("de Equipos Disponibles.");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(70, 70, 70))
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNroPCSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHoraInicioSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel24))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNroPCSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHoraInicioSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel28)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNuevaSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDetenerSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetenerTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDetenerSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNuevaSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnDetenerTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addGap(4, 4, 4)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevaSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaSesionActionPerformed
        
    }//GEN-LAST:event_btnNuevaSesionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetenerSesion;
    private javax.swing.JButton btnDetenerTodo;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevaSesion;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaSesiones;
    private javax.swing.JTextField txtHoraInicioSeleccionado;
    private javax.swing.JTextField txtNroPCSelecionado;
    // End of variables declaration//GEN-END:variables
}
