package dao.mysql;

import dao.DaoComputadora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Computadora;
import vistas.DialogMensaje;

public class MysqlDaoComputadora implements DaoComputadora{

    private Connection conexion;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Computadora computadora;

    private final String obtener = "select codigo,estado from computadora where codigo = ? ";
    private final String actualizar = "update computadora set estado = ? where codigo = ? ";
    private final String eliminar = "delete from computadora where codigo = ? ";
    private final String insertar = "insert into computadora(codigo,estado) values(?,?)";
    private final String obtenerTodos = "select codigo,estado from computadora order by codigo";
    private final String contadorComputadoras = "select count(codigo) as cantidad from computadora";
    
    private List<Computadora> listaComputadoras;
    
    public MysqlDaoComputadora(Connection conexion) {
        this.conexion = conexion;
        listaComputadoras = new ArrayList<>();
    }
    
    @Override
    public Computadora obtener(String key) {
        try {
            preparedStatement = conexion.prepareStatement(obtener);
            preparedStatement.setString(1,key);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                computadora = convertirResultSetToComputadora(resultSet);
                return computadora;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            DialogMensaje.Error(null,"Error en la conexion con la base de datos");
            System.exit(0);
        } finally{
            MysqlUtils.cerrarPreparedStatementAndResultSet(preparedStatement, resultSet);
        }
        
        return null;
    }
    
    @Override
    public List<Computadora> obtenerTodos() {
        listaComputadoras = null;
        listaComputadoras = new ArrayList<>();
        try {
            preparedStatement = conexion.prepareStatement(obtenerTodos);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                listaComputadoras.add(convertirResultSetToComputadora(resultSet));
            }
            
            return listaComputadoras;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            DialogMensaje.Error(null,"Error en la conexion con la base de datos");
            System.exit(0);
        } finally{
            MysqlUtils.cerrarPreparedStatementAndResultSet(preparedStatement, resultSet);
        }
        
        return null;
    }
    
    public Computadora convertirResultSetToComputadora(ResultSet rs){
        try {
            Integer codigo = rs.getInt("codigo");
            String estado = rs.getString("estado");
            
            return new Computadora(codigo,estado);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            DialogMensaje.Error(null,"Error en la conexion con la base de datos");
            System.exit(0);
        }
        
        return null;
    }

    @Override
    public void actualizar(Computadora computadora) {
        try {
            preparedStatement = conexion.prepareStatement(actualizar);
            preparedStatement.setString(1,computadora.getEstado());
            preparedStatement.setInt(2,computadora.getCodigo());
            
            if(preparedStatement.executeUpdate()!= 0){
                DialogMensaje.Informacion(null,"Actualizado exitosamente");
                //JOptionPane.showMessageDialog(null,"Actualizado Exitosamente");
            }else{
                //JOptionPane.showMessageDialog(null,"No se pudo actualizar");
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            DialogMensaje.Error(null,"Error en la conexion con la base de datos");
            System.exit(0);
        } finally{
            MysqlUtils.cerrarPreparedStatement(preparedStatement);
        }
    }

    @Override
    public void eliminar(Computadora computadora) {
        try {
            preparedStatement = conexion.prepareStatement(eliminar);
            preparedStatement.setInt(1,computadora.getCodigo());
            if(preparedStatement.executeUpdate()!= 0){
                DialogMensaje.Informacion(null,"Eliminado exitosamente");
                //JOptionPane.showMessageDialog(null,"Eliminado Exitosamente","Equipo",JOptionPane.WARNING_MESSAGE);
            }else{
                //JOptionPane.showMessageDialog(null,"No se pudo eliminar");
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            DialogMensaje.Error(null,"Error en la conexion con la base de datos");
            System.exit(0);
        } finally{
            MysqlUtils.cerrarPreparedStatement(preparedStatement);
        }
    }

    @Override
    public void insertar(Computadora computadora) {
        try {
            preparedStatement = conexion.prepareStatement(insertar);
            preparedStatement.setInt(1, computadora.getCodigo());
            preparedStatement.setString(2,computadora.getEstado());
            if(preparedStatement.executeUpdate()!= 0){
                DialogMensaje.Informacion(null,"Registrado exitosamente");
                //JOptionPane.showMessageDialog(null,"Registrado Exitosamente","Equipo",JOptionPane.INFORMATION_MESSAGE);
                
            }else{
                //JOptionPane.showMessageDialog(null,"No se pudo Registrar","Equipo",JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            DialogMensaje.Error(null,"Error en la conexion con la base de datos");
            System.exit(0);
        } finally{
            MysqlUtils.cerrarPreparedStatement(preparedStatement);
        }
    }

    @Override
    public String contadorNroComputadoras() {
        try {
            preparedStatement = conexion.prepareStatement(contadorComputadoras);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getString("cantidad");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            //JOptionPane.showMessageDialog(null,"Ocurrio una accion inesperada","Equipo",JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

}
