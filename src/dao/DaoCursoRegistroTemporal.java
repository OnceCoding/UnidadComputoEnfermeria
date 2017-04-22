package dao;

import modelo.CursoRegistroTemporal;

public interface DaoCursoRegistroTemporal {
    
    public CursoRegistroTemporal obtenerCursoActual();
    public void cerrarSesionCursoActual();
    public void iniciarSesion(CursoRegistroTemporal registroCursoTemporal);
    public Integer existeCursoActual();
}
