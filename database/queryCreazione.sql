PRAGMA foreign_keys = ON;

CREATE TABLE "Dipendente" ("idDipendente" INTEGER PRIMARY KEY AUTOINCREMENT, 
                           "nome" VARCHAR NOT NULL, 
                           "cognome" VARCHAR NOT NULL , 
                           "email" VARCHAR NOT NULL  UNIQUE , 
                           "password" VARCHAR NOT NULL , 
                           "tipo" VARCHAR NOT NULL,
                           "isActive" BOOLEAN NOT NULL);


CREATE TABLE "Prodotto" ("idProdotto" INTEGER PRIMARY KEY AUTOINCREMENT,
                         "nome" VARCHAR NOT NULL UNIQUE,
                         "qta" INTEGER NOT NULL,
                         "prezzoUnita" FLOAT NOT NULL );

CREATE TABLE "Fondo" ("idFondo" INTEGER PRIMARY KEY AUTOINCREMENT,
                      "nome" VARCHAR NOT NULL UNIQUE,
                      "fondoDisponibile" FLOAT NOT NULL );

CREATE  TABLE IF NOT EXISTS "Acquisto" (
        `idAcquisto`  INTEGER PRIMARY KEY ,
        `idDipendente` INTEGER ,
        `idProdotto` INTEGER ,
        'idFondo' INTEGER ,
        `qta` INTEGER NOT NULL ,
        `dataAcquisto` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ,

  CONSTRAINT `fk_acquisto_dipendente`
    FOREIGN KEY (`idDipendente` )
      REFERENCES `Dipendente` (`idDipendente` )
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,

  CONSTRAINT `fk_acquisto_prodotto`
    FOREIGN KEY (`idProdotto` )
      REFERENCES `Prodotto` (`idProdotto` )
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,

  CONSTRAINT `fk_acquisto_fondo`
    FOREIGN KEY (`idFondo` )
      REFERENCES `Fondo` (`idFondo` )
        ON DELETE NO ACTION
        ON UPDATE NO ACTION);

CREATE INDEX 'fk_acquisto_dipendente' ON 'Acquisto' ('idDipendente' ASC);
CREATE INDEX 'fk_acquisto_prodotto' ON 'Acquisto' ('idProdotto' ASC);
CREATE INDEX 'fk_acquisto_fondo' ON 'Acquisto' ('idFondo' ASC);

CREATE TABLE "Notifica" ("idNotifica" INTEGER PRIMARY KEY ,
                         "idDipendente" INTEGER  ,
                         "idDipendenteNotificato" INTEGER NOT NULL,
                         "notifica" TEXT NOT NULL,
                         "dataNotifica" DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         "isValidate" BOOLEAN NOT NULL DEFAULT 'true',

CONSTRAINT 'fk_notifica_dipendente'                         
FOREIGN KEY ('idDipendente')
  REFERENCES 'Dipendente' ('idDipendente') 
    ON DELETE NO ACTION
    ON UPDATE CASCADE

CONSTRAINT 'fk_notifica_dipendenteNotificato'
FOREIGN KEY ('idDipendenteNotificato') 
  REFERENCES 'Dipendente' ('idDipendente') 
    ON DELETE CASCADE
    ON UPDATE CASCADE );

CREATE INDEX 'fk_notifica_dipendente' ON 'Notifica' ('idDipendente' ASC);
CREATE INDEX 'fk_notifica_dipendenteNotificato' ON 'Notifica' (idDipendenteNotificato ASC);

CREATE TABLE "Aggiornamento" ("idAggiornamento" INTEGER PRIMARY KEY ,
                              "idDipendente" INTEGER NOT NULL,
                              "idProdotto" INTEGER NOT NULL ,
                              "qta" INTEGER NOT NULL,
                              "dataAggiornamento" DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                              "isValidate" BOOLEAN NOT NULL DEFAULT 'true',

CONSTRAINT 'fk_aggiornamento_dipendente'                              
  FOREIGN KEY('idDipendente') 
    REFERENCES 'Dipendente' ('idDipendente') 
      ON DELETE NO ACTION 
      ON UPDATE CASCADE

CONSTRAINT 'fk_aggiornamento_prodotto'
FOREIGN KEY('idProdotto') 
  REFERENCES 'Prodotto' ('idProdotto') 
    ON DELETE CASCADE 
    ON UPDATE CASCADE );

INSERT INTO Dipendente VALUES (1,'Matteo','Calò','emmeci92@gmail.com','matteo','responsabile','true');
INSERT INTO Dipendente VALUES (2,'Alessandro','Pendinelli','pendi03@gmail.com','ale','responsabile','true');
INSERT INTO Dipendente VALUES (3,'Davide','Pastore','pingas@gmail.com','dav','dipendente','true');

INSERT INTO Prodotto VALUES (1,'HD',25,30.00);
INSERT INTO Prodotto VALUES (2,'S3',25,60.00);

INSERT INTO Fondo VALUES (1,'Fondo della regione', 23000.00);

INSERT INTO Acquisto ("idDipendente","idProdotto","idFondo","qta") VALUES (1,1,1,20);
INSERT INTO Acquisto ("idDipendente","idProdotto","idFondo","qta") VALUES (1,2,1,20);
INSERT INTO Acquisto ("idDipendente","idProdotto","idFondo","qta") VALUES (2,1,1,20);
