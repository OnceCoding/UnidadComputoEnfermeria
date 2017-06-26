package modelo;

public class Computadora {
    
    private Integer codigo = null;
    private String estado;

    public Computadora(Integer codigo, String estado) {
        this.codigo = codigo;
        this.estado = estado;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
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
