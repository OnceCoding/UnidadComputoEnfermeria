
package dao;

import java.sql.Date;
import java.util.List;
import modelo.Registro;
import modelo.ReporteRegistroUsuario;

public interface DaoRegistro{
  
    public void insertar(Registro registro);
    public void eliminarTodosLosRegistrosDeUnUsuario(Integer codigo);
    public List<ReporteRegistroUsuario> obtenerReporteEntreFechas(Date inicio , Date fin );
    
}
