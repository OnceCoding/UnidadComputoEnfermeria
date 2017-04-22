
package dao;

import java.sql.Date;
import java.util.List;
import modelo.Registro;
import modelo.UsuarioReporte;

public interface DaoRegistro{
  
    public List<UsuarioReporte> obtenerListaRegistrosPorFecha(Date fecha);
    public void insertar(Registro registro);
    public void obtenerListaPorSemestre();
    public void eliminarTodosLosRegistrosDeUnUsuario(Integer codigo);
}
