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
    
    private final String insertar = 
            "insert into registro(codUsuario,codPC,horaInicio,horaFin,fecha) values(?,?,?,?,?)";
    private final String obtenerPorPromocionYMes = 
            "select codigo,codUsuario,codPC,horaInicio,horaFin,fecha from registro where codUsuario = '%?'";
    private final String obtenerNroRegistroUsuarioPorFecha = 
            "select usuario.codigo, usuario.nombre, usuario.apellido, usuario.correo,count(registro.codigo) from usuario inner join registro\n" +
        " on registro.codUsuario = usuario.codigo where (month(registro.fecha) = ? and registro.codUsuario like ?) group by usuario.codigo, usuario.nombre, usuario.apellido, usuario.correo";
    
    private final String eliminarTodosRegistroDeUnUsuario = "delete from registro where codUsuario = ?";
    
    private List<Registro> listaUsuarios;
    
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


}
