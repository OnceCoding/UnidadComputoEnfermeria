package dao.mysql;

import dao.DaoCurso;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Curso;

public class MysqlDaoCurso implements DaoCurso{

    private Connection conexion;
    private PreparedStatement preparedStatement;
    private ResultSet resulSet;
    private Curso curso;
    
    private Integer codigo;
    private String nombre;
    private List<Curso> listacursos;
    
    private final String insertar = "insert into curso(nombre) values(?)";
    private final String obtener = "select codigo,nombre from curso where nombre = ?";
    private final String obtenerTodos = "select codigo,nombre from curso order by codigo desc";
    private final String obtenerContador = "select count(codigo) as cantidad from curso";
    private final String eliminar = "delete from curso where nombre = ?";
    private final String actualizar = "update curso set nombre = ? where nombre = ?";
    
    public MysqlDaoCurso(Connection conexion){
        this.conexion = conexion;
    }
    
    @Override
    public void insertar(Curso curso) {
        try {
            preparedStatement = conexion.prepareStatement(insertar);
            preparedStatement.setString(1,curso.getNombre());
            if(preparedStatement.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null,"Curso Registrado");
            }
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al Registrar");
        }finally{
            MysqlUtils.cerrarPreparedStatement(preparedStatement);
        }
    }

    @Override
    public void eliminar(Curso curso) {
        try {
            preparedStatement = conexion.prepareStatement(eliminar);
            preparedStatement.setString(1,curso.getNombre());
            if(preparedStatement.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null,"Se elimino el Curso");
            }
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al Eliminar");
        }
    }

    @Override
    public void actualizar(Curso curso,String nombreNuevo) {
        try {
            preparedStatement = conexion.prepareStatement(actualizar);
            preparedStatement.setString(1,nombreNuevo);
            preparedStatement.setString(2,curso.getNombre());
            if(preparedStatement.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null,"Se Modifico el nombre el Curso");
            }
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al Modificar");
        }
    }

    @Override
    public Curso obtener(String nombre) {
        try {
            preparedStatement = conexion.prepareStatement(obtener);
            preparedStatement.setString(1, nombre);
            resulSet = preparedStatement.executeQuery();
            
            if(resulSet.next()){
                return new Curso(null,resulSet.getString("nombre"));
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"error al obtener curso");
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
            JOptionPane.showMessageDialog(null,"Error al obtener Todos");
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
            JOptionPane.showMessageDialog(null,"Error al contar Cursos");
        }
        
        return null;
    }
    
}
