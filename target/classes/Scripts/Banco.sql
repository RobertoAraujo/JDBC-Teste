CREATE TABLE autor (
   ID int4 PRIMARY KEY,
   NOME varchar(30) NOT NULL,
   IDADE int4,
   NASCIMENTO date,
   COMENTARIO varchar(40) NOT NULL
);