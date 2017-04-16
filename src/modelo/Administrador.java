package modelo;

public class Administrador {

    private Integer codigo;
    private String user;
    private String pass;    
    
    public Administrador(Integer codigo,String user,String pass) {
        this.codigo = codigo;
        this.user = user;
        this.pass = pass;
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

    @Override
    public String toString() {
        return "Administrador{" + "codigo=" + codigo + ", user=" + user + ", pass=" + pass + '}';
    }

}
