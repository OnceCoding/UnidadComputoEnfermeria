
package dao.mysql;

import dao.DaoCursoRegistro;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.CursoRegistro;
import vistas.DialogMensaje;

public class MysqlDaoCursoRegistro implements DaoCursoRegistro{

    private Connection conexion;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private final String registrarSesionCurso = "insert into registroCurso(codCurso,horaInicio,horaFin,fecha) values(?,?,?,?)";
    private final String eliminarRegistrosDeUnCurso = "delete from registroCurso where codCurso = ?";
    
    public MysqlDaoCursoRegistro(Connection conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public void registrarSesionCurso(CursoRegistro registroCurso) {
        try {
            preparedStatement = conexion.prepareStatement(registrarSesionCurso);
            preparedStatement.setInt(1, registroCurso.getCodCurso());
            preparedStatement.setTime(2, registroCurso.getHoraInicio());
            preparedStatement.setTime(3, registroCurso.getHoraFin());
            preparedStatement.setDate(4, registroCurso.getFecha());
            
            if(preparedStatement.executeUpdate() != 0){
                //JOptionPane.showMessageDialog(null,"Se guardo sesion se curso en registro");
            }
            
        } catch (HeadlessException | SQLException e) {
            System.out.println(e.getMessage());
            DialogMensaje.Error(null,"Error en la conexión con la base de datos");
            System.exit(0);
        }
    }

    @Override
    public void eliminarRegistrosDeUnCurso(Integer codigo) {
        try {
            preparedStatement = conexion.prepareStatement(eliminarRegistrosDeUnCurso);
            preparedStatement.setInt(1, codigo);
            
            if(preparedStatement.executeUpdate() != 0){
                //JOptionPane.showMessageDialog(null,"se elimino todos sus registros del curso");
            }
            
        } catch (HeadlessException | SQLException e) {
            System.out.println(e.getMessage());
            DialogMensaje.Error(null,"Error en la conexión con la base de datos");
            System.exit(0);
        }
    }
    
}
