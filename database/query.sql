SELECT A.idAcquisto, A.idDipendente ,D.nome AS dipendente, P.nome AS prodotto, F.nome AS fondo, A.qta, A.qta * P.prezzoUnita AS spesa, A.dataAcquisto
FROM Acquisto A, Prodotto P, Fondo F, Dipendente D
WHERE A.idDipendente = D.idDipendente AND
      A.idProdotto = P.idProdotto AND 
      A.idFondo = F.idFondo