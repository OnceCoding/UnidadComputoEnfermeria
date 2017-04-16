
package dao;

import java.sql.Date;
import java.util.List;
import modelo.Registro;
import modelo.UsuarioReporte;

public interface DaoRegistro{

    public Registro obtener(Integer key);
  
    public List<UsuarioReporte> obtenerListaRegistrosPorFecha(Date fecha);
    
    public void eliminar(Registro registro);

    public void insertar(Registro registro);
    
    public void obtenerListaPorSemestre();
    
}
