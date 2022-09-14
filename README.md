# Obligatorisk oppgave 1 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende studenter:
* Emma Louise Håkonsen, S362073, s362073@oslomet.no

# Arbeidsfordeling

Jeg jobbet alene på alle oppgavene (1, 2, 3, 4, 5, 7).

# Oppgavebeskrivelse

I **oppgave 1** gikk jeg frem ved å sjekke først om tabellen er tom, og i så fall kaster en exception.
Hvis tabellen ikke er tom, så går vi inn i en løkke som sjekker om verdien i hver indeks er mindre enn den som kommer
rett før den. Hvis if-setningen evalueres som True, bytter vi om de to verdiene (ved hjelp av metoden bytt()). Etter alle 
iterasjoner er den største verdien flyttet til den siste indeksen og den returneres. Metoden ombyttinger() fungerer
på samme måte, men den har også en tellevariabel som økes med 1 hver gang det gjøres en kall på bytt().

Det blir flest ombyttinger (n-1) når det største tallet ligger helt forrest i tabellen.
Når tabellen er sortert i stigende rekkefølge, er antall ombyttinger 0.
Antall ombyttinger i gjennomsnitt er gitt ved n-(log(n)-0.423).
Vi vet at i en tabell med n ulike tall, er i gjennomsnitt log(n)-0.423 av dem større enn det største av tallene foran. 
Denne maks-metoden flytter den største verdien bakerst i tabellen, dvs. det skjer en ombytting hver gang a[i-1] > a[i]. 
a[i-1] > a[0] blir da usant i gjennomsnitt log(n)-0.423 ganger, og sant i n-(log(n)-0.423) tilfeller. Jo større n, 
jo større antall gjennomsnittlige ombyttinger, og det blir alltid nesten lik n. Det er derfor en dårligere maks-metode 
enn de vi har sett før.

I **oppgave 2** satt jeg den første verdien i tabellen som maksverdi, og satt en teller til 1. Så brukte jeg en løkke 
til å iterere gjennom tabellen og oppdatere maksverdien hver gang vi finner et større tall, og telleren økes samtidig
med 1. Til slutt returnerer telleren antall ganger maksverdien ble oppdatert, dvs. antall ulike tall i tabellen.
Dette fungerer fordi tabellen skal være sortert; hvis a[i+1] ikke er større en a[i], er tabellen ikke sortert og det
kastes en IllegalStateException.

I **oppgave 3** begynte jeg med å initiere to tellere - en til antall unike tall (antall) og en til antall like tall (match).
'Antall' settes til 1 med en gang siden det første tallet i tabellen jo er unikt. Så går vi inn i en løkke som itererer 
gjennom alle tallen i tabellen, og for hvert tall går vi inn i en indre løkke som sammenligner hvert tall f.o.m. a[1] med 
alle tallene som kommer foran det. Dersom vi finner to like, så øker 'match' med 1 før vi kommer ut av den indre løkka.
I den ytre løkka økes telleren 'antall' med 1 hvis vi ikke finner to like tall i den iterasjonen, og så må 'match' settes
tilbake til 0 før den neste iterasjonen begynner. Til slutt er verdien i 'antall' returnert.

I **oppgave 4** brukte jeg en kvikksorteringsmetode rekursivt til å partisjonere tabellen i to deler og så sortere dem
hver for seg. Siden den første delen skal kun inneholder oddetall og den andre delen partall, finner metoden den 
absolutte verdien av a[i] % 2 - svaret blir 1 for oddetall og 0 for partall, så 1 kan da brukes som skilleverdi.
Hjelpemetoden oddEven går gjennom alle tallene i tabellen og evt. flytter de som ligger i feil delen, og den returnerer
v, som representerer det første partallet i tabellen. Metoden kvikksortering0 kjøres først på intervallet [0,v-1] dvs. 
oddetallene, og så på intervallet [v,a.length-1] dvs. partallene, og sorterer tallene i stigenede rekkefølge.

Metoden i **oppgave 5** sjekker først at tabellen inneholder mer enn 1 element, for da kan det ikke foretas noe rotasjon.
Den siste verdien i tabellen lagres i en hjelpevariabel. For-løkka starter på den nest siste verdien i tabellen og jobber
bakover; hver verdi flyttes en indeks til høyre. Til slutt settes verdien i hjelpevariabelen tilbake i tabellen på første
plass.

I **oppgave 7a** begynte jeg med å konvertere de to strengene til char array, og et nytt, tomt char array var lagd for å 
motta de flettede bokstavene. En while-løkke tar en bokstav vekselvis fra hvert array; når et av arrayene går tomt for 
bokstaver, fylles resten av plassene opp med bokstaver fra det andre arrayet. Til slutt er det nye arrayet konvertert 
til en streng som returneres.

For å løse **oppgave 7b** måtte jeg først finne lengden til det lengste ordet i String-arrayet - dette bestemmer hvor 
mange ganger (n) vi må loope gjennom arrayet. Så lagde jeg en StringBuilder for å motta de flettede bokstavene. I en 
for-løkke (som kjører n ganger - så vi kan være sikre på at vi tar med alle bokstavene i alle ordene) itererer vi gjennom 
ordene i arrayet og konverterer dem til char array. Dersom char arrayet ikke er tomt, går vi inn i en ny for-løkke som 
looper gjennom bokstavene i hvert ord og legger til en bokstav til StringBuilder. En 'break' i den indre for-løkka sørger 
for at kun en bokstav fra ordet legges til i hver iterasjon. Til slutt er StringBuilder konvertert til en streng og
returnert.