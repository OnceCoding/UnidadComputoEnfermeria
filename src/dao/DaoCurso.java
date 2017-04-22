package dao;

import java.util.List;
import modelo.Curso;

public interface DaoCurso{

    public void insertar(Curso curso);

    public void eliminar(Integer codigo);

    public void actualizar(Curso curso);

    public Curso obtener(Integer codigo);

    public List<Curso> obtenerTodos();
    
    public String obtenerContadorCursos();
    
}
