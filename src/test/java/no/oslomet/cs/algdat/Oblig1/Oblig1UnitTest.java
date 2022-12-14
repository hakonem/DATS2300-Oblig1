package no.oslomet.cs.algdat.Oblig1;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Denne klassen kan du bruke til hjelp under utvikling av din oblig.
 * Lag små og enkle test-eksempler for å teste at metoden din fungerer som ønsket.
 */
class Oblig1UnitTest {

    @org.junit.jupiter.api.Test
    void maks() {
        int n = 50;
        int[] a = Oblig1.randPerm(n);
        
        int maksimum = Oblig1.maks(a);
        
        assertEquals(50, maksimum, "Implementer maks og denne testen");
        
        //Test for alle permutasjoner for 4 tall
        {
            int[][] perm4 = {
                    {1,2,3,4},{1,2,4,3},{1,3,2,4},{1,3,4,2},{1,4,2,3},{1,4,3,2},
                    {2,1,3,4},{2,1,4,3},{2,3,1,4},{2,3,4,1},{2,4,1,3},{2,4,3,1},
                    {3,1,2,4},{3,1,4,2},{3,2,1,4},{3,2,4,1},{3,4,1,2},{3,4,2,1},
                    {4,1,2,3},{4,1,3,2},{4,2,1,3},{4,2,3,1},{4,3,1,2},{4,3,2,1}
            };
            int expected[] = {
                    4,4,4,4,4,4,
                    4,4,4,4,4,4,
                    4,4,4,4,4,4,
                    4,4,4,4,4,4
            };
            
            for (int i = 0; i < perm4.length; i++) {
                assertEquals(expected[i], Oblig1.maks(perm4[i]));
            }
        }
        
        //Test spesialtilfeller
        int[] b = {3,6,1,99,43,77,8,37,63,345};     //maks verdi ligger bakerst
        assertEquals(345, Oblig1.maks(b), "Implementer maks og denne testen");
        
        int[] c = {345,6,1,99,43,3,8,37,63,77};     //maks verdi ligger forrest
        assertEquals(345, Oblig1.maks(c), "Implementer maks og denne testen");
        
    }

    @org.junit.jupiter.api.Test
    void ombyttinger() {
    
        int[] a = {3,6,1,99,43,77,8,37,63,345};
    
        int ombyttinger = Oblig1.ombyttinger(a);
        
        assertEquals(6, ombyttinger, "Implementer ombyttinger og denne testen");
    }

    @org.junit.jupiter.api.Test
    void antallUlikeSortert() {
        assertEquals(true, false, "Implementer antallUlikeSortert og denne testen");
    }

    @org.junit.jupiter.api.Test
    void antallUlikeUsortert() {
        int[] a = {3,4,3,5,7,9,7,18};
        int antallUlike = Oblig1.antallUlikeUsortert(a);
        assertEquals(6, antallUlike, "Implementer antallUlikeUsortert og denne testen");
    }

    @org.junit.jupiter.api.Test
    void delsortering() {
        int[] a = {13,2,8,10,16,9,15,4,18,1,3};
        int expected[] = {1,3,9,13,15,2,4,8,10,16,18};
        assertEquals(true, false, "Implementer delsortering og denne testen");
    }

    @org.junit.jupiter.api.Test
    void rotasjon() {
        assertEquals(true, false, "Implementer rotasjon og denne testen");
    }

    @org.junit.jupiter.api.Test
    void flett() {
        String[] a = {"AM ", "L", "GEDS", "ORATKRR", "", "R TRTE", "IO", "TGAUU"};
        String ut = Oblig1.flett(a);
        assertEquals("ALGORITMER OG DATASTRUKTURER", ut, "Implementer flett og denne testen");
    }

    @org.junit.jupiter.api.Test
    void indekssortering() {
        assertEquals(true, false, "Implementer indekssortering og denne testen");
    }

    @org.junit.jupiter.api.Test
    void tredjeMin() {
        assertEquals(true, false, "Implementer tredjeMin og denne testen");
    }

    @org.junit.jupiter.api.Test
    void bokstavNr() {
        assertEquals(true, false, "Implementer bokstavNr og denne testen");
    }

    @org.junit.jupiter.api.Test
    void inneholdt() {
        assertEquals(true, false, "Implementer inneholdt og denne testen");
    }
}