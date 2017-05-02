
package dao.mysql;

import dao.DaoContadorRegistro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import vistas.DialogMensaje;

public class MysqlDaoContadorRegistro implements DaoContadorRegistro{

    private Connection conexion;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    private String obtenerCantidadUsuarios = "select cantidad from contadorRegistro where tipo = 'usuario'";
    private String obtenerCantidadHistorial = "select cantidad from contadorRegistro where tipo = 'historial'";
    
    public MysqlDaoContadorRegistro(Connection connection) {
        this.conexion = connection;
    }

    @Override
    public String obtenerContadorUsuario() {
        try {
            preparedStatement = conexion.prepareStatement(obtenerCantidadUsuarios);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return String.valueOf(resultSet.getInt("cantidad"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            DialogMensaje.Error(null,"Error en la conexión con la base de datos");
            System.exit(0);
        }finally{
            MysqlUtils.cerrarPreparedStatementAndResultSet(preparedStatement, resultSet);
        }
        
        return null;
    }

    @Override
    public String obtenerContadorHistorial() {
        try {
            preparedStatement = conexion.prepareStatement(obtenerCantidadHistorial);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return String.valueOf(resultSet.getInt("cantidad"));
            }
        } catch (SQLException e) {
            DialogMensaje.Error(null,"Error en la conexión con la base de datos");
            System.exit(0);
        }finally{
            MysqlUtils.cerrarPreparedStatementAndResultSet(preparedStatement, resultSet);
        }
        
        return null;    
    }

    
}
