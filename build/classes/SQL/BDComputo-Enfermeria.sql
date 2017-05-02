drop database if exists BdComputo;

create database BdComputo;
use BdComputo;

create table administrador(
	codigo tinyint primary key,
    user varchar(30) not null,
	pass varchar(20) not null,
    tipo varchar(20) not null

)ENGINE=innoDB;

/* estudiantes y profesores*/
create table usuario(
	id int auto_increment primary key,
	codigo varchar(11),	
	nombre varchar(30) not null,
    apellido varchar(50) not null,
    correo varchar(70),
    tipo varchar(12),
    fecha date,
    hora time,
    unique key codigoUsuario(codigo)
)ENGINE=innoDB;

create table usuarioEliminado(
	id int auto_increment primary key,
	codigo varchar(11),	
	nombre varchar(30) not null,
    apellido varchar(50) not null,
    correo varchar(70),
    tipo varchar(12),
    fecha date,
    hora time
)ENGINE=innoDB;

create table computadora(
	codigo int primary key, 
    estado varchar(30)
)ENGINE=innoDB;

create table curso(
	codigo int auto_increment primary key,
    nombre varchar(50) not null
)ENGINE=innoDB;

create table cursoEliminado(
	codigo int auto_increment primary key,
    nombre varchar(50) not null
)ENGINE=innoDB;

create table registro(
	codigo int auto_increment primary key,
    codUsuario int,
    codPC int,
    horaInicio time,
    horaFin time,
    fecha date ,
    index indexFecha(fecha),
    index indexCodUsuario(codUsuario),
    foreign key(codUsuario) references usuario(id)
)ENGINE=innoDB;

create table registroEliminado(
	codigo int auto_increment primary key,
    codUsuario int,
    codPC int,
    horaInicio time,
    horaFin time,
    fecha date 
)ENGINE=innoDB;

create table registroTemporal(
	codigo int auto_increment primary key,
    codUsuario int,
    codPC int,
    horaInicio time,
    horaFin time,
    fecha date,
    foreign key(codUsuario) references usuario(id)

)ENGINE=innoDB;


create table registroCurso(
	codigo int auto_increment primary key,
    codCurso int,
    horaInicio time,
    horaFin time,
    fecha date,
    foreign key(codCurso) references curso(codigo)
)ENGINE=innoDB;

create table registroCursoEliminado(
	codigo int auto_increment primary key,
    codCurso int,
    horaInicio time,
    horaFin time,
    fecha date
)ENGINE=innoDB;

create table registroCursoTemporal(
	codigo int auto_increment primary key,
    codCurso int,
    horaInicio time,
    fecha date
)ENGINE=innoDB;


create table contadorRegistro(
	codigo tinyint primary key,
    tipo varchar(10),
    cantidad int
)ENGINE=innoDB;


insert into administrador values(1,'admin','admin','registro');
insert into administrador values(2,'admin','admin','computo');
insert into administrador values(3,'admin','admin','simulacion');
insert into administrador values(4,'admin','admin','biblioteca');


insert into contadorRegistro values(1,'usuario',0);
insert into contadorRegistro values(2,'historial',0);
	
/* Trigger :  aumenta en 1 la tabal de contadoreREgistros cuando se inserta  a la tabla USUARIOS */
delimiter $
create trigger aumentarContadorUsuarioRegistro after insert on usuario for each row
	begin
		declare cantidadNueva int;
        declare cantActual int;
		select cantidad into cantActual from contadorRegistro where tipo = 'usuario';
        set cantidadNueva = cantActual + 1;
		update contadorRegistro set cantidad = cantidadNueva where tipo = 'usuario';
    end$

delimiter ;


/* Trigger :  disminuye en 1 la tabal de contadoreREgistros cuando se inserta  a la tabla USUARIOS */
delimiter $
create trigger disminuirContadorUsuarioRegistro after delete on usuario for each row
	begin
		declare cantidadNueva int;
        declare cantActual int;
		select cantidad into cantActual from contadorRegistro where tipo = 'usuario';
        set cantidadNueva = cantActual - 1;
		update contadorRegistro set cantidad = cantidadNueva where tipo = 'usuario';
    end$

delimiter ;


/* Trigger :  aumenta en 1 la tabla de contadoreREgistros cuando se inserta  a la tabla REGISTRO-HISTORIAL */
delimiter $
create trigger aumentarContadorHistorialRegistro after insert on registro for each row
	begin
		declare cantidadNueva int;
        declare cantActual int;
		select cantidad into cantActual from contadorRegistro where tipo = 'historial';
        set cantidadNueva = cantActual + 1;
		update contadorRegistro set cantidad = cantidadNueva where tipo = 'historial';
    end$

delimiter ;


/* Trigger :  disminuye en 1 la tabla de contadoreREgistros cuando se inserta  a la tabla REGISTRO-HISTORIAL */
delimiter $
create trigger disminuirContadorHistorialRegistro after delete on registro for each row
	begin
		declare cantidadNueva int;
        declare cantActual int;
		select cantidad into cantActual from contadorRegistro where tipo = 'historial';
        set cantidadNueva = cantActual - 1;
		update contadorRegistro set cantidad = cantidadNueva where tipo = 'historial';
    end$

delimiter ;



/*Trigger para cuando se elimina los registros de los usuarios*/
 delimiter $
 create trigger registrosEliminados before delete on registro for each row
	begin
		insert into registroEliminado values(old.codigo,old.codUsuario,old.codPC,old.horaInicio,old.horaFin,old.fecha);
    end$
delimiter ;
 
 
 /*Trigger para cuando se elimina los usuarios*/
 delimiter $
 create trigger usuariosEliminados before delete on usuario for each row
	begin
		insert into usuarioEliminado values(old.id,old.codigo,old.nombre,old.apellido,old.correo,old.tipo,old.fecha,old.hora);
    end$
delimiter ;
 
 
/*Trigger para cuando se elimina los registros de los cursos*/
 delimiter $
 create trigger registroCursosEliminados before delete on registrocurso for each row
	begin
		insert into registroCursoEliminado values(old.codigo,old.codCurso,old.horaInicio,old.horaFin,old.fecha);
    end$
delimiter ;
 

 /*Trigger para cuando se elimina los cursos*/
 delimiter $
 create trigger cursosEliminados before delete on curso for each row
	begin
		insert into cursoEliminado values(old.codigo,old.nombre);
    end$
delimiter ;
 

