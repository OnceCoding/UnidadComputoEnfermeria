package modelo;

import java.sql.Date;
import java.sql.Time;

public class CursoRegistroTemporal {
    
    private Integer codigo;
    private Integer codCurso;
    private Time horaInicio;
    private Date fecha;

    public CursoRegistroTemporal(Integer codigo, Integer codCurso, Time horaInicio, Date fecha) {
        this.codigo = codigo;
        this.codCurso = codCurso;
        this.horaInicio = horaInicio;
        this.fecha = fecha;
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(Integer codCurso) {
        this.codCurso = codCurso;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}

