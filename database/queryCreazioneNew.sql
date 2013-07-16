PRAGMA foreign_keys = ON;

CREATE TABLE "Dipendente" ("idDipendente" INTEGER PRIMARY KEY AUTOINCREMENT, 
													 "nome" VARCHAR NOT NULL, 
													 "cognome" VARCHAR NOT NULL , 
													 "email" VARCHAR NOT NULL  UNIQUE , 
													 "password" VARCHAR NOT NULL , 
													 "tipo" VARCHAR NOT NULL );


CREATE TABLE "Prodotto" ("idProdotto" INTEGER PRIMARY KEY AUTOINCREMENT,
												 "nome" VARCHAR NOT NULL UNIQUE,
												 "qta" INTEGER NOT NULL,
												 "prezzoUnita" FLOAT NOT NULL );

CREATE TABLE "Fondo" ("idFondo" INTEGER PRIMARY KEY AUTOINCREMENT,
											"nome" VARCHAR NOT NULL UNIQUE,
											"fondoDisponibile" FLOAT NOT NULL );

CREATE  TABLE IF NOT EXISTS "Acquisto" (
        `idAcquisto`  INTEGER PRIMARY KEY ,
        `idDipendente` INTEGER REFERENCES Dipendente (idDipendente) ON DELETE SET NULL ON UPDATE NO ACTION,
        `idProdotto` INTEGER REFERENCES Prodotto (idProdotto) ON DELETE SET NULL ON UPDATE NO ACTION,
        'idFondo' INTEGER REFERENCES Fondo (idFondo) ON DELETE SET NULL ON UPDATE NO ACTION,
        `qta` INTEGER NOT NULL ,
        `dataAcquisto` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP );

CREATE TABLE "Notifica" ("idNotifica" INTEGER PRIMARY KEY ,
                         "idDipendente" INTEGER  REFERENCES Dipendente (idDipendente) ON DELETE SET NULL ON UPDATE CASCADE,
                         "idDipendenteNotificato" INTEGER NOT NULL REFERENCES Dipendente (idDipendente) ON DELETE CASCADE ON UPDATE CASCADE,
                         "notifica" TEXT NOT NULL,
                         "dataNotifica" DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP );


CREATE TABLE "Aggiornamento" ("idAggiornamento" INTEGER PRIMARY KEY ,
                              "idDipendente" INTEGER NOT NULL REFERENCES Dipendente (idDipendente) ON DELETE NO ACTION ON UPDATE CASCADE,
                              "idProdotto" INTEGER NOT NULL REFERENCES Dipendente (idDipendente) ON DELETE CASCADE ON UPDATE CASCADE,
                              "qta" INTEGER NOT NULL,
                              "dataAggiornamento" DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP );

INSERT INTO Dipendente VALUES (1,'Matteo','Calò','emmeci92@gmail.com','matteo','responsabile');
INSERT INTO Dipendente VALUES (2,'Alessandro','Pendinelli','pendi03@gmail.com','ale','responsabile');
INSERT INTO Dipendente VALUES (3,'Davide','Pastore','pingas@gmail.com','dav','dipendente');

INSERT INTO Prodotto VALUES (1,'HD',25,30.00);
INSERT INTO Prodotto VALUES (2,'S3',25,60.00);

INSERT INTO Fondo VALUES (1,'regione', 23000.00);

INSERT INTO Acquisto ("idDipendente","idProdotto","idFondo","qta") VALUES (1,1,1,20);
INSERT INTO Acquisto ("idDipendente","idProdotto","idFondo","qta") VALUES (1,2,1,20);
INSERT INTO Acquisto ("idDipendente","idProdotto","idFondo","qta") VALUES (2,1,1,20);
