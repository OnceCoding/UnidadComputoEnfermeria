
package vistas;

import dao.DaoManager;
import dao.DaoRegistroTemporal;
import dao.DaoUsuario;
import dao.mysql.MysqlDaoManager;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelo.Computadora;
import modelo.RegistroTemporal;
import modelo.Usuario;

public class frmNuevaSesion extends javax.swing.JFrame {

    private int x, y;
    
    private DaoManager manager;
    private DaoUsuario daoUsuario;
    private Usuario usuario;
    private DaoRegistroTemporal daoRegistroTemporal;
    private Computadora compu;
    private List<Computadora> listaEquiposDisponibles;
    
    private String codigo;
    private String codigoPcSeleccionado = "";
    private int fila;
    
    private String numerosValidos = "1234567890";
    
    private DefaultTableModel model;
    private DefaultTableCellRenderer renderer;
    
    public frmNuevaSesion() {
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/iconBar.png")).getImage());
        tablaEquipos.setRowHeight(25);
        model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
            
        };
        model.addColumn("Codigo Equipo");
        
        renderer = new DefaultTableCellRenderer(){
            @Override
            public void setHorizontalAlignment(int alignment) {
                super.setHorizontalAlignment(CENTER); 
            }   
        };
        
        tablaEquipos.setModel(model);
        tablaEquipos.setDefaultRenderer(Object.class, renderer);
        
        tablaEquipos.getSelectionModel().addListSelectionListener((event)->{
            fila = tablaEquipos.getSelectedRow();
            if(fila != -1){
                codigoPcSeleccionado = model.getValueAt(fila,0).toString();
            }
        });
        
        try {
            manager = MysqlDaoManager.getMysqlDaoManager();
        } catch (SQLException e) {
            System.out.println("error");
        }
     
