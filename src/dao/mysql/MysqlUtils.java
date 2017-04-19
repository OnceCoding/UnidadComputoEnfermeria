package dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MysqlUtils {
    
    public static void cerrarPreparedStatement(PreparedStatement ps){
        try {
            if(ps != null){
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"Ocurrio una Accion Inesperada");
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
            JOptionPane.showMessageDialog(null,"Ocurrio una Accion Inesperada");
        }
    }
    
}
