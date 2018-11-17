/*
drop table if exists comentarios;
drop table if exists palabrasclave;
drop table if exists votos;
drop table if exists intereses;
drop table if exists iniciativas;
drop table if exists usuarios;
drop table if exists areas;

drop sequence if exists area_id;
drop sequence if exists comentario_id;
drop sequence if exists interes_id;
drop sequence if exists palabrasclave_id;
*/


-- Table: Areas
CREATE SEQUENCE area_id;
CREATE TABLE IF NOT EXISTS Areas (
    id int NOT NULL DEFAULT nextval('area_id'),
    nombre varchar(40)  NOT NULL,
    descripcion varchar(100)  NOT NULL,
    CONSTRAINT Areas_pk PRIMARY KEY (id)
);

-- Table: Comentarios
CREATE SEQUENCE comentario_id;
CREATE TABLE IF NOT EXISTS Comentarios (
    id int NOT NULL DEFAULT nextval('comentario_id'),
    contenido varchar(200)  NOT NULL,
    fecha date  NOT NULL,
    usuario varchar(60)  NOT NULL,
    iniciativa varchar(100)  NOT NULL,
    CONSTRAINT Comentarios_pk PRIMARY KEY (id)
);

-- Table: Iniciativas
CREATE TABLE IF NOT EXISTS  Iniciativas (
    nombre varchar(50)  NOT NULL,
    descripcion varchar(500)  NOT NULL,
    fechaPropuesta date  NOT NULL,
    estado varchar(11)  NOT NULL,
    fechaCierre date  NULL,
    proponente varchar(60)  NOT NULL,
    CONSTRAINT Iniciativas_pk PRIMARY KEY (nombre)
);

-- Table: Intereses
CREATE SEQUENCE interes_id;
CREATE TABLE IF NOT EXISTS  Intereses (
    id int  NOT NULL DEFAULT nextval('interes_id'),
    Iniciativa varchar(100)  NOT NULL,
    intencion varchar(50)  NOT NULL,
    descripcion varchar(500)  NOT NULL,
    fecha date  NOT NULL,
    trabajo boolean  NOT NULL,
    usuario varchar(60)  NOT NULL,
    CONSTRAINT Interes_pk PRIMARY KEY (id)
);

-- Table: PalabrasClave
CREATE SEQUENCE palabrasclave_id;
CREATE TABLE  IF NOT EXISTS PalabrasClave (
    Id int NOT NULL DEFAULT nextval('palabrasclave_id'),
    Iniciativa varchar(100)  NOT NULL,
    Descripcion varchar(100)  NOT NULL,
    CONSTRAINT PalabrasClave_pk PRIMARY KEY (Id)
);

-- Table: Usuarios
CREATE TABLE IF NOT EXISTS  Usuarios (
    correo varchar(60)  NOT NULL,
    nombre varchar(40)  NOT NULL,
    tipo varchar(13)  NOT NULL,
    area int  NOT NULL,
    CONSTRAINT Usuarios_pk PRIMARY KEY (correo)
);

-- Table: Votos
CREATE TABLE  IF NOT EXISTS   Votos (
    iniciativa varchar(100)  NOT NULL,
    usuario varchar(60)  NOT NULL,
    CONSTRAINT Votos_pk PRIMARY KEY (iniciativa,usuario)
);

-- Reference: Categorias_Iniciativa (table: PalabrasClave)
ALTER TABLE PalabrasClave ADD CONSTRAINT Categorias_Iniciativa
    FOREIGN KEY (Iniciativa)
    REFERENCES Iniciativas (nombre)  
;

-- Reference: Comentarios_Iniciativas (table: Comentarios)
ALTER TABLE Comentarios ADD CONSTRAINT Comentarios_Iniciativas
    FOREIGN KEY (iniciativa)
    REFERENCES Iniciativas (nombre)  
;

-- Reference: Comentarios_Usuarios (table: Comentarios)
ALTER TABLE Comentarios ADD CONSTRAINT Comentarios_Usuarios
    FOREIGN KEY (usuario)
    REFERENCES Usuarios (correo)  
;

-- Reference: Iniciativas_Usuarios (table: Iniciativas)
ALTER TABLE Iniciativas ADD CONSTRAINT Iniciativas_Usuarios
    FOREIGN KEY (proponente)
    REFERENCES Usuarios (correo)  
;

ALTER TABLE Intereses ADD CONSTRAINT Interes_Iniciativa
    FOREIGN KEY (Iniciativa)
    REFERENCES Iniciativas (nombre)  
 ;

-- Reference: Interes_Usuarios (table: Interes)
ALTER TABLE Intereses ADD CONSTRAINT Interes_Usuarios
    FOREIGN KEY (usuario)
    REFERENCES Usuarios (correo)  
;

-- Reference: Usuarios_Areas (table: Usuarios)
ALTER TABLE Usuarios ADD CONSTRAINT Usuarios_Areas
    FOREIGN KEY (area)
    REFERENCES Areas (id)  
;

-- Reference: Votos_Iniciativas (table: Votos)
ALTER TABLE Votos ADD CONSTRAINT Votos_Iniciativas
    FOREIGN KEY (iniciativa)
    REFERENCES Iniciativas (nombre)  
;

-- Reference: Votos_Usuarios (table: Votos)
ALTER TABLE Votos ADD CONSTRAINT Votos_Usuarios
    FOREIGN KEY (usuario)
    REFERENCES Usuarios (correo)  
;

-- Checks
--Tipos: Estado
ALTER TABLE Iniciativas ADD CONSTRAINT Estado 
	CHECK (Iniciativas.estado IN ('EN_ESPERA','EN_REVISION','PROYECTO','SOLUCIONADO','DESECHADO'));

--Tipos: Rol
ALTER TABLE Usuarios ADD CONSTRAINT Rol
	CHECK (tipo IN ('PUBLICO','PROPONENTE','ADMINISTRADOR','PMO_ODI'));



INSERT INTO areas (nombre,descripcion) VALUES ('PMO','gerencia de proyectos');
INSERT INTO areas (nombre,descripcion) VALUES ('Decanatura de Sistemas','decanatura del programa de decanatura de sistemas');
