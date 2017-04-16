package dao.mysql;

import dao.DaoCurso;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Curso;

public class MysqlDaoCurso implements DaoCurso{

    private Connection conexion;
    private PreparedStatement preparedStatement;
    private ResultSet resulSet;
    private Curso curso;
    
    private final String insertar = "insert into curso(nombre) values(?)";
    
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
        DaoCurso.super.eliminar(curso); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Curso curso) {
        DaoCurso.super.actualizar(curso); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object obtener(Integer key) {
        return DaoCurso.super.obtener(key); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Curso> obtenerTodos() {
        return DaoCurso.super.obtenerTodos(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
