package dao;

import java.util.List;
import modelo.Computadora;
import modelo.RegistroTemporal;
import modelo.SesionesActivas;

public interface DaoRegistroTemporal{

    public List<Computadora> obtenerEquiposDisponibles();
    public void insertar(RegistroTemporal registroTemporal);
    public String obtenerNroEquiposDisponibles();
    public String obtenerNroSesionesActivas();
    public List<SesionesActivas> obtenerSesionesActivas();
}
