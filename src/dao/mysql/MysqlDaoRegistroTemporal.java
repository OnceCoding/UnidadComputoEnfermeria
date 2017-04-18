package dao.mysql;

import dao.DaoRegistroTemporal;
import java.sql.Connection;
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
            + " r on c.codigo = r.codpc where r.codpc is null and c.estado = 'Disponible' ";
    
    private final String obtenerNroSesionesActivas = "select count(codigo) as cantidad from registroTemporal";
    
    private final String obtenerSesionesActivas = "select r.codigo,r.codUsuario,r.codPc,r.horaInicio,u.nombre,u.apellido"
            + " from registroTemporal r inner join usuario u on r.codUsuario = u.codigo";
    
    private Integer codigo;
    private String codUsuario,codPc,nombre,apellido;
    private Time horaInicio;
    
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
                        resultSet.getString("codigo"),resultSet.getString("estado")));
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
            preparedStatement.setString(1,registroTemporal.getCodUsuario());
            preparedStatement.setString(2,registroTemporal.getCodPC());
            preparedStatement.setTime(3,registroTemporal.getHoraInicio());
            preparedStatement.setTime(4,registroTemporal.getHoraFin());
            preparedStatement.setDate(5,registroTemporal.getFecha());
            
            if(preparedStatement.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null,"Sesion Iniciada");
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
            codigo = rs.getInt("codigo");
            codUsuario = rs.getString("codUsuario");
            codPc = rs.getString("codPc");
            horaInicio = rs.getTime("horaInicio");
            nombre = rs.getString("nombre");
            apellido = rs.getString("apellido");
            
            return new SesionesActivas(
                    new Usuario(codUsuario,nombre, apellido, null, null, null, null),
                    new RegistroTemporal(codigo, codUsuario, codPc, horaInicio, null, null));
            
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
        }finally{
            MysqlUtils.cerrarPreparedStatementAndResultSet(preparedStatement, resultSet);
        }
        return null;
    }

}
