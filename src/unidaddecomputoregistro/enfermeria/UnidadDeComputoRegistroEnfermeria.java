package unidaddecomputoregistro.enfermeria;

import vistas.frmLogin;

public class UnidadDeComputoRegistroEnfermeria {

    public static void main(String[] args) {
          /**
          DaoManager manager = new MysqlDaoManager();
          
          /******** Administrador Metodos funcionando *********/
          /*DaoAdministrador admin = manager.getDaoAdministrador();
          admin.actualizar(new Administrador(null,"admin","admin"));*/
          
          
          /******* Computadora Metodos Funcionando ******/
          //DaoComputadora computadora = manager.getDaoComputadora();
          //computadora.insertar(new Computadora(3,"disponible"));
          //Computadora c = computadora.obtener(3);
          //System.out.println(c.toString());
          //computadora.actualizar(new Computadora(3, "malogrado"));
          //computadora.eliminar(new Computadora(3,null));
          //List<Computadora> lista = computadora.obtenerTodos();
          //System.out.println(lista);
          
          /******* Usuario Metodos Funcionando ********
          //DaoUsuario usuario = manager.getDaoUsuario();
          //usuario.insertar(new Usuario("12345", "nombre", "las tanme", "correo"));
          //Usuario user = usuario.obtener("12345");
          //System.out.println(user.toString());
          //usuario.actualizar(new Usuario("1020304050", "Angy Pamela", "Quispe Ramirez", "angy-22@hotmail.com"), "12345");
          //usuario.eliminar(new Usuario("12345", null, null,null));
          //List<Usuario> user =  usuario.obtenerPorApellido(new Usuario(null, null,"Suarez",null));
          //System.out.println(user);
          
          
          DaoRegistro registro = manager.getDaoRegistro();
          //registro.insertar(new Registro(null,"1012700614",1,Time.valueOf(LocalTime.now()),null,Date.valueOf(LocalDate.now())));
          
          
          
          //DaoCurso curso = manager.getDaoCurso();
          //curso.insertar(new Curso(null,"Primeros Auxilios"));
          */
          
          new frmLogin().setVisible(true);
          
    }
    
}
