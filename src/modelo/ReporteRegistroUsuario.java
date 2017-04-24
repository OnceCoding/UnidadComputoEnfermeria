
package modelo;

public class ReporteRegistroUsuario {
    
    private Usuario usuario;
    private Registro registro;

    public ReporteRegistroUsuario(Usuario usuario, Registro registro) {
        this.usuario = usuario;
        this.registro = registro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }
    
    
    
}
