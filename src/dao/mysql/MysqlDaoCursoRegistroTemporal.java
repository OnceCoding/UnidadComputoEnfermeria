package dao.mysql;

import dao.DaoCursoRegistroTemporal;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import modelo.CursoRegistroTemporal;
import vistas.DialogMensaje;


public class MysqlDaoCursoRegistroTemporal implements DaoCursoRegistroTemporal{

    private Connection conexion;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private final String iniciarSesion = "insert into registrocursotemporal(codCurso,horaInicio,fecha) values(?,?,?)";
    private final String obtenercursoActual = "select codigo,codCurso,horaInicio,fecha from registrocursotemporal";
    private final String cerrarSesion = "delete from registroCursoTemporal";
    private final String existeCursoActual = "select count(codigo) as cantidad from registroCursoTemporal";
    private final String actualizarHoraInicio = "update registroCursoTemporal set horaInicio = ?";
    
    public MysqlDaoCursoRegistroTemporal(Connection conexion) {
        this.conexion = conexion;
    }
    

    @Override
    public CursoRegistroTemporal obtenerCursoActual() {
        try {
            preparedStatement = conexion.prepareStatement(obtenercursoActual);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new CursoRegistroTemporal(
                        resultSet.getInt("codigo"),
                        resultSet.getInt("codCurso"),
                        resultSet.getTime("horaInicio"),
                        resultSet.getDate("fecha"));
            }
        } catch (SQLException e) {
            System.out.println("Error obteniendo curso actual");
            DialogMensaje.Error(null,"Error en la conexión con la base de datos");
            System.exit(0);
        } finally{
            MysqlUtils.cerrarPreparedStatementAndResultSet(preparedStatement, resultSet);
        }
        return null;
    }

    @Override
    public void cerrarSesionCursoActual() {
        try {
            preparedStatement = conexion.prepareStatement(cerrarSesion);
            if(preparedStatement.executeUpdate() != 0){
                DialogMensaje.Informacion(null,"El curso cerró sesión");
                //JOptionPane.showMessageDialog(null,"curso cerro sesion");
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error cerrando curso");
            DialogMensaje.Error(null,"Error en la conexión con la base de datos");
            System.exit(0);
        }finally{
            MysqlUtils.cerrarPreparedStatement(preparedStatement);
        }
    }

    @Override
    public void iniciarSesion(CursoRegistroTemporal registroCursoTemporal) {
        try {
            preparedStatement = conexion.prepareStatement(iniciarSesion);
            preparedStatement.setInt(1, registroCursoTemporal.getCodCurso());
            preparedStatement.setTime(2, registroCursoTemporal.getHoraInicio());
            preparedStatement.setDate(3, registroCursoTemporal.getFecha());
            
            if(preparedStatement.executeUpdate() != 0){
                //JOptionPane.showMessageDialog(null,"Inicio Sesion el curso");
            }
            
        } catch (SQLException e) {
            System.out.println("error inciar sesion curso");
            DialogMensaje.Error(null,"Error en la conexión con la base de datos");
            System.exit(0);
        } finally{
            MysqlUtils.cerrarPreparedStatement(preparedStatement);
        }
    }

    @Override
    public Integer existeCursoActual() {
        try {
            preparedStatement = conexion.prepareStatement(existeCursoActual);
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                return resultSet.getInt("cantidad");
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            DialogMensaje.Error(null,"Error en la conexión con la base de datos");
            System.exit(0);
        } finally{
            MysqlUtils.cerrarPreparedStatementAndResultSet(preparedStatement, resultSet);
        }
        return 0;
    }

    @Override
    public void modificarSesionCursoHoraInicio(Time horaInicio) {
        try {
            preparedStatement = conexion.prepareStatement(actualizarHoraInicio);
            preparedStatement.setTime(1, horaInicio);
            
            if(preparedStatement.executeUpdate() != 0){
                DialogMensaje.Informacion(null,"Se actualizo hora de inicio");
                //JOptionPane.showMessageDialog(null,"Actualizo hora de Inicio");
            }
            
        } catch (HeadlessException | SQLException e) {
            System.out.println(e.getMessage());
            DialogMensaje.Error(null,"Error en la conexión con la base de datos");
            System.exit(0);
        } finally{
            MysqlUtils.cerrarPreparedStatement(preparedStatement);
        }
    }


    
}
