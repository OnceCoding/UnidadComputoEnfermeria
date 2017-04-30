package dao.mysql;

import dao.DaoRegistroTemporal;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Computadora;
import modelo.RegistroTemporal;
import modelo.SesionesActivas;
import modelo.Usuario;
import vistas.DialogMensaje;


public class MysqlDaoRegistroTemporal implements DaoRegistroTemporal{

    private Connection conexion = null;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private SesionesActivas sesionesActivas;
    
    private final String obtenerEquiposDisponibles = 
            "select c.codigo,c.estado from computadora c left join registrotemporal"
            + " r on c.codigo = r.codpc where r.codpc is null and c.estado = 'Disponible'";
    
    private final String insertar = "insert into registroTemporal(codUsuario,codPC,horaInicio,horaFin,fecha) "
            + "values(?,?,?,?,?)";
    
    private final String obtenerNroEquiposDisponibles = 
            "select count(c.codigo) as cantidad from computadora c left join registrotemporal"
            + " r on c.codigo = r.codpc where r.codpc is null and c.estado = 'Disponible' order by c.codigo";
    
    private final String obtenerNroSesionesActivas = "select count(codigo) as cantidad from registroTemporal";
    
    private final String obtenerSesionesActivas = "select r.codigo as rcodigo,u.codigo as ucodigo,r.codPc,r.horaInicio,u.nombre,u.apellido"
            + " from registroTemporal r inner join usuario u on r.codUsuario = u.id";
    
    private final String obtenerRegistroTemporal = 
            "select codigo,codUsuario,codPc,horaInicio,fecha from registroTemporal where codigo = ?";
    
    private final String eliminar = "delete from registroTemporal where codigo = ?";
    
    private final String actualizarEquipo = "update registroTemporal set codPc = ? where codigo = ?";
    
    private final String verificarUsuarioActivo = "select codUsuario from registroTemporal where codUsuario = ?";
    
    private Integer codigo,codPc;
    private String nombre,apellido;
    private String codUsuario;
    private Time horaInicio;
    private Date fecha;
    
    private List<Computadora> listaEquiposDisponibles;
    private List<SesionesActivas> listaSesionesActivas;
    
    public MysqlDaoRegistroTemporal(Connection conexion){
        this.conexion = conexion;
    }
    
