
package modelo;

import java.sql.Date;
import java.sql.Time;

public class RegistroCurso {
    
    private String nombreCurso;
    private Time horaInicio;
    private Time horaFin;
    private Date fecha;

    public RegistroCurso(String nombreCurso, Time horaInicio, Time horaFin, Date fecha) {
        this.nombreCurso = nombreCurso;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.fecha = fecha;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
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
    
    @Override
    public String toString() {
        return "RegistroCurso{" + "nombreCurso=" + nombreCurso + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", fecha=" + fecha + '}';
    }
    
}
