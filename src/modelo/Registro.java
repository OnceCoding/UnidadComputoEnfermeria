package modelo;

import java.sql.Date;
import java.sql.Time;

public class Registro {
    
    private Integer codigo;
    private String codUsuario;
    private int codPC;
    private Time horaInicio;
    private Time horaFin;
    private Date fecha;

    public Registro(Integer codigo, String codUsuario, int codPC, Time horaInicio, Time horaFin, Date fecha) {
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

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public int getCodPC() {
        return codPC;
    }

    public void setCodPC(int codPC) {
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
        return "Registro{" + "codigo=" + codigo + ", codUsuario=" + codUsuario + ", codPC=" + codPC + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", fecha=" + fecha + '}';
    }
    
    
    
}
