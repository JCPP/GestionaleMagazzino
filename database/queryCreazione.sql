CREATE TABLE "Dipendente" ("idDipendente" INTEGER PRIMARY KEY  NOT NULL , 
                           "nome" VARCHAR NOT NULL , 
                           "cognome" VARCHAR NOT NULL , 
                           "email" VARCHAR NOT NULL  UNIQUE , 
                           "password" VARCHAR NOT NULL , 
                           "tipo" VARCHAR NOT NULL )

CREATE TABLE "Prodotto" ("idProdotto" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                         "nome" VARCHAR NOT NULL UNIQUE,
                         "qta" INTEGER NOT NULL,
                         "prezzoUnita" FLOAT NOT NULL )

CREATE TABLE "Fondo" ("idFondo" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                      "nome" VARCHAR NOT NULL UNIQUE,
                      "fondoDisponibile" FLOAT NOT NULL )

CREATE TABLE "Acquisto" ("idAcquisto" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                         "idDipendente" INTEGER NOT NULL,
                         "idProdotto" INTEGER NOT NULL,
                         "idFondo" INTEGER NOT NULL,
                         "qta" INTEGER NOT NULL,
                         "dataAcquisto" DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY(idDipendente) 
  REFERENCES Dipendente(idDipendente) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION
FOREIGN KEY(idProdotto) 
  REFERENCES Prodotto(idProdotto) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION 
FOREIGN KEY(idFondo) 
  REFERENCES Fondo(idFondo) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION )

CREATE TABLE "Notifica" ("idNotifica" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,
                         "idDipendente" INTEGER NOT NULL,
                         "idDipendenteNotificato" INTEGER NOT NULL,
                         "notifica" TEXT NOT NULL,
                         "dataNotifica" DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY(idDipendente) 
  REFERENCES Dipendente(idDipendente) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION
FOREIGN KEY(idDipendenteNotificato) 
  REFERENCES Dipendente(idDipendente) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION )

CREATE TABLE "Aggiornamento" ("idAggiornamento" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                              "idDipendente" INTEGER NOT NULL,
                              "idProdotto" INTEGER NOT NULL,
                              "qta" INTEGER NOT NULL,
                              "dataAggiornamento" DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY(idDipendente) 
  REFERENCES Dipendente(idDipendente) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION
FOREIGN KEY(idProdotto) 
  REFERENCES Prodotto(idProdotto) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION )