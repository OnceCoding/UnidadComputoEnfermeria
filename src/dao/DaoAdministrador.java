package dao;

import modelo.Administrador;

public interface DaoAdministrador{

    public Administrador obtener();
    public void actualizarUsuario(Administrador administrador);
    public void actualizarContraseña(Administrador administrador);

}