    @Override
    public List<Computadora> obtenerEquiposDisponibles() {
        listaEquiposDisponibles = new ArrayList<>();
        try {
            preparedStatement = conexion.prepareStatement(obtenerEquiposDisponibles);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                listaEquiposDisponibles.add(new Computadora(
                        resultSet.getInt("codigo"),resultSet.getString("estado")));
            }
            
            return listaEquiposDisponibles;
            
        } catch (SQLException e) {
            System.out.println("Erro lista");
            System.out.println(e.getMessage());
        }finally{
            MysqlUtils.cerrarPreparedStatementAndResultSet(preparedStatement, resultSet);
        }
        return null;
    }

    @Override
    public void insertar(RegistroTemporal registroTemporal) {
        try {
            preparedStatement = conexion.prepareStatement(insertar);
            preparedStatement.setInt(1,registroTemporal.getCodUsuario());
            preparedStatement.setInt(2,registroTemporal.getCodPC());
            preparedStatement.setTime(3,registroTemporal.getHoraInicio());
            preparedStatement.setTime(4,registroTemporal.getHoraFin());
            preparedStatement.setDate(5,registroTemporal.getFecha());
            
            if(preparedStatement.executeUpdate() != 0){
                //JOptionPane.showMessageDialog(null,"Sesion Iniciada");
                DialogMensaje.Informacion(null,"Sesión iniciada");
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
            MysqlUtils.cerrarPreparedStatement(preparedStatement);
        }
    }

    @Override
    public String obtenerNroEquiposDisponibles() {
        try {
            preparedStatement = conexion.prepareStatement(obtenerNroEquiposDisponibles);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return String.valueOf(resultSet.getInt("cantidad"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
            MysqlUtils.cerrarPreparedStatementAndResultSet(preparedStatement, resultSet);
        }
        return null;
    }

    @Override
    public String obtenerNroSesionesActivas() {
        try {
            preparedStatement = conexion.prepareStatement(obtenerNroSesionesActivas);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return String.valueOf(resultSet.getInt("cantidad"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
            MysqlUtils.cerrarPreparedStatementAndResultSet(preparedStatement, resultSet);
        }
        return null;
    }

    public SesionesActivas convertirResultSet(ResultSet rs){
        try {
            codigo = rs.getInt("rcodigo");
            codUsuario = rs.getString("ucodigo");
            codPc = rs.getInt("codPc");
            horaInicio = rs.getTime("horaInicio");
            nombre = rs.getString("nombre");
            apellido = rs.getString("apellido");
            
            return new SesionesActivas(
                    new Usuario(null,codUsuario,nombre, apellido, null, null, null, null),
                    new RegistroTemporal(codigo, null, codPc, horaInicio, null, null));
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    @Override
    public List<SesionesActivas> obtenerSesionesActivas() {
        try {
            listaSesionesActivas = new ArrayList<>();
            preparedStatement = conexion.prepareStatement(obtenerSesionesActivas);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                listaSesionesActivas.add(convertirResultSet(resultSet));
            }
            
            return listaSesionesActivas;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("****");
        }finally{
            MysqlUtils.cerrarPreparedStatementAndResultSet(preparedStatement, resultSet);
        }
        return null;
    }

    public RegistroTemporal convertirARegistroTemporal(ResultSet rs){
        try {
            codigo = rs.getInt("codigo");
            Integer codigoUsuario = rs.getInt("codUsuario");
            codPc = rs.getInt("codPc");
            horaInicio = rs.getTime("horaInicio");
            fecha = rs.getDate("fecha");
            
            return new RegistroTemporal(codigo, codigoUsuario, codPc, horaInicio, null, fecha);
            
        } catch (SQLException e) {
            System.out.println("Error al convertir registro temporal");
        }
        
        return null;
    }
    
    @Override
    public RegistroTemporal obtenerRegistroTemporal(Integer codigo) {
        try {
            preparedStatement = conexion.prepareStatement(obtenerRegistroTemporal);
            preparedStatement.setInt(1, codigo);
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                return convertirARegistroTemporal(resultSet);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al obtener Registro temoral");
        } finally{
            MysqlUtils.cerrarPreparedStatementAndResultSet(preparedStatement, resultSet);
        }
        return null;
    }

    @Override
    public void eliminar(Integer codigo) {
        try {
            preparedStatement = conexion.prepareStatement(eliminar);
            preparedStatement.setInt(1, codigo);
            if(preparedStatement.executeUpdate() != 0){
                //DialogMensaje.Informacion(null,"Eliminado exitosamente");
            }
        } catch (SQLException e) {
            System.out.println("No se pudo eliminar");
        } finally{
            MysqlUtils.cerrarPreparedStatement(preparedStatement);
        }
    }

    @Override
    public void actualizarEquipo(RegistroTemporal registroTemporal) {
        try {
            preparedStatement = conexion.prepareStatement(actualizarEquipo);
            preparedStatement.setInt(1,registroTemporal.getCodPC());
            preparedStatement.setInt(2,registroTemporal.getCodigo());
            
            if(preparedStatement.executeUpdate() != 0){
                DialogMensaje.Informacion(null,"Actualizado Exitosamente");
                //JOptionPane.showMessageDialog(null,"Sesion Actualizada");
            }
            
        } catch (HeadlessException | SQLException e) {
            System.out.println(e.getMessage());
        } finally{
            MysqlUtils.cerrarPreparedStatement(preparedStatement);
        }
    }

    @Override
    public boolean verificarUsuarioActivo(Integer codigo) {
        try {
            preparedStatement = conexion.prepareStatement(verificarUsuarioActivo);
            preparedStatement.setInt(1, codigo);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error verificar usuario activo");
        }
        return false;
    }

}
