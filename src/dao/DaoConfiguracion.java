package dao;

import modelo.ConfiguracionSemestre;

public interface DaoConfiguracion {
    
    public ConfiguracionSemestre obtenerDatosPrimerSemestre();
    public void actualizarDatosPrimerSemestre(ConfiguracionSemestre configuracionSemestre);
    public ConfiguracionSemestre obtenerDatosSegundoSemestre();
    public void actualizarDatosSegundoSemestre(ConfiguracionSemestre configuracionSemestre);
    
}
