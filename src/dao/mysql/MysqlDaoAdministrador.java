package dao.mysql;

import dao.DaoAdministrador;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Administrador;
import vistas.DialogMensaje;

public class MysqlDaoAdministrador implements DaoAdministrador{
    
    private Connection conexion;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Administrador administrador;
    
    private final String actualizarUsuario = "update administrador set user = ? where codigo = 1";
    private final String actualizarContraseña = "update administrador set pass = ? where codigo = 1";
   
    private final String obtener = "select user,pass from administrador where codigo = 1";

    public MysqlDaoAdministrador(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public Administrador obtener() {
        try {
            preparedStatement = conexion.prepareStatement(obtener);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                administrador = convertirResultSetToAdministrador(resultSet);
                return administrador;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        } finally{
            MysqlUtils.cerrarPreparedStatementAndResultSet(preparedStatement, resultSet);
        }
        
        return null;
    }

    public Administrador convertirResultSetToAdministrador(ResultSet rs){
        try {
            String user = rs.getString("user");
            String pass = rs.getString("pass");
            administrador = new Administrador(1, user, pass);
            return administrador;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public void actualizarUsuario(Administrador administrador) {
        try {
            preparedStatement = conexion.prepareStatement(actualizarUsuario);
            preparedStatement.setString(1,administrador.getUser());
            
            if(preparedStatement.executeUpdate()!= 0){
                DialogMensaje.Informacion(null,"Usuario Actualizado Exitosamente");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            //JOptionPane.showMessageDialog(null,"Ocurrio una Accion inesperada");
            System.exit(0);
        }finally{
            MysqlUtils.cerrarPreparedStatement(preparedStatement);
        }
    }

    @Override
    public void actualizarContraseña(Administrador administrador) {
        
        try {
            preparedStatement = conexion.prepareStatement(actualizarContraseña);
            preparedStatement.setString(1,administrador.getPass());
            
            if(preparedStatement.executeUpdate()!= 0){
                DialogMensaje.Informacion(null,"Contraseña Actualizada Exitosamente");
            }else{
                //JOptionPane.showMessageDialog(null,"No se pudo Actualizar");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
            //JOptionPane.showMessageDialog(null,"Ocurrio una Accion inesperada");
        }finally{
            MysqlUtils.cerrarPreparedStatement(preparedStatement);
        }
    }


}
