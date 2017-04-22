package dao;

import modelo.CursoRegistro;

public interface DaoCursoRegistro {
    
    public void registrarSesionCurso(CursoRegistro registroCurso);
    public void eliminarRegistrosDeUnCurso(Integer codigo);
    
}
