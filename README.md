# CRUD_SQLSErver_Java

Ejemplo de un crud hacia una tabla de SQL server con java
para crear la tabla hay que ejecutar el siguiente script
create table alumnos
( 
	 id int not null  IDENTITY (1,1)
	 ,matricula varchar(100) not null 
	 ,nombre varchar(50) not null 
	 ,edad int not null 
	 ,sexo char(1) not null 
	 ,email varchar(50) not null 
	 ,activo int not null 
	 ,constraint PK__alumnos__3213E83FD6EE6FF7 primary key( id)
)
