package modelo;

public class SemestreUsuarioRegistroPorMes {
    
    private String mes;
    private Integer nroTotalVisitantes;
    private long horas;
    private long minutos;
    private long segundos;

    public SemestreUsuarioRegistroPorMes(Integer mes, Integer nroTotalVisitantes, long horas, long minutos, long segundos) {
        this.mes = convertirMes(mes);
        this.nroTotalVisitantes = nroTotalVisitantes;
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Integer getNroTotalVisitantes() {
        return nroTotalVisitantes;
    }

    public void setNroTotalVisitantes(Integer nroTotalVisitantes) {
        this.nroTotalVisitantes = nroTotalVisitantes;
    }

    public long getHoras() {
        return horas;
    }

    public void setHoras(long horas) {
        this.horas = horas;
    }

    public long getMinutos() {
        return minutos;
    }

    public void setMinutos(long minutos) {
        this.minutos = minutos;
    }

    public long getSegundos() {
        return segundos;
    }

    public void setSegundos(long segundos) {
        this.segundos = segundos;
    }

    public String convertirMes(int nroMes){
        String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Setiembre","Octubre","Noviembre","Diciembre"};
        return meses[nroMes];
    }
    

}
