package modelo;

public class ConfiguracionSemestre {
    
    private Integer codigo;
    private String mesInicio;
    private String mesFinal;
    private String año;

    public ConfiguracionSemestre(Integer codigo, String mesInicio, String mesFinal, String año) {
        this.codigo = codigo;
        this.mesInicio = mesInicio;
        this.mesFinal = mesFinal;
        this.año = año;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getMesInicio() {
        return mesInicio;
    }

    public void setMesInicio(String mesInicio) {
        this.mesInicio = mesInicio;
    }

    public String getMesFinal() {
        return mesFinal;
    }

    public void setMesFinal(String mesFinal) {
        this.mesFinal = mesFinal;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }
    
    
    
}
