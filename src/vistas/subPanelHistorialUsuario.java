package vistas;

import vistas.*;
import com.toedter.calendar.JTextFieldDateEditor;
import dao.DaoComputadora;
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
import modelo.Computadora;
import modelo.ReporteRegistroUsuario;
import static vistas.panelHistorialInicio.panelSesiones;

public class subPanelHistorialUsuario extends javax.swing.JPanel {

    private String caracteresValidos = "1234567890";
    
    private final String estadoDisponible = "Disponible";
    private final String estadoNoDisponible = "No-Disponible";
    
    private DaoRegistro daoRegistro;
    private DaoManager manager;
    private DaoComputadora daoComputadora;
    
    private List<ReporteRegistroUsuario> listaReporte;
    private List<Computadora> listaComputadoras;
    private List<ReporteRegistroUsuario> listaAux;
    
    private DefaultTableModel model;
    private DefaultTableCellRenderer renderer;
    
    
    private boolean equipoSelected = false;
    private boolean tipoSelected = false;
    private boolean codigoSelected = false;
    
    private LocalDate dateDesde;
    private LocalDate dateHasta;
    private SimpleDateFormat formato;
    
    public subPanelHistorialUsuario() {
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
        
        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Equipo");
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
        
        cbxEquipo.setEnabled(false);
        cbxTipo.setEnabled(false);
        txtCodigo.setEnabled(false);
        
        checkBoxEquipo.addActionListener((ActionEvent e) -> {
            equipoSelected = !equipoSelected;
            cbxEquipo.setEnabled(equipoSelected);
        });
        
        checkBoxTipo.addActionListener((ActionEvent e)->{
            tipoSelected = !tipoSelected;
            cbxTipo.setEnabled(tipoSelected);
        });
        
        checkBoxCodigo.addActionListener((ActionEvent e)->{
            codigoSelected = !codigoSelected;
            txtCodigo.setEnabled(codigoSelected);
        });
        
        JTextFieldDateEditor editor = (JTextFieldDateEditor) chooserDesde.getDateEditor();
        editor.setEditable(false);
        
        editor = (JTextFieldDateEditor) chooserHasta.getDateEditor();
        editor.setEditable(false);
        
        cargarCbxEquipos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaHistorial = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        chooserDesde = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        chooserHasta = new com.toedter.calendar.JDateChooser();
        btnConsultar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        checkBoxEquipo = new javax.swing.JCheckBox();
        cbxEquipo = new javax.swing.JComboBox<>();
        checkBoxTipo = new javax.swing.JCheckBox();
        cbxTipo = new javax.swing.JComboBox<>();
        checkBoxCodigo = new javax.swing.JCheckBox();
        txtCodigo = new javax.swing.JTextField();
        btnConsultar2 = new javax.swing.JButton();
        btnConsultar3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(34, 34, 34));
        setDoubleBuffered(false);
        setMaximumSize(new java.awt.Dimension(918, 476));
        setMinimumSize(new java.awt.Dimension(913, 445));
        setPreferredSize(new java.awt.Dimension(913, 445));

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

        jPanel1.setBackground(new java.awt.Color(34, 34, 34));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white), "Filtrar", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.white)); // NOI18N

        checkBoxEquipo.setBackground(new java.awt.Color(34, 34, 34));
        checkBoxEquipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkBoxEquipo.setForeground(new java.awt.Color(255, 255, 255));
        checkBoxEquipo.setText("Equipo");
        checkBoxEquipo.setFocusable(false);

        cbxEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        checkBoxTipo.setBackground(new java.awt.Color(34, 34, 34));
        checkBoxTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkBoxTipo.setForeground(new java.awt.Color(255, 255, 255));
        checkBoxTipo.setText("Tipo");
        checkBoxTipo.setFocusable(false);

        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estudiante", "Docente"}));

        checkBoxCodigo.setBackground(new java.awt.Color(34, 34, 34));
        checkBoxCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkBoxCodigo.setForeground(new java.awt.Color(255, 255, 255));
        checkBoxCodigo.setText("Codigo Usuario");
        checkBoxCodigo.setFocusable(false);

        txtCodigo.setBackground(new java.awt.Color(34, 34, 34));
        txtCodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCodigo.setForeground(new java.awt.Color(255, 255, 255));
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(checkBoxEquipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(checkBoxTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(checkBoxCodigo)
                .addGap(7, 7, 7)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBoxEquipo)
                    .addComponent(cbxEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(checkBoxCodigo)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkBoxTipo)
                            .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 148, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnConsultar2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConsultar3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(chooserHasta, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chooserDesde, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(2, 2, 2)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultar2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                listaReporte = daoRegistro.obtenerReporteEntreFechas(java.sql.Date.valueOf(dateDesde),java.sql.Date.valueOf(dateHasta));

                if(listaReporte.isEmpty()){
                    DialogMensaje.Informacion(null,"No se encontraron registros");
                }else{

                    listaAux = new ArrayList<>();

                    if(equipoSelected){
                        String pc = cbxEquipo.getSelectedItem().toString();
                        listaReporte.stream().filter((r) -> (r.getRegistro().getCodPC().equals(pc))).forEachOrdered((r) -> {
                            listaAux.add(r);
                        });

                        listaReporte = listaAux;
                        listaAux = new ArrayList<>();
                    }

                    if(tipoSelected){
                        String tipo = cbxTipo.getSelectedItem().toString();
                        listaReporte.stream().filter((r) -> (r.getUsuario().getTipo().equals(tipo))).forEachOrdered((r)->{
                            listaAux.add(r);
                        });

                        listaReporte = listaAux;
                        listaAux = new ArrayList<>();
                    }

                    if(codigoSelected){
                        String codigo = txtCodigo.getText();
                        listaReporte.stream().filter((r)->(r.getUsuario().getCodigo().equals(codigo))).forEachOrdered((r)->{
                            listaAux.add(r);
                        });
                        listaReporte = listaAux;
                        listaAux = null;
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

    public void mostrarReporte(List<ReporteRegistroUsuario> lista){
        lista.forEach((ReporteRegistroUsuario r)->{
            model.addRow(new Object[]{
                r.getUsuario().getCodigo(),
                r.getUsuario().getNombre(),
                r.getUsuario().getApellido(),
                r.getRegistro().getCodPC(),
                r.getRegistro().getHoraInicio(),
                r.getRegistro().getHoraFin(),
                r.getRegistro().getFecha()
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

    public void cargarCbxEquipos(){
        daoComputadora = manager.getDaoComputadora();
        listaComputadoras = daoComputadora.obtenerTodos();
        
        listaComputadoras.forEach((pc)->{
            cbxEquipo.addItem(pc.getCodigo());
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
    private javax.swing.JComboBox<String> cbxEquipo;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JCheckBox checkBoxCodigo;
    private javax.swing.JCheckBox checkBoxEquipo;
    private javax.swing.JCheckBox checkBoxTipo;
    private com.toedter.calendar.JDateChooser chooserDesde;
    private com.toedter.calendar.JDateChooser chooserHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaHistorial;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
