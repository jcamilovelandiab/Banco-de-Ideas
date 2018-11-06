-- Table: Areas
CREATE TABLE IF NOT EXISTS Areas (
    id int NOT NULL,
    nombre varchar(15)  NOT NULL,
    descripcion varchar(50)  NOT NULL,
    CONSTRAINT Areas_pk PRIMARY KEY (id)
);

-- Table: Comentarios
CREATE TABLE IF NOT EXISTS Comentarios (
    id int  NOT NULL,
    contenido varchar(50)  NOT NULL,
    fecha date  NOT NULL,
    usuario varchar(60)  NOT NULL,
    iniciativa int  NOT NULL,
    CONSTRAINT Comentarios_pk PRIMARY KEY (id)
);

-- Table: Iniciativas
CREATE SEQUENCE iniciativa_id;
CREATE TABLE IF NOT EXISTS  Iniciativas (
    no_iniciativa int  NOT NULL DEFAULT nextval('iniciativa_id'),
    nombre varchar(15)  NOT NULL,
    descripcion varchar(500)  NOT NULL,
    fechaPropuesta date  NOT NULL,
    estado varchar(11)  NOT NULL,
    fechaCierre date  NULL,
    proponente varchar(60)  NOT NULL,
    CONSTRAINT Iniciativas_pk PRIMARY KEY (no_iniciativa)
);

-- Table: Interes
CREATE TABLE IF NOT EXISTS  Interes (
    id int  NOT NULL,
    Iniciativa int  NOT NULL,
    intencion varchar(50)  NOT NULL,
    descripcion varchar(500)  NOT NULL,
    fecha date  NOT NULL,
    trabajo boolean  NOT NULL,
    usuario varchar(60)  NOT NULL,
    CONSTRAINT Interes_pk PRIMARY KEY (id)
);

-- Table: PalabrasClave
CREATE TABLE  IF NOT EXISTS PalabrasClave (
    Id int  NOT NULL,
    Iniciativa int  NOT NULL,
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
    iniciativa int  NOT NULL,
    usuario varchar(60)  NOT NULL,
    CONSTRAINT Votos_pk PRIMARY KEY (iniciativa,usuario)
);

-- Reference: Categorias_Iniciativa (table: PalabrasClave)
ALTER TABLE PalabrasClave ADD CONSTRAINT Categorias_Iniciativa
    FOREIGN KEY (Iniciativa)
    REFERENCES Iniciativas (no_iniciativa)  
;

-- Reference: Comentarios_Iniciativas (table: Comentarios)
ALTER TABLE Comentarios ADD CONSTRAINT Comentarios_Iniciativas
    FOREIGN KEY (iniciativa)
    REFERENCES Iniciativas (no_iniciativa)  
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

ALTER TABLE Interes ADD CONSTRAINT Interes_Iniciativa
    FOREIGN KEY (Iniciativa)
    REFERENCES Iniciativas (no_iniciativa)  
 ;

-- Reference: Interes_Usuarios (table: Interes)
ALTER TABLE Interes ADD CONSTRAINT Interes_Usuarios
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
    REFERENCES Iniciativas (no_iniciativa)  
;

-- Reference: Votos_Usuarios (table: Votos)
ALTER TABLE Votos ADD CONSTRAINT Votos_Usuarios
    FOREIGN KEY (usuario)
    REFERENCES Usuarios (correo)  
;


-- Checks
--Tipos: Estado
ALTER TABLE Iniciativas ADD CONSTRAINT Estado CHECK (Iniciativas.estado IN ('EN_ESPERA','EN_REVISION','PROYECTO','SOLUCIONADO','DESECHADO'));

--Tipos: Rol
ALTER TABLE Usuarios ADD CONSTRAINT Rol
	CHECK (tipo IN ('PUBLICO','PROPONENTE','ADMINISTRADOR','PMO-ODI'));