import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class GrapheListeTest {

    private GrapheListe creerGrapheExemple() {
        GrapheListe graphe = new GrapheListe();

        graphe.ajouterArc("A", "B", 12);
        graphe.ajouterArc("A", "D", 87);
        graphe.ajouterArc("B", "E", 11);
        graphe.ajouterArc("C", "A", 19);
        graphe.ajouterArc("D", "B", 23);
        graphe.ajouterArc("D", "C", 10);
        graphe.ajouterArc("E", "D", 43);

        return graphe;
    }

    @Test
    public void test1_getListeNoeuds_verifieTousLesNoeudsAjoutes() {
        GrapheListe graphe = creerGrapheExemple();

        ArrayList<String> noeuds = graphe.getListeNoeuds();

        assertEquals(5, noeuds.size());
        assertTrue(noeuds.contains("A"));
        assertTrue(noeuds.contains("B"));
        assertTrue(noeuds.contains("C"));
        assertTrue(noeuds.contains("D"));
        assertTrue(noeuds.contains("E"));
    }

    @Test
    public void test2_getNoeudAdjacence_verifieArcsDuNoeudA() {
        GrapheListe graphe = creerGrapheExemple();

        Arcs arcsA = graphe.getNoeudAdjacence("A");

        assertNotNull(arcsA);
        assertEquals(2, arcsA.getListeArc().size());

        assertEquals("B", arcsA.getListeArc().get(0).getnCible());
        assertEquals(12, arcsA.getListeArc().get(0).getPoids());

        assertEquals("D", arcsA.getListeArc().get(1).getnCible());
        assertEquals(87, arcsA.getListeArc().get(1).getPoids());
    }

    @Test
    public void test3_getNoeudAdjacence_verifieArcsDuNoeudB() {
        GrapheListe graphe = creerGrapheExemple();

        Arcs arcsB = graphe.getNoeudAdjacence("B");

        assertNotNull(arcsB);
        assertEquals(1, arcsB.getListeArc().size());

        assertEquals("E", arcsB.getListeArc().get(0).getnCible());
        assertEquals(11, arcsB.getListeArc().get(0).getPoids());
    }

    @Test
    public void test4_getNoeudAdjacence_verifieArcsDuNoeudC() {
        GrapheListe graphe = creerGrapheExemple();

        Arcs arcsC = graphe.getNoeudAdjacence("C");

        assertNotNull(arcsC);
        assertEquals(1, arcsC.getListeArc().size());

        assertEquals("A", arcsC.getListeArc().get(0).getnCible());
        assertEquals(19, arcsC.getListeArc().get(0).getPoids());
    }

    @Test
    public void test5_getNoeudAdjacence_verifieArcsDuNoeudD() {
        GrapheListe graphe = creerGrapheExemple();

        Arcs arcsD = graphe.getNoeudAdjacence("D");

        assertNotNull(arcsD);
        assertEquals(2, arcsD.getListeArc().size());

        assertEquals("B", arcsD.getListeArc().get(0).getnCible());
        assertEquals(23, arcsD.getListeArc().get(0).getPoids());

        assertEquals("C", arcsD.getListeArc().get(1).getnCible());
        assertEquals(10, arcsD.getListeArc().get(1).getPoids());
    }

    @Test
    public void test6_getNoeudAdjacence_verifieArcsDuNoeudE() {
        GrapheListe graphe = creerGrapheExemple();

        Arcs arcsE = graphe.getNoeudAdjacence("E");

        assertNotNull(arcsE);
        assertEquals(1, arcsE.getListeArc().size());

        assertEquals("D", arcsE.getListeArc().get(0).getnCible());
        assertEquals(43, arcsE.getListeArc().get(0).getPoids());
    }

    @Test
    public void test7_getNoeudAdjacence_retourneNullSiNoeudInexistant() {
        GrapheListe graphe = creerGrapheExemple();

        assertNull(graphe.getNoeudAdjacence("Z"));
    }

    @Test
    public void test8_ajouterArc_ignoreArcAvecPoidsNegatif() {
        GrapheListe graphe = new GrapheListe();

        graphe.ajouterArc("A", "B", -5);

        assertEquals(0, graphe.getListeNoeuds().size());
        assertNull(graphe.getNoeudAdjacence("A"));
    }

    @Test
    public void test9_toString_verifieAffichageDuGraphe() {
        GrapheListe graphe = creerGrapheExemple();

        String attendu =
                "A -> B(12.0) D(87.0)\n" +
                        "B -> E(11.0)\n" +
                        "D -> B(23.0) C(10.0)\n" +
                        "E -> D(43.0)\n" +
                        "C -> A(19.0)\n";

        assertEquals(attendu, graphe.toString());
    }
}