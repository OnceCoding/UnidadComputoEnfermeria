
package vistas;

import dao.DaoCursoRegistroTemporal;
import dao.DaoManager;
import dao.DaoRegistroTemporal;
import dao.mysql.MysqlDaoManager;
import java.awt.BorderLayout;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import modelo.RegistroTemporal;


public class panelInicio extends javax.swing.JPanel {
    
    private JFrame frame;
    private DaoManager manager;
    private DaoRegistroTemporal daoRegistroTemporal;
    private DaoCursoRegistroTemporal daoCursoRegistroTemporal;
    
    public panelInicio(JFrame frame) {
        initComponents();
        this.frame = frame;
        
        try {
            manager = MysqlDaoManager.getMysqlDaoManager();
        } catch (SQLException e) {
        }
        
        daoRegistroTemporal = manager.getDaoRegistroTemporal();
        int cantidadSesiones = Integer.valueOf(daoRegistroTemporal.obtenerNroSesionesActivas());
        
        if(cantidadSesiones > 0){
            cambiarPanel(subPanelUsuarioPrincipal, new subPanelUsuario(frame), 1209, 384, 6, 15);
        }else{
            cambiarPanel(subPanelUsuarioPrincipal, new subPanelUsuarioVacio(frame), 1209, 384, 6, 15);
            actualizarNroEquiposDisponibles();
            lblCantidadSesiones.setText("0");
        }
        
        daoCursoRegistroTemporal = manager.getDaoCursoRegistroTemporal();
        int cursoActivo = daoCursoRegistroTemporal.existeCursoActual();
        
        if(cursoActivo == 1){
            cambiarPanel(subPanelCursoPrincipal, new subPanelCurso(frame), 449, 55, 8, 15);
        }else{
            cambiarPanel(subPanelCursoPrincipal, new subPanelCursoVacio(frame), 449, 55, 8, 15);
        }
            
        
        
        
        /* El codigo de aqui esta en el subPanelUsuario */
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        subPanelUsuarioPrincipal = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        lblCantidadEquiposDisponibles = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblCantidadSesiones = new javax.swing.JLabel();
        subPanelCursoPrincipal = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(34, 34, 34));

        subPanelUsuarioPrincipal.setBackground(new java.awt.Color(34, 34, 34));
        subPanelUsuarioPrincipal.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white), "USUARIOS ACTIVOS", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.white)); // NOI18N

        javax.swing.GroupLayout subPanelUsuarioPrincipalLayout = new javax.swing.GroupLayout(subPanelUsuarioPrincipal);
        subPanelUsuarioPrincipal.setLayout(subPanelUsuarioPrincipalLayout);
        subPanelUsuarioPrincipalLayout.setHorizontalGroup(
            subPanelUsuarioPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1209, Short.MAX_VALUE)
        );
        subPanelUsuarioPrincipalLayout.setVerticalGroup(
            subPanelUsuarioPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
        );

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("SESIONES ACTIVAS");

        lblCantidadEquiposDisponibles.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblCantidadEquiposDisponibles.setForeground(new java.awt.Color(255, 255, 255));
        lblCantidadEquiposDisponibles.setText("##");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Equipos Disponibles:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Sesiones Activas:");

        lblCantidadSesiones.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblCantidadSesiones.setForeground(new java.awt.Color(255, 255, 255));
        lblCantidadSesiones.setText("##");

        subPanelCursoPrincipal.setBackground(new java.awt.Color(34, 34, 34));
        subPanelCursoPrincipal.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white), "CURSO ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.white)); // NOI18N

        javax.swing.GroupLayout subPanelCursoPrincipalLayout = new javax.swing.GroupLayout(subPanelCursoPrincipal);
        subPanelCursoPrincipal.setLayout(subPanelCursoPrincipalLayout);
        subPanelCursoPrincipalLayout.setHorizontalGroup(
            subPanelCursoPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 451, Short.MAX_VALUE)
        );
        subPanelCursoPrincipalLayout.setVerticalGroup(
            subPanelCursoPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 59, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(subPanelUsuarioPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(360, 360, 360))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCantidadEquiposDisponibles)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCantidadSesiones)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(subPanelCursoPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCantidadSesiones))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCantidadEquiposDisponibles))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(subPanelCursoPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subPanelUsuarioPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    /* Las 3 funciones estan en subPanelUsuario.java*/
    
    public void actualizarNroEquiposDisponibles(){
        daoRegistroTemporal = manager.getDaoRegistroTemporal();
        lblCantidadEquiposDisponibles.setText(daoRegistroTemporal.obtenerNroEquiposDisponibles());
    }
    
    public void cambiarPanel(JPanel panelContenedor, JPanel panelNuevo, int tamX, int tamY, int posX, int posY){
        panelNuevo.setSize(tamX, tamY);
        panelNuevo.setLocation(posX, posY);
        panelContenedor.removeAll();
        panelContenedor.add(panelNuevo,BorderLayout.CENTER);
        panelContenedor.revalidate();
        panelContenedor.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel1;
    static javax.swing.JLabel lblCantidadEquiposDisponibles;
    static javax.swing.JLabel lblCantidadSesiones;
    static javax.swing.JPanel subPanelCursoPrincipal;
    static javax.swing.JPanel subPanelUsuarioPrincipal;
    // End of variables declaration//GEN-END:variables
}
