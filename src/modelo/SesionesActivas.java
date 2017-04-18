
package modelo;

public class SesionesActivas {
    
    private Usuario usuario;
    private RegistroTemporal registroTemporal;

    public SesionesActivas(Usuario usuario, RegistroTemporal registroTemporal) {
        this.usuario = usuario;
        this.registroTemporal = registroTemporal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public RegistroTemporal getRegistroTemporal() {
        return registroTemporal;
    }

    public void setRegistroTemporal(RegistroTemporal registroTemporal) {
        this.registroTemporal = registroTemporal;
    }
            
            
    
}
