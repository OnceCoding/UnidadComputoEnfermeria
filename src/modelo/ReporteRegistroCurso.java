
package modelo;

public class ReporteRegistroCurso {
    
    private Curso curso;
    private RegistroCurso registroCurso;

    public ReporteRegistroCurso(Curso curso, RegistroCurso registroCurso) {
        this.curso = curso;
        this.registroCurso = registroCurso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public RegistroCurso getRegistroCurso() {
        return registroCurso;
    }

    public void setRegistroCurso(RegistroCurso registroCurso) {
        this.registroCurso = registroCurso;
    }

}
