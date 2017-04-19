package modelo;

public class ContadorRegistro {
    
    private Integer codigo;
    private String tipo;
    private Integer cantidad;

    public ContadorRegistro(Integer codigo, String tipo, Integer cantidad) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ContadorRegistros{" + "codigo=" + codigo + ", tipo=" + tipo + ", cantidad=" + cantidad + '}';
    }
    
    
    
    
}
