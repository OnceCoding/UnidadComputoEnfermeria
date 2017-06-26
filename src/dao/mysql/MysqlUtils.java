package dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import vistas.DialogMensaje;


public class MysqlUtils {
    
    public static void cerrarPreparedStatement(PreparedStatement ps){
        try {
            if(ps != null){
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            DialogMensaje.Error(null,"Error en la conexión con la base de datos");
            System.exit(0);
        }
    }
    
    
    public static void cerrarPreparedStatementAndResultSet(PreparedStatement ps,ResultSet rs){
        try{
            if(ps != null){
                ps.close();
            }
            if(rs != null){
                rs.close();
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            DialogMensaje.Error(null,"Error en la conexión con la base de datos");
            System.exit(0);
        }
    }
    
}
