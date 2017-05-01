
package modelo;

public class SemestreCursoRegistroPorMes {
    
    private String nombreCurso;
    private int codigoCurso;
    private long nroSesiones;
    private long horas;
    private long minutos;
    private long segundos = 0;

    public SemestreCursoRegistroPorMes(String nombreCurso, int codigoCurso, long nroSesiones) {
        this.nombreCurso = nombreCurso;
        this.codigoCurso = codigoCurso;
        this.nroSesiones = nroSesiones;
    }

    public SemestreCursoRegistroPorMes(String nombreCurso, int codigoCurso, long nroSesiones, long horas, long minutos, long segundos) {
        this.nombreCurso = nombreCurso;
        this.codigoCurso = codigoCurso;
        this.nroSesiones = nroSesiones;
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }
    
    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public long getNroSesiones() {
        return nroSesiones;
    }

    public void setNroSesiones(long nroSesiones) {
        this.nroSesiones = nroSesiones;
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

    public String toString(){
        return nombreCurso + " - " + codigoCurso + " - " + nroSesiones + " - " + horas + "horas - " + minutos + "min - " + segundos + " segundos";
    }
}
