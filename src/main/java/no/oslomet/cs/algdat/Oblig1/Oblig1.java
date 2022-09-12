package no.oslomet.cs.algdat.Oblig1;

import java.lang.UnsupportedOperationException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class Oblig1 {
    private Oblig1() {
    }
    
    ///// Oppgave 1 //////////////////////////////////////
    //For en tabell med n verdier er antall sammenligninger n-1
    public static int maks(int[] a) {
        if (a.length == 0)
            throw new NoSuchElementException("Tabellen a er tom!");
    
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {              //inversjon
                bytt(a, i, i - 1);
            }
        }
        return a[a.length - 1];         //returnerer siste verdi i tabellen
    }
    
    //Det blir flest ombyttinger (n-1) når det største tallet ligger helt forrest i tabellen.
    //Når tabellen er sortert i stigende rekkefølge, er antall ombyttinger 0.
    //Antall ombyttinger i gjennomsnitt er gitt ved n-(log(n)-0.423).
    public static int ombyttinger(int[] a) {
        if (a.length == 0)
            throw new NoSuchElementException("Tabellen a er tom!");
        
        int ombyttinger = 0;            //initierer teller
        
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {          //inversjon
                bytt(a, i, i - 1);
                ombyttinger++;              //øker telleren med 1
            }
        }
        return ombyttinger;
    }
    
    //Programkode 1.1.8 d) fra kompendiet
    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;        //bytter to verdier ved bruk av en hjelpevariabel
    }
    
    //Programkode 1.1.8 e) fra kompendiet
    public static int[] randPerm(int n) // en effektiv versjon
    {
        Random r = new Random(); // en randomgenerator
        int[] a = new int[n]; // en tabell med plass til n tall
        Arrays.setAll(a, i -> i + 1); // legger inn tallene 1, 2, . , n
        for (int k = n - 1; k > 0; k--) // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k + 1); // en tilfeldig tall fra 0 til k
            bytt(a, k, i); // bytter om
        }
        return a; // permutasjonen returneres
    }
    
    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
    
        if (a.length == 0) {
            return 0;               //håndterer tomme tabeller
        }
        
        int antall = 1;             //initierer teller
        int maks = a[0];            //setter første verdi i tabellen som maksverdi
        
        for (int i = 1; i < a.length; i++) {
            if (a[i] < maks) {
                throw new IllegalStateException("Tabellen er ikke sortert!"); //exception hvis i ikke øker i verdi for hver iterasjon
            } else if (a[i] > maks) {
                maks = a[i];
                antall++;       //øker telleren med 1 hver gang vi får en ny maksverdi
            }
        }
        return antall;
    }
    
    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        int antall = 1;         //initierer teller for antall unike tall
        int match = 0;          //initierer teller for antall like tall
    
        if (a.length == 0) {
            return 0;               //håndterer tomme tabeller
        } else {
            for (int i = 1; i < a.length; i++) {
                for (int j = 0; j < i; j++) {    //indre løkke: a[i] sammenlignes med alle tall a[0,i>
                    if (a[i] == a[j]) {
                        match++;                //øker telleren hver gang a[i] og a[j] har like verdier
                    }
                } if (match == 0) {
                    antall++;           //hvis vi ikke finner en match, skal antall unike tall økes med 1
                }
                match = 0;          //resetter match så den blir 0 til neste sjekk!
            }
        } return antall;        //returnerer antall unike tall i tabellen
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        parter0(a, 0, a.length-1, 1);
        kvikksortering(a, 0, a.length-1);
    }
    
    public static int isOdd(int[] a, int i) {
        if (a[i] % 2 == 1) { return 1;
        } return 0;
    }
    
    //Adaptert fra Programkode 1.3.9 a)
    private static int parter0(int[] a, int v, int h, int skilleverdi)
    {
        while (true)                                  // stopper når v > h
        {
            while (v <= h && isOdd(a,v) >= skilleverdi) v++;   // h er stoppverdi for v
            while (v <= h && isOdd(a,h) < skilleverdi) h--;  // v er stoppverdi for h
            
            if (v < h) bytt(a,v++,h--);                 // bytter om a[v] og a[h]
            else  return v;  // a[v] er nåden første som ikke er mindre enn skilleverdi
        }
    }
    
    public static void kvikksortering(int[] a, int fra, int til) // a[fra:til>
    {
        fratilKontroll(a.length, fra, til);  // sjekker når metoden er offentlig
        kvikksortering0(a, fra, til - 1);  // v = fra, h = til - 1
    }
    
    public static void fratilKontroll(int tablengde, int fra, int til)
    {
        if (fra < 0)                                  // fra er negativ
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");
        
        if (til > tablengde)                          // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + tablengde + ")");
        
        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }
    
    //Programkode 1.3.9 h)
    private static void kvikksortering0(int[] a, int v, int h)  // en privat metode
    {
        if (v >= h) return;  // a[v:h] er tomt eller har maks ett element
        int k = parter0(a, v, h, (v + h)/2);  // bruker midtverdien
        kvikksortering0(a, v, k - 1);     // sorterer intervallet a[v:k-1]
        kvikksortering0(a, k + 1, h);     // sorterer intervallet a[k+1:h]
    }
    
    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        if (a.length != 0 && a.length != 1) {   //rotasjon skjer bare hvis tabellen er lengre enn 1 element
            char sist = a[a.length-1];          //sparer på siste verdien i tabellen
            for (int i = a.length-2; i >= 0; i--) {
                a[i+1] = a[i];              //starter med nest siste indeks og flytter hvert element 1 posisjon til høyre
            }
            a[0] = sist;        //siste element settes tilbake i første posisjon
        }
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    //Adaptert fra Programkode 1.3.11 a) fra kompendiet
    public static String flett(String s, String t) {
        char[] s1 = s.toCharArray();        //konverterer s til et char array
        char[] t1 = t.toCharArray();        //konverterer t til et char array
        
        char[] c = new char[(s1.length + t1.length)];   //lager et tomt char array med plass til alle char i s1 + t1
        int i = 0, j = 0, k = 0;                 //initialiserer løkkevariabler
        
        while (i < s1.length && j < t1.length) {
            c[k++] = s1[i++];       //først tilordner en verdi fra s1
            c[k++] = t1[j++];       //så tilordner en verdi fra t1
        }
        
        //hvis s1 og t1 ikke er like lange, vil kun en av disse while-løkkene kjører og fyller inn de resterende plassene
        while (i < s1.length) c[k++] = s1[i++];
        while (j < t1.length) c[k++] = t1[j++];
        
        String string = new String(c);      //konverterer c tilbake til en streng
        return string;                //returnerer den flettede strengen
    }

    /// 7b)
    public static String flett(String... s) {
        int n = 0;          //initialiserer n (lengden av den lengste strengen)
        if (s.length == 0) {        //håndterer tomme tabeller
            n = 0;
        } else{
            n = s[0].length();        //finner ut lengden n av den lengste strengen i s - algoritmen må kjøres n ganger
            for (int i = 0; i < s.length; i++) {
                if (n < s[i].length()) {
                    n = s[i].length();
                }
            }
        }
        
        StringBuilder c = new StringBuilder();      //lager tom variabel for å motta de flettede char
        int count = 0;              //initierer antall iterasjoner gjennom s
        
        //for-løkka fortsetter å løpe mens det ligger ubrukte char i tabellen
        while (count < n) {
            for (int i = 0; i < s.length; i++) {        //looper gjennom ordene i tabellen s
                char[] word = s[i].toCharArray();       //konverterer strengen til char array
                if (word.length != 0) {         //for alle ikke-tomme strenger:
                    for (int j = count; j < s[i].length(); j++) {       //looper gjennom char i hvert ord
                        c.append(word[j]);          //legger til char i output-variabelen
                        break;      //det skal bare tas en char fra hvert ord!
                    }
                }
            }
            count++;       //øker antall iterasjoner med 1
    
        }
        return c.toString();    //konverterer de flettede char til en streng og returnerer
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new UnsupportedOperationException();
    }

}  // Oblig1
