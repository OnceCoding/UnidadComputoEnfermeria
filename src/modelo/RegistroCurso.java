package modelo;

import java.sql.Date;
import java.sql.Time;

public class RegistroCurso {
    
    private Integer codigo;
    private Integer codCurso;
    private Time horaInicio;
    private Time horaFin;
    private Date fecha;

    public RegistroCurso(Integer codigo, Integer codCurso, Time horaInicio, Time horaFin, Date fecha) {
        this.codigo = codigo;
        this.codCurso = codCurso;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
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

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
