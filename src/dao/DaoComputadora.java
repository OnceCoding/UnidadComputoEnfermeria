package dao;

import java.util.List;
import modelo.Computadora;

public interface DaoComputadora{

    public Computadora obtener(String key);

    public List<Computadora> obtenerTodos();
    
    public void actualizar(Computadora computadora);

    public void eliminar(Computadora computadora);

    public void insertar(Computadora computadora);
 
    public String contadorNroComputadoras(); 
    
}
