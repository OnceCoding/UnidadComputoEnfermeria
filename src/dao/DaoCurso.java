package dao;

import java.util.List;
import modelo.Curso;

public interface DaoCurso{

    public void insertar(Curso curso);

    public void eliminar(Curso curso);

    public void actualizar(Curso curso,String nombreNuevo);

    public Curso obtener(String nombre);

    public List<Curso> obtenerTodos();
    
    public String obtenerContadorCursos();
    
}
