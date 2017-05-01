
package dao;

import java.sql.Date;
import java.util.List;
import modelo.Registro;
import modelo.ReporteRegistroCurso;
import modelo.ReporteRegistroUsuario;
import modelo.SemestreCursoRegistroPorMes;
import modelo.SemestreUsuarioRegistroPorMes;

public interface DaoRegistro{
  
    public void insertar(Registro registro);
    public void eliminarTodosLosRegistrosDeUnUsuario(Integer codigo);
    public List<ReporteRegistroUsuario> obtenerReporteEntreFechas(Date inicio , Date fin );
    public List<ReporteRegistroCurso> obtenerReporteCursoEntreFechas(Date inicio , Date fin );
    public List<SemestreUsuarioRegistroPorMes> obtenerReporteSemestre(Integer año, Integer mesInicio, Integer mesFinal);
    public List<SemestreCursoRegistroPorMes> obtenerReporteCursoSemestre(Integer año, Integer mesInicio, Integer mesFinal);

}
