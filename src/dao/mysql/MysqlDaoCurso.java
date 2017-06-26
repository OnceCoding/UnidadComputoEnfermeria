package dao.mysql;

import dao.DaoCurso;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Curso;
import vistas.DialogMensaje;

public class MysqlDaoCurso implements DaoCurso{

    private Connection conexion;
    private PreparedStatement preparedStatement;
    private ResultSet resulSet;
    private Curso curso;
    
    private Integer codigo;
    private String nombre;
    private List<Curso> listacursos;
    
    private final String insertar = "insert into curso(nombre) values(?)";
    private final String obtener = "select codigo,nombre from curso where codigo = ?";
    private final String obtenerPorNombre = "select codigo,nombre from curso where nombre = ?";
    private final String obtenerTodos = "select codigo,nombre from curso order by codigo desc";
    private final String obtenerContador = "select count(codigo) as cantidad from curso";
    private final String eliminar = "delete from curso where codigo = ?";
    private final String actualizar = "update curso set nombre = ? where codigo = ?";
    
    public MysqlDaoCurso(Connection conexion){
        this.conexion = conexion;
    }
    
    @Override
    public void insertar(Curso curso) {
        try {
            preparedStatement = conexion.prepareStatement(insertar);
            preparedStatement.setString(1,curso.getNombre());
            if(preparedStatement.executeUpdate() != 0){
                //JOptionPane.showMessageDialog(null,"Curso Registrado");
            }
            
        } catch (HeadlessException | SQLException e) {
            DialogMensaje.Error(null,"Error en la conexión con la base de datos");
            System.exit(0);
        }finally{
            MysqlUtils.cerrarPreparedStatement(preparedStatement);
        }
    }

    @Override
    public void eliminar(Integer codigo) {
        try {
            preparedStatement = conexion.prepareStatement(eliminar);
            preparedStatement.setInt(1,codigo);
            if(preparedStatement.executeUpdate() != 0){
                DialogMensaje.Informacion(null,"Se elimino el curso exitosamente");
                //JOptionPane.showMessageDialog(null,"Se elimino el Curso");
            }
            
        } catch (HeadlessException | SQLException e) {
           DialogMensaje.Error(null,"Error en la conexión con la base de datos");
            System.exit(0);
        } finally{
            MysqlUtils.cerrarPreparedStatement(preparedStatement);
        }
    }

    @Override
    public void actualizar(Curso curso) {
        try {
            preparedStatement = conexion.prepareStatement(actualizar);
            preparedStatement.setString(1,curso.getNombre());
            preparedStatement.setInt(2,curso.getCodigo());
            if(preparedStatement.executeUpdate() != 0){
                //JOptionPane.showMessageDialog(null,"Se Modifico el nombre el Curso");
            }
            
        } catch (HeadlessException | SQLException e) {
            System.out.println(e.getMessage());
            DialogMensaje.Error(null,"Error en la conexión con la base de datos");
            System.exit(0);
        } finally{
            MysqlUtils.cerrarPreparedStatement(preparedStatement);
        }
    }

    @Override
    public Curso obtener(Integer codigo) {
        try {
            preparedStatement = conexion.prepareStatement(obtener);
            preparedStatement.setInt(1, codigo);
            resulSet = preparedStatement.executeQuery();
            
            if(resulSet.next()){
                return new Curso(null,resulSet.getString("nombre"));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            DialogMensaje.Error(null,"Error en la conexión con la base de datos");
            System.exit(0);
        } finally{
            MysqlUtils.cerrarPreparedStatementAndResultSet(preparedStatement, resulSet);
        }
        
        return null;
    }

    public Curso convertirResultSetAcurso(ResultSet rs){
        
        try {
            codigo = rs.getInt("codigo");
            nombre = rs.getString("nombre");
            
            return new Curso(codigo, nombre);
            
        } catch (SQLException e) {
            System.out.println("Error al convertir");
            DialogMensaje.Error(null,"Error en la conexión con la base de datos");
            System.exit(0);
        }
        
        return null;
    }
    
    
    @Override
    public List<Curso> obtenerTodos() {
        try {
            listacursos = null;
            listacursos = new ArrayList<>();
            preparedStatement = conexion.prepareStatement(obtenerTodos);
            resulSet = preparedStatement.executeQuery();
            
            while(resulSet.next()){
                listacursos.add(convertirResultSetAcurso(resulSet));
            }
            
            return listacursos;
            
        } catch (SQLException e) {
            DialogMensaje.Error(null,"Error en la conexión con la base de datos");
            System.exit(0);
        }
    
        return null;
    }

    @Override
    public String obtenerContadorCursos() {
        try {
            preparedStatement = conexion.prepareStatement(obtenerContador);
            resulSet = preparedStatement.executeQuery();
            
            if(resulSet.next()){
                return String.valueOf(resulSet.getInt("cantidad"));
            }
            
        } catch (SQLException e) {
            DialogMensaje.Error(null,"Error en la conexión con la base de datos");
            System.exit(0);
        }
        
        return null;
    }

    @Override
    public Curso obtenerPorNombre(String nombre) {
        try {
            preparedStatement = conexion.prepareStatement(obtenerPorNombre);
            preparedStatement.setString(1,nombre);
            resulSet = preparedStatement.executeQuery();
            
            if(resulSet.next()){
                return new Curso(resulSet.getInt("codigo"),resulSet.getString("nombre"));
            }
            
        } catch (SQLException e) {
            System.out.println("Error al obtener Curso");
            DialogMensaje.Error(null,"Error en la conexión con la base de datos");
            System.exit(0);
        }
        
        return null;
    }
    
}
