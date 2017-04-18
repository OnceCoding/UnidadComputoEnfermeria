package dao.mysql;

import dao.DaoRegistroTemporal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Computadora;
import modelo.RegistroTemporal;


public class MysqlDaoRegistroTemporal implements DaoRegistroTemporal{

    private Connection conexion = null;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    private final String obtenerEquiposDisponibles = 
            "select c.codigo,c.estado from computadora c left join registrotemporal r on c.codigo = r.codpc where r.codpc is null ";
    private final String insertar = "insert into registroTemporal(codUsuario,codPC,horaInicio,horaFin,fecha) "
            + "values(?,?,?,?,?)";
    
    private List<Computadora> listaEquiposDisponibles;
    
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

}
