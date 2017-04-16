package modelo;

public class Computadora {
    
    private String codigo = null;
    private String estado;

    public Computadora(String codigo, String estado) {
        this.codigo = codigo;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Computadora{" + "codigo=" + codigo + ", estado=" + estado + '}';
    }
    
    
}
