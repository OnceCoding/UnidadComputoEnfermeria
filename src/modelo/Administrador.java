package modelo;

public class Administrador {

    private Integer codigo;
    private String user;
    private String pass;    
    private String nombreCompleto;
    
    public Administrador(Integer codigo,String user,String pass,String nombreCompleto) {
        this.codigo = codigo;
        this.user = user;
        this.pass = pass;
        this.nombreCompleto = nombreCompleto;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    
    @Override
    public String toString() {
        return "Administrador{" + "codigo=" + codigo + ", user=" + user + ", pass=" + pass + '}';
    }

}
