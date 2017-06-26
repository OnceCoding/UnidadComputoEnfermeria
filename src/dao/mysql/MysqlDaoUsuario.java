package dao.mysql;

import dao.DaoUsuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;
import vistas.DialogMensaje;

public class MysqlDaoUsuario implements DaoUsuario{
    
    private Connection conexion;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Usuario usuario = null;

    private final String obtenerPorId = "select id,codigo,nombre,apellido,correo,tipo,fecha,hora from usuario where id = ? ";
    private final String obtenerPorCodigoUsuario = "select id,codigo,nombre,apellido,correo,tipo,fecha,hora from usuario where codigo = ? ";
    private final String actualizar = "update usuario set codigo = ?, nombre = ? , apellido = ?, correo = ? where id = ?";
    private final String eliminar = "delete from usuario where id = ? ";
    private final String insertar = "insert into usuario(codigo,nombre,apellido,correo,tipo,fecha,hora) values(?,?,?,?,?,?,?)";
    private final String obtenerPorApellido = "select id,codigo,nombre,apellido,correo,tipo,fecha,hora from usuario where apellido like ?";
    private final String obtenerUltimosUsuariosRegistrados = "select id,codigo,nombre,apellido,correo,tipo,fecha,hora from usuario "
            + "order by fecha desc, hora desc limit 20";
    
    
    private List<Usuario> listaUsuarios;
    
    public MysqlDaoUsuario(Connection conexion) {
        this.conexion = conexion;
        listaUsuarios = new ArrayList<>();
    }

    @Override
    public Usuario obtenerPorCodigoUsuario(String key) {
        try {
            preparedStatement = conexion.prepareStatement(obtenerPorCodigoUsuario);
            preparedStatement.setString(1,key);
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                usuario = convertirResultSetToUsuario(resultSet);
                return usuario;
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            DialogMensaje.Error(null,"Error en la conexión con la base de datos");
            System.exit(0);
        } finally{
            MysqlUtils.cerrarPreparedStatementAndResultSet(preparedStatement, resultSet);
        }
        
        return null;
    }

    public Usuario convertirResultSetToUsuario(ResultSet rs){
        try {
            Integer id = rs.getInt("id");
            String codigo = rs.getString("codigo");
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String correo = rs.getString("correo");
            String tipo = rs.getString("tipo");
            Date fecha = rs.getDate("fecha");
            Time hora = rs.getTime("hora");
            
            this.usuario = new Usuario(id,codigo, nombre, apellido,correo,tipo,fecha,hora);
            return this.usuario;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return  null;
    }
    
    @Override
    public void actualizar(Usuario usuario) {
        try {
            preparedStatement = conexion.prepareStatement(actualizar);
            preparedStatement.setString(1,usuario.getCodigo());
            preparedStatement.setString(2,usuario.getNombre());
            preparedStatement.setString(3,usuario.getApellido());
            preparedStatement.setString(4,usuario.getCorreo());
            preparedStatement.setInt(5,usuario.getId());
            
            if(preparedStatement.executeUpdate()!= 0){
                //JOptionPane.showMessageDialog(null,"Actualizado Exitosamente");
                DialogMensaje.Informacion(null,"Actualizado exitosamente");
            }else{
                //JOptionPane.showMessageDialog(null,"No se pudo Actualizar");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            DialogMensaje.Error(null,"Error en la conexión con la base de datos");
            System.exit(0);
        } finally{
            MysqlUtils.cerrarPreparedStatement(preparedStatement);
        }
    }

    @Override
    public void eliminar(Usuario usuario) {
        try {
            preparedStatement = conexion.prepareStatement(eliminar);
            preparedStatement.setInt(1,usuario.getId());
            
            if(preparedStatement.executeUpdate()!= 0){
                //JOptionPane.showMessageDialog(null,"Eliminado Exitosamente");
                DialogMensaje.Informacion(null,"Eliminado exitosamente");
            }else{
                //JOptionPane.showMessageDialog(null,"No se pudo eliminar");
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            DialogMensaje.Error(null,"Error en la conexión con la base de datos");
            System.exit(0);
        } finally{
            MysqlUtils.cerrarPreparedStatement(preparedStatement);
        }
    }

    @Override
    public void insertar(Usuario usuario) {
        try {
            preparedStatement = conexion.prepareStatement(insertar);
            preparedStatement.setString(1,usuario.getCodigo());
            preparedStatement.setString(2,usuario.getNombre());
            preparedStatement.setString(3,usuario.getApellido());
            preparedStatement.setString(4,usuario.getCorreo());
            preparedStatement.setString(5,usuario.getTipo());
            preparedStatement.setDate(6,usuario.getFecha());
            preparedStatement.setTime(7,usuario.getHora());
            
            if(preparedStatement.executeUpdate()!= 0){
                //JOptionPane.showMessageDialog(null,"Registrado Exitosamente","Usuario",JOptionPane.INFORMATION_MESSAGE);
                DialogMensaje.Informacion(null,"Registrado exitosamente");
            }else{
                //JOptionPane.showMessageDialog(null,"No se pudo Registrar");
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            DialogMensaje.Error(null,"Error en la conexión con la base de datos");
            System.exit(0);
        } finally{
            MysqlUtils.cerrarPreparedStatement(preparedStatement);
        }
    }

    @Override
    public List<Usuario> obtenerPorApellido(Usuario usuario) {
        try {
            listaUsuarios = null;
            listaUsuarios = new ArrayList<>();
            preparedStatement = conexion.prepareStatement(obtenerPorApellido);
            preparedStatement.setString(1,"%"+usuario.getApellido()+"%");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                usuario = convertirResultSetToUsuario(resultSet);
                listaUsuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            DialogMensaje.Error(null,"Error en la conexión con la base de datos");
            System.exit(0);
        } finally{
            MysqlUtils.cerrarPreparedStatementAndResultSet(preparedStatement, resultSet);
        }
        
        return listaUsuarios;
        
    }

    @Override
    public List<Usuario> obtenerUltimosRegistros() {
        try {
            listaUsuarios = null;
            listaUsuarios = new ArrayList<>();
            preparedStatement = conexion.prepareStatement(obtenerUltimosUsuariosRegistrados);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                listaUsuarios.add(convertirResultSetToUsuario(resultSet));
            }
            
            return listaUsuarios;
            
        } catch (SQLException ex) {
            DialogMensaje.Error(null,"Error en la conexión con la base de datos");
            System.exit(0);
        } finally{
            MysqlUtils.cerrarPreparedStatementAndResultSet(preparedStatement, resultSet);
        }
        return null;
    }

    @Override
    public Usuario obtenerPorId(Integer key) {
        try {
            preparedStatement = conexion.prepareStatement(obtenerPorId);
            preparedStatement.setInt(1,key);
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                usuario = convertirResultSetToUsuario(resultSet);
                return usuario;
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            DialogMensaje.Error(null,"Error en la conexión con la base de datos");
            System.exit(0);
        } finally{
            MysqlUtils.cerrarPreparedStatementAndResultSet(preparedStatement, resultSet);
        }
        
        return null;
    }

}
