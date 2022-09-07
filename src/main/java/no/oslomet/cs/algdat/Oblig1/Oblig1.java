package no.oslomet.cs.algdat.Oblig1;

import java.lang.UnsupportedOperationException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class Oblig1 {
    private Oblig1() {}

    ///// Oppgave 1 //////////////////////////////////////
    //For en tabell med n verdier er antall sammenligninger n-1
    public static int maks(int[] a) {
        if (a.length == 0)
            throw new NoSuchElementException("Tabellen a er tom!");
    
        for (int i = 1; i < a.length; i++) {
            if (a[i-1] > a[i]) {
                bytt(a,i,i-1);
            }
        }
    
        return a[a.length-1];
    }
    
    //Det blir flest ombyttinger (n-1) når det største tallet ligger helt forrest i tabellen.
    //Når tabellen er sortert i stigende rekkefølge, er antall ombyttinger 0.
    //Antall ombyttinger i gjennomsnitt er gitt ved n-(ln(n)-0.423).
    public static int ombyttinger(int[] a) {
        if (a.length == 0)
            throw new NoSuchElementException("Tabellen a er tom!");
        
        int ombyttinger = 0;
        
        for (int i = 1; i < a.length; i++) {
            if (a[i-1] > a[i]) {
                bytt(a,i,i-1);
                ombyttinger ++;
            }
        }
    
        return ombyttinger;
    
    }
    
    //Programkode 1.1.8 d)
    public static void bytt(int[] a, int i, int j) {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;		//bytter to verdier ved bruk av en hjelpevariabel
    }
    
    //Programkode 1.1.8 e)
    public static int[] randPerm(int n) // en effektiv versjon
    {
        Random r = new Random(); // en randomgenerator
        int[] a = new int[n]; // en tabell med plass til n tall
        Arrays.setAll(a, i -> i + 1); // legger inn tallene 1, 2, . , n
        for (int k = n - 1; k > 0; k--) // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1); // en tilfeldig tall fra 0 til k
            bytt(a,k,i); // bytter om
        }
        return a; // permutasjonen returneres
    }
    
    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
    
        if (a.length == 0) {
            return 0;
        }
        
        int antall = 1;
        int maks = a[0];
        
        for (int i = 1; i < a.length; i++) {
            if (a[i] < maks) {
                throw new IllegalStateException("Tabellen er ikke sortert!");
            } else if (a[i] > maks){
                maks = a[i];
                antall ++;
            }
        }
        return antall;
    }
    
    public static void main(String[] args) {
        int[] d = {3,3,14,17,27,29,29,43,99};
        System.out.print("Antall ulike tall: " + antallUlikeSortert(d));
    }

    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        throw new UnsupportedOperationException();
    }

    /// 7b)
    public static String flett(String... s) {
        throw new UnsupportedOperationException();
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
