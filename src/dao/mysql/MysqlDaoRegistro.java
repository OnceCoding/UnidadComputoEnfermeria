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
import javax.swing.JOptionPane;
import modelo.Registro;
import modelo.UsuarioReporte;

public class MysqlDaoRegistro implements DaoRegistro{
    
    private Connection conexion;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Registro registro;
    
    private final String insertar = "insert into registro(codUsuario,codPC,horaInicio,horaFin,fecha) values(?,?,?,?,?)";
    private final String obtener = "select codigo,codUsuario,codPC,horaInicio,horaFin,fecha from registro where codigo = ?";
    private final String obtenerPorPromocionYMes = "select codigo,codUsuario,codPC,horaInicio,horaFin,fecha from registro where codUsuario = '%?'";
    private final String obtenerNroRegistroUsuarioPorFecha = "select usuario.codigo, usuario.nombre, usuario.apellido, usuario.correo,count(registro.codigo) from usuario inner join registro\n" +
        " on registro.codUsuario = usuario.codigo where (month(registro.fecha) = ? and registro.codUsuario like ?) group by usuario.codigo, usuario.nombre, usuario.apellido, usuario.correo";
    
    
    
    private List<Registro> listaUsuarios;
    
    public MysqlDaoRegistro(Connection conexion) {
        this.conexion = conexion;
        listaUsuarios = new ArrayList<>();
    }
    
    public Registro convertirResultSetToRegistro(ResultSet rs){
        try {
            int codigo = rs.getInt("codigo");
            String codUsuario = rs.getString("codUsuario");
            int codPC = rs.getInt("codPC");
            Time horaInicio = rs.getTime("horaInicio");
            Time horaFin = rs.getTime("horaFin");
            Date fecha = rs.getDate("fecha");
            
            return new Registro(codigo, codUsuario, codPC, horaInicio, horaFin, fecha);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
        
    }
    
    @Override
    public Registro obtener(Integer key) {
        try {
            preparedStatement = conexion.prepareStatement(obtener);
            preparedStatement.setInt(1,key);
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                registro = convertirResultSetToRegistro(resultSet);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"Ocurrio una Accion Inesperada");
        } finally{
            MysqlUtils.cerrarPreparedStatementAndResultSet(preparedStatement, resultSet);
        }
        
        return null;
    }

    @Override
    public void eliminar(Registro registro) {}

    @Override
    public void insertar(Registro registro) {
        try {
            preparedStatement = conexion.prepareStatement(insertar);
            preparedStatement.setString(1,registro.getCodUsuario());
            preparedStatement.setInt(2, registro.getCodPC());
            preparedStatement.setTime(3, registro.getHoraInicio());
            preparedStatement.setTime(4, registro.getHoraFin());
            preparedStatement.setDate(5, registro.getFecha());
            
            if(preparedStatement.executeUpdate() == 0){
                System.out.println("No se pudo insertar");
            }
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"No se pudo registrar");
            System.out.println(e.getMessage());
        } finally{
            MysqlUtils.cerrarPreparedStatement(preparedStatement);
        }
    }

    @Override
    public List<UsuarioReporte> obtenerListaRegistrosPorFecha(Date fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void obtenerListaPorSemestre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer obtenerCantidadSesionesActuales() {
        try {
            preparedStatement = conexion.prepareStatement("");
        } catch (Exception e) {
        }
        return null;
    }

}
