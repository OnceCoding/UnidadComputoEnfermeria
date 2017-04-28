
package modelo;

import java.sql.Date;
import java.sql.Time;

public class ListaRegistroUsuario {
    
    private String codUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String codPC;
    private String horaInicio;
    private String horaFin;
    private String fecha;

    public ListaRegistroUsuario(String codUsuario, String nombreUsuario, String apellidoUsuario, String codPC, String horaInicio, String horaFin, String fecha) {
        this.codUsuario = codUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.codPC = codPC;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.fecha = fecha;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getCodPC() {
        return codPC;
    }

    public void setCodPC(String codPC) {
        this.codPC = codPC;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}