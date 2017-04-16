/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.mysql;

import dao.DaoRegistroTemporal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.RegistroTemporal;

/**
 *
 * @author JoseSp
 */
public class MysqlDaoRegistroTemporal implements DaoRegistroTemporal{

    private Connection conexion = null;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    public MysqlDaoRegistroTemporal(Connection conexion){
        this.conexion = conexion;
    }
    
    @Override
    public RegistroTemporal obtener(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(RegistroTemporal registroTemporal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(RegistroTemporal registroTemporal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertar(RegistroTemporal registroTemporal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
