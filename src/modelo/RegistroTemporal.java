package modelo;

import java.sql.Date;
import java.sql.Time;

public class RegistroTemporal {
    
    private Integer codigo;
    private Integer codUsuario;
    private Integer codPC;
    private Time horaInicio;
    private Time horaFin;
    private Date fecha;

    public RegistroTemporal(Integer codigo, Integer codUsuario, Integer codPC, Time horaInicio, Time horaFin, Date fecha) {
        this.codigo = codigo;
        this.codUsuario = codUsuario;
        this.codPC = codPC;
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

    public Integer getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public Integer getCodPC() {
        return codPC;
    }

    public void setCodPC(Integer codPC) {
        this.codPC = codPC;
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
        return "RegistroTemporal{" + "codigo=" + codigo + ", codUsuario=" + codUsuario + ", codPC=" + codPC + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", fecha=" + fecha + '}';
    }
    
    
    
}