        mostrarEquiposDisponibles();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        barra = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEquipos = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(34, 34, 34));

        jPanel3.setBackground(new java.awt.Color(34, 70, 135));

        barra.setBackground(new java.awt.Color(34, 70, 135));
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

        btnSalir.setBackground(new java.awt.Color(34, 70, 135));
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("X");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setFocusable(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ESCUELA DE ENFERMERIA - UNT");

        javax.swing.GroupLayout barraLayout = new javax.swing.GroupLayout(barra);
        barra.setLayout(barraLayout);
        barraLayout.setHorizontalGroup(
            barraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barraLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addContainerGap())
        );
        barraLayout.setVerticalGroup(
            barraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(barraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4))
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("_");
        jLabel1.setOpaque(true);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/desktop-32-white.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 0, 9)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("UNIDAD DE CÓMPUTO E INFORMÁTICA ");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("OLGA YIKA DE TORRE");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Universidad Nacional de Trujillo");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(12, 12, 12))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(57, 57, 57))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(barra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel5)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel6))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.setBackground(new java.awt.Color(34, 34, 34));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(java.awt.Color.white, 1, true), "", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.white)); // NOI18N

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CODIGO");

        btnIniciar.setBackground(new java.awt.Color(34, 70, 135));
        btnIniciar.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        btnIniciar.setForeground(java.awt.Color.white);
        btnIniciar.setText("INICIAR");
        btnIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciar.setFocusable(false);
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        txtCodigo.setBackground(new java.awt.Color(34, 34, 34));
        txtCodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCodigo.setForeground(java.awt.Color.white);
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigo.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PC");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(184, 207, 229));
        jLabel10.setText("Por favor, complete el formulario correctamente.");

        tablaEquipos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaEquipos.setRowHeight(25);
        jScrollPane1.setViewportView(tablaEquipos);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel10))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(txtCodigo)
                                .addComponent(btnIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(184, 207, 229));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("NUEVA SESION");

        btnAtras.setBackground(new java.awt.Color(184, 207, 229));
        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/back.png"))); // NOI18N
        btnAtras.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(184, 207, 229)));
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.setFocusable(false);
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnAtras)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel11.setBackground(new java.awt.Color(184, 207, 229));
        jLabel11.setForeground(java.awt.Color.white);
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel11.setOpaque(true);
        jLabel11.setPreferredSize(new java.awt.Dimension(0, 10));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        new frmPrincipal().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void barraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_barraMouseDragged

    private void barraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraMousePressed
        this.x = evt.getX();
        this.y = evt.getY();
    }//GEN-LAST:event_barraMousePressed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed

        this.codigo = txtCodigo.getText();

        if(!codigo.equals("")){
            if(validarCodigoEspaciosVacios(this.codigo)){

                if(validarPurosNumeros(codigo)){
                    daoUsuario = manager.getDaoUsuario();
                    usuario = daoUsuario.obtenerPorCodigoUsuario(codigo);

                    if(usuario != null){

                        /*int aceptar = JOptionPane.showConfirmDialog(null,
                            usuario.getNombre()+" "+usuario.getApellido()+ "  iniciará Sesion, Seguro?",
                            "Confirmar",JOptionPane.YES_NO_OPTION);
                        */
                        
                        int aceptar = DialogMensaje.Confirmacion(null,usuario.getNombre()+" "+usuario.getApellido()+ "  iniciará Sesion <br> ¿ Seguro ?");
                        
                        if(aceptar == 0){
                            
                            if(!codigoPcSeleccionado.equals("")){
                                daoRegistroTemporal = manager.getDaoRegistroTemporal();
                                daoRegistroTemporal.insertar(
                                new RegistroTemporal(null,usuario.getId(),Integer.parseInt(codigoPcSeleccionado),
                                    Time.valueOf(LocalTime.now()),null,Date.valueOf(LocalDate.now())));
                                txtCodigo.setText("");
                            
                                limpiarTabla();
                                mostrarEquiposDisponibles();
                            }else{
                                DialogMensaje.Error(null,"Seleccione una Pc de la tabla");
                            }
                            

                        }

                    }else{
                        DialogMensaje.Error(null,"El codigo no esta registrado");
                        //JOptionPane.showMessageDialog(null,"El codigo no esta registrado");
                    }

                }else{
                    DialogMensaje.Confirmacion(null,"Codigo debe poseer solo dígitos");
                    //JOptionPane.showMessageDialog(null,"Codigo debe poseer solo dígitos","Codigo",JOptionPane.WARNING_MESSAGE);
                }

            }else{
                
                DialogMensaje.Error(null,"Codigo no debe poseer espacios en blanco");
                /*JOptionPane.showMessageDialog(null,"Codigo no debe poseer espacios en blanco","Codigo",
                    JOptionPane.WARNING_MESSAGE);*/
            }

        }else{
            DialogMensaje.Error(null,"Ingrese Codigo");
            /*JOptionPane.showMessageDialog(null,"Ingrese Codigo","Codigo",
                JOptionPane.WARNING_MESSAGE);*/
        }

    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        this.dispose();
        new frmPrincipal().setVisible(true);
    }//GEN-LAST:event_btnAtrasActionPerformed

    public void mostrarEquiposDisponibles(){
        
        listaEquiposDisponibles = new ArrayList<>();
        daoRegistroTemporal = manager.getDaoRegistroTemporal();
        listaEquiposDisponibles = daoRegistroTemporal.obtenerEquiposDisponibles();
        
        listaEquiposDisponibles.forEach((computadora)->{
            model.addRow(new Object[]{computadora.getCodigo()});
        });
        
    }
    
    public boolean validarPurosNumeros(String codigo){
        int i,j;
        int sizeCodigo = codigo.length();
        int sizeNumerosValidos = numerosValidos.length();
        
        boolean band;
        
        for (i = 0; i < sizeCodigo; i++) {
            band = false;
            for (j = 0; j < sizeNumerosValidos; j++) {
                if(codigo.charAt(i) == numerosValidos.charAt(j)){
                    band = true;
                    break;
                }
            }
            
            if(band == false){
                return false;
            }
        }
        return true;
    }
    
    public boolean validarCodigoEspaciosVacios(String codigo){
        int i;
        for(i=0; i< codigo.length(); i++){
            if(codigo.charAt(i) == ' '){
                return false;
            }
        }
        return true;
    }
    
    public void limpiarTabla(){
        int cant = model.getRowCount();
        int i;
        for(i=0;i<cant;i++){
            model.removeRow(0);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barra;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEquipos;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
