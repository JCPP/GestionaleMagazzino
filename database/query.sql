
-- Inserire nuovo prodotto -- 

"INSERT into magazzino.prodotto (idProdotto, nome, qta, prezzoUnita)
VALUES (,"+nome+","+qta+","+prezzo+")";

-- Inserire nuovo fondo --
"INSERT into magazzino.fondo (idFondo, nome, fondoDisponibile)
VALUES (,"+nome+","+importo+")";

-- Inserire nuovo acquisto --
-- La data è inserita automaticamente --
"INSERT into acquisto.prodotto (idAcquisto, idDipendente, idProdotto, idFondo, qta, dataAcquisto)
VALUES (,"+idDipendente+","+idProdotto+","+idFondo+","+qta+",)";

-- Inserire nuova notifica --
-- La data è inserita automaticamente --
"INSERT into notifica.prodotto (idNotifica, idDipendente, idDipendenteNotificato, notifica, dataNotifica)
VALUES (,"+idDipendente+","+idNotificato+","+idFondo+","+qta+",)";

