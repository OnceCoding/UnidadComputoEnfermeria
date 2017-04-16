package dao;

import modelo.RegistroTemporal;

public interface DaoRegistroTemporal{

    public RegistroTemporal obtener(Integer key);

    public void actualizar(RegistroTemporal registroTemporal);

    public void eliminar(RegistroTemporal registroTemporal);

    public void insertar(RegistroTemporal registroTemporal);
    
    
    
}
