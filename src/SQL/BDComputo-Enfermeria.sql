drop database if exists BdComputo;

create database BdComputo;
use BdComputo;

create table administrador(
	codigo tinyint primary key,
    user varchar(30) not null,
	pass varchar(20) not null

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

create table computadora(
	codigo varchar(10) primary key, 
    estado varchar(30)
)ENGINE=innoDB;

create table curso(
	codigo int auto_increment primary key,
    nombre varchar(50) not null
)ENGINE=innoDB;

create table registro(
	codigo int auto_increment primary key,
    codUsuario int,
    codPC varchar(10),
    horaInicio time,
    horaFin time,
    fecha date ,
    index indexFecha(fecha),
    foreign key(codUsuario) references usuario(id),
    foreign key(codPC) references computadora(codigo)
)ENGINE=innoDB;

create table registroTemporal(
	codigo int auto_increment primary key,
    codUsuario int,
    codPC varchar(10),
    horaInicio time,
    horaFin time,
    fecha date,
    foreign key(codUsuario) references usuario(id),
    foreign key(codPC) references computadora(codigo)

)ENGINE=innoDB;


create table registroCurso(
	codigo int auto_increment primary key,
    codCurso int,
    horaInicio time,
    horaFin time,
    fecha date,
    foreign key(codCurso) references curso(codigo)
)ENGINE=innoDB;

create table registroCursoTemporal(
	codigo int auto_increment primary key,
    codCurso int,
    horaInicio time,
    fecha date,
    foreign key(codCurso) references curso(codigo)
)ENGINE=innoDB;

create table configuracionSemestre(
	codigo tinyint primary key,
    mesInicio varchar(3),
    mesFin varchar(3),
    año varchar(5)

)ENGINE=innoDB;

create table contadorRegistro(
	codigo tinyint primary key,
    tipo varchar(10),
    cantidad int
)ENGINE=innoDB;


insert into administrador values(1,'admin','admin');

insert into contadorRegistro values(1,'usuario',0);
insert into contadorRegistro values(2,'historial',0);

insert into configuracionSemestre values(1,'1','6','2017');
insert into configuracionSemestre values(2,'7','12','2017');

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




 

