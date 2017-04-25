package dao.mysql;

import dao.DaoRegistro;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import modelo.Curso;
import modelo.Registro;
import modelo.RegistroCurso;
import modelo.ReporteRegistroCurso;
import modelo.ReporteRegistroUsuario;
import modelo.Usuario;
import vistas.DialogMensaje;

public class MysqlDaoRegistro implements DaoRegistro{
    
    private Connection conexion;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Registro registro;
    
    private final String insertar = 
            "insert into registro(codUsuario,codPC,horaInicio,horaFin,fecha) values(?,?,?,?,?)";

    private final String eliminarTodosRegistroDeUnUsuario = "delete from registro where codUsuario = ?";
    
    private final String obtenerReporteEntreFechas = 
            "select u.codigo, u.nombre, u.apellido, u.tipo , r.codPC, r.horaInicio, r.horaFin, r.fecha from registro r inner join "
            + "usuario u on r.codUsuario = u.id where r.fecha between ? and ? ";
    
    private final String obtenerReporteCursosEntreFechas = 
            "select c.nombre, rc.horaInicio, rc.horaFin, rc.fecha from registrocurso rc inner join "
            + "curso c on rc.codCurso = c.codigo where rc.fecha between ? and ? ";

    private List<Registro> listaUsuarios;
    private List<ReporteRegistroUsuario> listaRegistroUsuarios;
    private List<ReporteRegistroCurso> listaRegistroCursos;
    
    public MysqlDaoRegistro(Connection conexion) {
        this.conexion = conexion;
        listaUsuarios = new ArrayList<>();
    }
    
    public Registro convertirResultSetToRegistro(ResultSet rs){
        try {
            Integer codigo = rs.getInt("codigo");
            Integer codUsuario = rs.getInt("codUsuario");
            String codPC = rs.getString("codPC");
            Time horaInicio = rs.getTime("horaInicio");
            Time horaFin = rs.getTime("horaFin");
            Date fecha = rs.getDate("fecha");
            
            return new Registro(codigo, codUsuario, codPC, horaInicio, horaFin, fecha);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
        
    }
    
    public RegistroCurso convertirResultSetToRegistroCurso(ResultSet rs){
        try {
            String nombreCurso = rs.getString("nombre");
            Time horaInicio = rs.getTime("horaInicio");
            Time horaFin = rs.getTime("horaFin");
            Date fecha = rs.getDate("fecha");
            
            return new RegistroCurso(nombreCurso, horaInicio, horaFin, fecha);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
        
    }
    
    @Override
    public void insertar(Registro registro) {
        try {
            preparedStatement = conexion.prepareStatement(insertar);
            preparedStatement.setInt(1,registro.getCodUsuario());
            preparedStatement.setString(2, registro.getCodPC());
            preparedStatement.setTime(3, registro.getHoraInicio());
            preparedStatement.setTime(4, registro.getHoraFin());
            preparedStatement.setDate(5, registro.getFecha());
            
            if(preparedStatement.executeUpdate() == 0){
                System.out.println("No se pudo insertar");
            }
            
            
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null,"No se pudo registrar");
            System.out.println(e.getMessage());
        } finally{
            MysqlUtils.cerrarPreparedStatement(preparedStatement);
        }
    }

    @Override
    public void eliminarTodosLosRegistrosDeUnUsuario(Integer codigo) {
        try {
            preparedStatement = conexion.prepareStatement(eliminarTodosRegistroDeUnUsuario);
            preparedStatement.setInt(1, codigo);
            if(preparedStatement.executeUpdate() != 0){
                System.out.println("eliminados todos los registros");
            }
        } catch (SQLException e) {
            System.out.println("error eliminando todos los registros");
        }
    }

    public ReporteRegistroUsuario convertirResultSetToReporteUsuario(ResultSet rs){
        try {
            String codigoUsuario = rs.getString("codigo");
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String tipo = rs.getString("tipo");
            String pc = rs.getString("codPc");
            Time horaInicio = rs.getTime("horaInicio");
            Time horaFin = rs.getTime("horaFin");
            Date fecha = rs.getDate("fecha");
            
            return new ReporteRegistroUsuario(
                    new Usuario(null, codigoUsuario, nombre, apellido, null, tipo, null, null), 
                    new Registro(null,null, pc, horaInicio, horaFin, fecha));
            
        } catch (SQLException e) {
            System.out.println("Error conviertiendo");
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public ReporteRegistroCurso convertirResultSetToReporteCurso(ResultSet rs){
        try {
            String nombreCurso = rs.getString("nombre");
            Time horaInicio = rs.getTime("horaInicio");
            Time horaFin = rs.getTime("horaFin");
            Date fecha = rs.getDate("fecha");
            
            return new ReporteRegistroCurso(
                    new Curso(null, nombreCurso), 
                    new RegistroCurso(nombreCurso, horaInicio, horaFin, fecha));
            
        } catch (SQLException e) {
            System.out.println("Error conviertiendo");
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    @Override
    public List<ReporteRegistroUsuario> obtenerReporteEntreFechas(Date inicio, Date fin) {
        try {
            
            listaRegistroUsuarios = null;
            listaRegistroUsuarios = new ArrayList<>();
            
            preparedStatement = conexion.prepareStatement(obtenerReporteEntreFechas);
            preparedStatement.setDate(1, inicio);
            preparedStatement.setDate(2, fin);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                listaRegistroUsuarios.add(convertirResultSetToReporteUsuario(resultSet));
            }
            
            return listaRegistroUsuarios;
     
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            DialogMensaje.Error(null,"No se puede obtener reporte");
        }
        
        return null;
        
    }

    @Override
    public List<ReporteRegistroCurso> obtenerReporteCursoEntreFechas(Date inicio, Date fin) {
        try {
            
            listaRegistroCursos = null;
            listaRegistroCursos = new ArrayList<>();
            
            preparedStatement = conexion.prepareStatement(obtenerReporteCursosEntreFechas);
            preparedStatement.setDate(1, inicio);
            preparedStatement.setDate(2, fin);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                listaRegistroCursos.add(convertirResultSetToReporteCurso(resultSet));
            }
            
            return listaRegistroCursos;
     
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            DialogMensaje.Error(null,"No se puede obtener reporte");
        }
        
        return null;
        
    }

}
