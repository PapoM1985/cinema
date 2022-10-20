Il programma è incompleto ma di seguito elenco i punti che ritengo degli di nota:

- applicazione del pattern STRATEGY
creazione interfaccia ISCONTO e della classi "ScontoGiovani" e "ScontoAdulti".
Tali classi vengono impostate nel meotodo "generabiglietto"

- gestione centralizzata degli errori REST
tramite le eccezioni UnexpectedException, ResourseNotFoundException e la classe globale che le gestisce "GlobalExceptionHandler"

- creazione di query che consentono di calcolare gli incassi della sala e del cinema
le query si trovano rispettivamente in saleRepository e cinemaRepository

- il database è correttamente normalizzato
per questo motivo sono state create le entità "REGISTI" e "PRODUTTORI" piuttosto che rendeli come campi "nome" per
la prima regola della normalizzazione queste entità devono essere mappate in apposite tabelle.
