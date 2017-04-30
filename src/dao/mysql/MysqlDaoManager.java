package dao.mysql;

import Configuracion.ArchivoIni;
import dao.DaoAdministrador;
import dao.DaoComputadora;
import dao.DaoConfiguracion;
import dao.DaoContadorRegistro;
import dao.DaoCurso;
import dao.DaoCursoRegistro;
import dao.DaoCursoRegistroTemporal;
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
    private static DaoConfiguracion configuracion = null;
    private static DaoCursoRegistro daoCursoRegistro = null;
    private static DaoCursoRegistroTemporal daoCursoRegistroTemporal = null;
    
    private ArchivoIni ini;
    private String host,bd,user,pass;
    
    public MysqlDaoManager() throws SQLException {
        
        /*ini = ArchivoIni.getArchivoIni();
        host = ini.leerPropiedad("host");
        bd = ini.leerPropiedad("bd");
        user = ini.leerPropiedad("user");
        pass = ini.leerPropiedad("pass");*/
        
        host = "localhost";
        bd = "bdcomputo";
        user = "root";
        pass = "";
        
        conexion = DriverManager.getConnection("jdbc:mysql://"+host+"/"+bd+"?useSSL=false",user,pass);
        
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

    @Override
    public DaoConfiguracion getDaoConfiguracion() {
        if(configuracion == null){
            configuracion = new MysqlDaoConfiguracion(conexion);
            return configuracion;
        }
        return configuracion;
    }

    @Override
    public DaoCursoRegistroTemporal getDaoCursoRegistroTemporal() {
        if(daoCursoRegistroTemporal == null){
            daoCursoRegistroTemporal = new MysqlDaoCursoRegistroTemporal(conexion);
            return daoCursoRegistroTemporal;
        }
        return daoCursoRegistroTemporal;
    }

    @Override
    public DaoCursoRegistro getDaoCursoRegistro() {
        if(daoCursoRegistro == null){
            daoCursoRegistro = new MysqlDaoCursoRegistro(conexion);
            return daoCursoRegistro;
        }
        return daoCursoRegistro;  
    }

    
    
    
}
