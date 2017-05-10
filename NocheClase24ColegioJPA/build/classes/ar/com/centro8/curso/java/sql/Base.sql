drop database if exists colegio;
create database colegio;

use colegio;

create table alumnos(
    id int auto_increment primary key,
    nombre varchar(20),
    apellido varchar(20),
    edad int,
    curso int
);

create table cursos(
    id int auto_increment primary key,
    titulo varchar(50),
    profesor varchar(20),
    dia varchar(20),
    turno varchar(20)
);

insert into cursos values
(null,'Java','Rios','Martes','Mañana'),
(null,'HTML','Gomes','Miercoles','Tarde'),
(null,'MySQL','Diegues','Jueves','Noche'),
(null,'Hibernate','Rios','Viernes','Noche');

alter table alumnos
add constraint FK_Alumnos_Curso
foreign key (curso)
references cursos(id)
on delete cascade; -- on action para eliminar el curso y mantener el alumno

insert into alumnos values (null, 'Roxana', 'Diaz',34,1);

create table control(
    id int auto_increment primary key,
    usuario varchar(50) not null,
    terminal varchar(50) not null,
    fechaHora datetime not null,
    tabla varchar(20) not null,
    accion varchar(20) not null,
    idRegistro int
);

select * from control;