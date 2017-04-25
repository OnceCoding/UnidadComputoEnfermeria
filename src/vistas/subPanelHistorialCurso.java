
package vistas;

import vistas.*;
import com.toedter.calendar.JTextFieldDateEditor;
import dao.DaoComputadora;
import dao.DaoCurso;
import dao.DaoManager;
import dao.DaoRegistro;
import dao.mysql.MysqlDaoManager;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelo.Curso;
import modelo.ReporteRegistroCurso;
import static vistas.panelHistorialInicio.panelSesiones;

public class subPanelHistorialCurso extends javax.swing.JPanel {

    private String caracteresValidos = "1234567890";
    
    private DaoRegistro daoRegistro;
    private DaoManager manager;
    private DaoCurso daoCurso;
    
    private List<ReporteRegistroCurso> listaReporte;
    private List<ReporteRegistroCurso> listaAux;
    private List<Curso> listaCursos;
    
    private DefaultTableModel model;
    private DefaultTableCellRenderer renderer;
    
    private boolean nombreCursoSelected = false;
    
    private LocalDate dateDesde;
    private LocalDate dateHasta;
    private SimpleDateFormat formato;
    
    public subPanelHistorialCurso() {
        initComponents();
        try {
            manager = MysqlDaoManager.getMysqlDaoManager();
        } catch (SQLException ex) {
            System.out.println("error manager - Computadora");
        }
       
        model = new DefaultTableModel(){
          
            @Override
            public boolean isCellEditable(int row,int column){
                return false;
            }
            
        };
        
        model.addColumn("Curso");
        model.addColumn("Hora Inicio");
        model.addColumn("Hora Fin");
        model.addColumn("Fecha");
        
        tablaHistorial.setModel(model);
        
        renderer = new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                setHorizontalAlignment(CENTER);
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
            }
            
        };
        
        tablaHistorial.setDefaultRenderer(Object.class, renderer);
        
        cbxNombre.setEnabled(false);
        
        checkBoxNombre.addActionListener((ActionEvent e) -> {
            nombreCursoSelected = !nombreCursoSelected;
            cbxNombre.setEnabled(nombreCursoSelected);
        });
        
        JTextFieldDateEditor editor = (JTextFieldDateEditor) chooserDesde.getDateEditor();
        editor.setEditable(false);
        
        editor = (JTextFieldDateEditor) chooserHasta.getDateEditor();
        editor.setEditable(false);
        
        cargarCbxCursos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaHistorial = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        chooserDesde = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        chooserHasta = new com.toedter.calendar.JDateChooser();
        btnConsultar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        checkBoxNombre = new javax.swing.JCheckBox();
        cbxNombre = new javax.swing.JComboBox<>();
        btnConsultar2 = new javax.swing.JButton();
        btnConsultar3 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(34, 34, 34));
        jPanel1.setDoubleBuffered(false);
        jPanel1.setMaximumSize(new java.awt.Dimension(918, 476));
        jPanel1.setMinimumSize(new java.awt.Dimension(913, 445));

        tablaHistorial.setRequestFocusEnabled(false);
        tablaHistorial.setRowHeight(25);
        tablaHistorial.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaHistorial);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fecha Inicial:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Fecha Final:");

        btnConsultar.setBackground(new java.awt.Color(34, 70, 135));
        btnConsultar.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        btnConsultar.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultar.setText("CONSULTAR");
        btnConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsultar.setFocusable(false);
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(34, 34, 34));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white), "Filtrar", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.white)); // NOI18N

        checkBoxNombre.setBackground(new java.awt.Color(34, 34, 34));
        checkBoxNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkBoxNombre.setForeground(new java.awt.Color(255, 255, 255));
        checkBoxNombre.setText("Nombre del Curso");
        checkBoxNombre.setFocusable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(checkBoxNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBoxNombre)
                    .addComponent(cbxNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnConsultar2.setBackground(new java.awt.Color(34, 70, 135));
        btnConsultar2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        btnConsultar2.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultar2.setText("REGRESAR");
        btnConsultar2.setActionCommand("");
        btnConsultar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsultar2.setFocusable(false);
        btnConsultar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultar2ActionPerformed(evt);
            }
        });

        btnConsultar3.setBackground(new java.awt.Color(34, 70, 135));
        btnConsultar3.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        btnConsultar3.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultar3.setText("IMPRIMIR REPORTE");
        btnConsultar3.setActionCommand("");
        btnConsultar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsultar3.setFocusable(false);
        btnConsultar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultar3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 148, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chooserDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chooserHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnConsultar2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConsultar3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(chooserHasta, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chooserDesde, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(2, 2, 2)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultar2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 913, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed

        Date fechaDesde = chooserDesde.getDate();
        Date fechaHasta = chooserHasta.getDate();

        if(fechaDesde != null && fechaHasta != null){
            formato = new SimpleDateFormat("yyyy-MM-dd");

            String a = formato.format(fechaDesde);
            dateDesde = LocalDate.parse(a);

            a = formato.format(fechaHasta);
            dateHasta = LocalDate.parse(a);

            if((dateHasta.getYear() >= dateDesde.getYear())
                && (dateHasta.getMonthValue() >= dateDesde.getMonthValue())
                && (dateHasta.getDayOfMonth() >= dateDesde.getDayOfMonth())){

                listaReporte = null;
                daoRegistro = manager.getDaoRegistro();
                listaReporte = daoRegistro.obtenerReporteCursoEntreFechas(java.sql.Date.valueOf(dateDesde),java.sql.Date.valueOf(dateHasta));

                if(listaReporte.isEmpty()){
                    DialogMensaje.Informacion(null,"No se encontraron registros");
                }else{

                    listaAux = new ArrayList<>();

                    if(nombreCursoSelected){
                        String nombreCurso = cbxNombre.getSelectedItem().toString();
                        listaReporte.stream().filter((rc) -> (rc.getRegistroCurso().getNombreCurso().equals(nombreCurso))).forEachOrdered((r) -> {
                            listaAux.add(r);
                        });

                        listaReporte = listaAux;
                        listaAux = new ArrayList<>();
                    }

                    limpiarTabla();
                    mostrarReporte(listaReporte);
                }

            }else{
                DialogMensaje.Error(null,"La fechas estan incorrectas");
            }

        }else{
            DialogMensaje.Error(null,"Escoga la fechas");
        } 
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnConsultar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultar2ActionPerformed
        cambiarPanel(new subPanelHistorialPrincipal());
    }//GEN-LAST:event_btnConsultar2ActionPerformed

    private void btnConsultar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultar3ActionPerformed

    
    public void mostrarReporte(List<ReporteRegistroCurso> lista){
        lista.forEach((ReporteRegistroCurso r)->{
            model.addRow(new Object[]{
                r.getCurso().getNombre(),
                r.getRegistroCurso().getHoraInicio(),
                r.getRegistroCurso().getHoraFin(),
                r.getRegistroCurso().getFecha()
            });
        });
    }
    
    public void limpiarTabla(){
        int cant = model.getRowCount();
        int i;
        
        for(i=0; i<cant; i++){
            model.removeRow(0);
        }
    }
    
    public boolean validarCodigoSinEspacios(String codigo){
        int i;
        for(i=0; i< codigo.length(); i++){
            if(codigo.charAt(i) == ' '){
                return false;
            }
        }
        return true;
    }
    
    public boolean validarCodigoPurosNumeros(String codigo){
        int i,j;
        boolean band;
        for(i=0; i< codigo.length(); i++){
            band =false;
            for(j=0; j<caracteresValidos.length(); j++){
                if(codigo.charAt(i) == caracteresValidos.charAt(j)){
                    band= true;
                }
            }
            
            if(band == false){
                return false;
            } 
        }
        return true;
    }
     
    public void eliminarDatosTabla(){
        int i;
        int cant = model.getRowCount();
        for(i=0; i< cant; i++){
            model.removeRow(0);
        }
    }

    public void cargarCbxCursos(){
        daoCurso = manager.getDaoCurso();
        listaCursos = daoCurso.obtenerTodos();
        
        listaCursos.forEach((curso)->{
            cbxNombre.addItem(curso.getNombre());
        });
        
    }
    
    public void cambiarPanel(JPanel panelElegido){
        panelElegido.setSize(911, 474);
        panelElegido.setLocation(1, 2);
        panelSesiones.removeAll();
        panelSesiones.add(panelElegido,BorderLayout.CENTER);
        panelSesiones.revalidate();
        panelSesiones.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnConsultar2;
    private javax.swing.JButton btnConsultar3;
    private javax.swing.JComboBox<String> cbxNombre;
    private javax.swing.JCheckBox checkBoxNombre;
    private com.toedter.calendar.JDateChooser chooserDesde;
    private com.toedter.calendar.JDateChooser chooserHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaHistorial;
    // End of variables declaration//GEN-END:variables
}
