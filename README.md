# Obligatorisk oppgave 1 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende studenter:
* Emma Louise Håkonsen, S362073, s362073@oslomet.no

# Arbeidsfordeling

Jeg har jobbet alene på alle oppgavene.

# Oppgavebeskrivelse

I oppgave 1 så gikk jeg frem ved å sjekke først om tabellen er tom, og i så fall kaster en exception.
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
jo nærmere kommer antall gjennomsnittlige ombyttinger til n. Det er derfor en dårligere maks-metode enn de vi har sett før.

I oppgave 2 så brukte vi en ... til å ...
