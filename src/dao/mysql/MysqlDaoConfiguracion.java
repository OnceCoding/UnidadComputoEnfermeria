package dao.mysql;

import dao.DaoConfiguracion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.ConfiguracionSemestre;
import vistas.DialogMensaje;

public class MysqlDaoConfiguracion implements DaoConfiguracion{

    private Connection conexion;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    private final String obtenerPrimerSemestre = "select mesInicio,mesFin,año from configuracionSemestre where codigo = 1";
    private final String obtenerSegundoSemestre = "select mesInicio,mesFin,año from configuracionSemestre where codigo = 2  ";
    private final String actualizarPrimerSemestre = "update configuracionSemestre set mesInicio = ?, mesFin = ?, año = ? where codigo = 1";
    private final String actualizarSegundoSemestre = "update configuracionSemestre set mesInicio = ?, mesFin = ?, año = ? where codigo = 2";

    public MysqlDaoConfiguracion(Connection conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public ConfiguracionSemestre obtenerDatosPrimerSemestre() {
        try {
            preparedStatement = conexion.prepareStatement(obtenerPrimerSemestre);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new ConfiguracionSemestre(null,resultSet.getString("mesInicio"),resultSet.getString("mesfin"),resultSet.getString("año"));
            }
        } catch (SQLException e) {
            System.out.println("Error obteniendo datos semestre 1");
            DialogMensaje.Error(null,"Error en la conexión con la base de datos");
            System.exit(0);
        }
        return null;
    }

    @Override
    public void actualizarDatosPrimerSemestre(ConfiguracionSemestre configuracionSemestre) {
        try {
            preparedStatement = conexion.prepareStatement(actualizarPrimerSemestre);
            preparedStatement.setString(1, configuracionSemestre.getMesInicio());
            preparedStatement.setString(2, configuracionSemestre.getMesFinal());
            preparedStatement.setString(3, configuracionSemestre.getAño());
            
            if(preparedStatement.executeUpdate() != 0){
                System.out.println("actualizo semestre 1");
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            DialogMensaje.Error(null,"Error en la conexión con la base de datos");
            System.exit(0);
        }
    }

    @Override
    public ConfiguracionSemestre obtenerDatosSegundoSemestre() {
        try {
            preparedStatement = conexion.prepareStatement(obtenerSegundoSemestre);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new ConfiguracionSemestre(null,resultSet.getString("mesInicio"),resultSet.getString("mesfin"),resultSet.getString("año"));
            }
        } catch (SQLException e) {
            System.out.println("Error obteniendo datos semestre 1");
            DialogMensaje.Error(null,"Error en la conexión con la base de datos");
            System.exit(0);
        }
        return null;
    }

    @Override
    public void actualizarDatosSegundoSemestre(ConfiguracionSemestre configuracionSemestre) {
        try {
            preparedStatement = conexion.prepareStatement(actualizarSegundoSemestre);
            preparedStatement.setString(1, configuracionSemestre.getMesInicio());
            preparedStatement.setString(2, configuracionSemestre.getMesFinal());
            preparedStatement.setString(3, configuracionSemestre.getAño());
            
            if(preparedStatement.executeUpdate() != 0){
                System.out.println("actualizo semestre 2");
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            DialogMensaje.Error(null,"Error en la conexión con la base de datos");
            System.exit(0);
        }
    }
    
    
    
}
