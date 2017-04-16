package dao.mysql;

import dao.DaoAdministrador;
import dao.DaoComputadora;
import dao.DaoContadorRegistro;
import dao.DaoCurso;
import dao.DaoManager;
import dao.DaoRegistro;
import dao.DaoRegistroTemporal;
import dao.DaoUsuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MysqlDaoManager implements DaoManager{

    public static MysqlDaoManager manager;
    
    private Connection conexion;
    
    private static DaoAdministrador administrador = null;
    private static DaoComputadora computadora = null;
    private static DaoRegistro registro = null;
    private static DaoRegistroTemporal registroTemporal = null;
    private static DaoUsuario usuario = null;
    private static DaoCurso curso = null;
    private static DaoContadorRegistro contadorRegistro = null;
    
    public MysqlDaoManager() throws SQLException {
        //try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdcomputo","root","");

        //} catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null,"Error al conectar con la Base de Satos");
          //  System.out.println(ex.getMessage());
           // conexion = null;
        //}
    }
    
    public static MysqlDaoManager getMysqlDaoManager() throws SQLException{
        if(manager == null){
            manager = new MysqlDaoManager();
            return manager;
        }
        
        return manager;
    }
    
    @Override
    public DaoAdministrador getDaoAdministrador() {
        if(administrador == null){
            administrador = new MysqlDaoAdministrador(conexion);
            return administrador;
        }
        return administrador;
    }

    @Override
    public DaoComputadora getDaoComputadora() {
        if(computadora == null){
            computadora = new MysqlDaoComputadora(conexion);
            return computadora;
        }
        return computadora;
    }

    @Override
    public DaoUsuario getDaoUsuario() {
        if(usuario == null){
            usuario = new MysqlDaoUsuario(conexion);
            return usuario;
        }
        return usuario;
    }

    @Override
    public DaoRegistro getDaoRegistro() {
        if(registro == null){
            registro = new MysqlDaoRegistro(conexion);
            return registro;
        }
        
        return registro;
    }

    @Override
    public DaoRegistroTemporal getDaoRegistroTemporal() {
        if(registroTemporal == null){
            registroTemporal = new MysqlDaoRegistroTemporal(conexion);
            return registroTemporal;
        }
        
        return registroTemporal;
    }

    @Override
    public DaoCurso getDaoCurso() {
        if(curso == null){
            curso = new MysqlDaoCurso(conexion);
        }
        return curso;
    }

    @Override
    public DaoContadorRegistro getContadorRegistro() {
        if(contadorRegistro == null){
            contadorRegistro = new MysqlDaoContadorRegistro(conexion);
            return contadorRegistro;
        }
        return contadorRegistro;
    }
    
}
