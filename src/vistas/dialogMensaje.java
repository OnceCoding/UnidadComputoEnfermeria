
package vistas;

public class dialogMensaje extends javax.swing.JDialog {

    private int x, y;
    private int tipo; // 1 -> aviso, 2 -> confirmación
    private String texto;
    private int rpta; // return 0 si es si, y 1 si es no
    
    /*
        dialogMensaje dm  = new dialogMensaje(this, 2, "<html> Hola Que ta asdasjdkajsdjkahjsdhjashdjasdas  <br> jshdjashd</html>");
        int rpta = dm.rpta();
        System.out.println(rpta);
        
    */
    
    public dialogMensaje(java.awt.Frame parent, int tipo, String texto) {
        super(parent, true);
        initComponents();
        setLocationRelativeTo(null);
        this.tipo = tipo;
        this.texto = texto;
        lblTexto.setText(texto);
        if(this.tipo == 2){
            btnAceptar2.setVisible(false);
        }else{
            btnAceptar.setVisible(false);
            btnCancelar.setVisible(false);
        }
        
        setVisible(true);
    }
    
    public int rpta(){
        return rpta;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jPanel1 = new javax.swing.JPanel();
        barra = new javax.swing.JPanel();
        bttSalir = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        lblTexto = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAceptar2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(null);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.gray, java.awt.Color.gray));
        jPanel1.setForeground(new java.awt.Color(0, 102, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(374, 711));

        barra.setBackground(new java.awt.Color(184, 207, 229));
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

        bttSalir.setBackground(java.awt.Color.white);
        bttSalir.setForeground(new java.awt.Color(153, 153, 153));
        bttSalir.setText("X");
        bttSalir.setBorder(null);
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
                .addComponent(bttSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );
        barraLayout.setVerticalGroup(
            barraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(bttSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        btnAceptar.setBackground(new java.awt.Color(184, 207, 229));
        btnAceptar.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(51, 51, 51));
        btnAceptar.setText("ACEPTAR");
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.setFocusPainted(false);
        btnAceptar.setFocusable(false);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        lblTexto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTexto.setText("CLAVE INCORRECTA! Intente nuevamente.");

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(51, 51, 51));
        btnCancelar.setText("CANCELAR");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setFocusPainted(false);
        btnCancelar.setFocusable(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar2.setBackground(new java.awt.Color(184, 207, 229));
        btnAceptar2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        btnAceptar2.setForeground(new java.awt.Color(51, 51, 51));
        btnAceptar2.setText("ACEPTAR");
        btnAceptar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar2.setFocusPainted(false);
        btnAceptar2.setFocusable(false);
        btnAceptar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptar2ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/desktop-32-white.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(btnAceptar2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(barra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTexto, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(btnAceptar2)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        rpta = 0;
        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        rpta = 1;
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptar2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnAceptar2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barra;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAceptar2;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton bttSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblTexto;
    // End of variables declaration//GEN-END:variables
}
