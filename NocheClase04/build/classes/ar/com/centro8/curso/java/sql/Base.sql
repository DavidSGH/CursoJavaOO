/*
    Código de Base de Datos
*/
-- Testeando WorkBench
show databases;
select curdate() as fecha;
select curtime() as hora;

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

select * from alumnos;

use colegio;
insert into cursos values
(null,'Java','Rios','Martes','Mañana'),
(null,'HTML','Gomes','Miercoles','Tarde'),
(null,'MySQL','Diegues','Jueves','Noche'),
(null,'Hibernate','Rios','Viernes','Noche');

