DROP SCHEMA IF EXISTS libraryLivingBook;
CREATE SCHEMA libraryLivingBook ;

USE libraryLivingBook;

CREATE TABLE Usuario(
ID int NOT NULL PRIMARY KEY AUTO_INCREMENT, 
nombre varchar(150) NOT NULL,
apellido varchar(150) NOT NULL,
userName varchar(150),
genero varchar(10),
birthday varchar(10),
paisOrigen varchar(30),
password varchar(500),
correo varchar(250),
numeroTelefono int,
numeroTarjeta int,
fechaUnion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
esAutor tinyint DEFAULT '0'
);
ALTER TABLE Usuario AUTO_INCREMENT =3005;

CREATE TABLE Autor(
IDUsuario int NOT NULL, 
fechaDeUnion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
descripcion varchar(200),
cantidadMeGusta int DEFAULT '0'
);
ALTER TABLE Autor ADD FOREIGN KEY(IDUsuario) REFERENCES Usuario(ID);

CREATE TABLE Libro(
ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
nombre varchar(150) NOT NULL, 
precio double(6,2) NOT NULL,
IDautor int NOT NULL,
fechaPublicacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
resenia varchar(500),
tipo varchar(100),
portada TEXT NOT NULL,
archivoPDF TEXT NOT NULL
);
ALTER TABLE Libro AUTO_INCREMENT = 2001;
ALTER TABLE Libro ADD FOREIGN KEY(IDautor) REFERENCES Autor(IDUsuario);

CREATE TABLE PopularidadLibro(
IDLibro int NOT NULL,
cantidadMeGusta int DEFAULT '0'
);
ALTER TABLE PopularidadLibro ADD FOREIGN KEY(IDLibro) REFERENCES Libro(ID) ON DELETE CASCADE;

CREATE TABLE AutorSeguido(
IDSeguidor int NOT NULL,
IDAutor int NOT NULL,
meGusta tinyint DEFAULT '0',
seguidoDesde TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
ALTER TABLE AutorSeguido ADD FOREIGN KEY(IDSeguidor) REFERENCES Usuario(ID);
ALTER TABLE AutorSeguido ADD FOREIGN KEY(IDAutor) REFERENCES Autor(IDUsuario);

CREATE TABLE LibroAdquirido(
IDUsuario int NOT NULL,
IDLibro int NOT NULL,
tiempoLectura int DEFAULT '0',
fechaAdquisicion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
meGusta tinyint DEFAULT '0'
);
ALTER TABLE LibroAdquirido ADD FOREIGN KEY(IDUsuario) REFERENCES Usuario(ID);
ALTER TABLE LibroAdquirido ADD FOREIGN KEY(IDLibro) REFERENCES Libro(ID) ON DELETE CASCADE;

CREATE TABLE Configuracion(
IDUsuario int NOT NULL,
tema varchar(20),
fotoPerfil TEXT,
fotoPortada TEXT,
preferencias varchar(2000)
);
ALTER TABLE Configuracion ADD FOREIGN KEY(IDUsuario) REFERENCES Usuario(ID);

CREATE TABLE Noticia(
fechaPublicacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
IDCreador int NOT NULL,
asunto varchar(150) NOT NULL,
tipo varchar(150),
contenido BLOB NOT NULL
);
ALTER TABLE Noticia ADD FOREIGN KEY(IDCreador) REFERENCES Autor(IDUsuario);
