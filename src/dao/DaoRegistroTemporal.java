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
    public RegistroTemporal obtenerRegistroTemporal(Integer codigo);
    public void eliminar(Integer codigo);
    public void actualizarEquipo(RegistroTemporal registroTemporal);
    public boolean verificarUsuarioActivo(Integer codigo);
}
