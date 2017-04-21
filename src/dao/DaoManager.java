package dao;

public interface DaoManager {
    
    public DaoAdministrador getDaoAdministrador();
    public DaoComputadora getDaoComputadora();
    public DaoUsuario getDaoUsuario();
    public DaoRegistro getDaoRegistro();
    public DaoRegistroTemporal getDaoRegistroTemporal();
    public DaoCurso getDaoCurso();
    public DaoContadorRegistro getContadorRegistro();
    public DaoConfiguracion getDaoConfiguracion();
}
