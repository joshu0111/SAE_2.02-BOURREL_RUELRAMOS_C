import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DjikstraTest {

    private GrapheListe creerGrapheExemple() {
        GrapheListe g = new GrapheListe();

        g.ajouterArc("A", "B", 12);
        g.ajouterArc("A", "C", 19);
        g.ajouterArc("A", "D", 87);

        g.ajouterArc("B", "D", 23);
        g.ajouterArc("B", "E", 11);

        g.ajouterArc("D", "C", 10);
        g.ajouterArc("D", "E", 43);

        return g;
    }

    @Test
    public void testDistancesDepuisA() {
        GrapheListe g = creerGrapheExemple();
        Djikstra djikstra = new Djikstra();

        Valeurs res = djikstra.resoudre(g, "A");

        assertEquals(0.0, res.getValeur("A"), 0.001);
        assertEquals(12.0, res.getValeur("B"), 0.001);
        assertEquals(19.0, res.getValeur("C"), 0.001);
        assertEquals(35.0, res.getValeur("D"), 0.001);
        assertEquals(23.0, res.getValeur("E"), 0.001);
    }

    @Test
    public void testParentsDepuisA() {
        GrapheListe g = creerGrapheExemple();
        Djikstra djikstra = new Djikstra();

        Valeurs res = djikstra.resoudre(g, "A");

        assertNull(res.getParent("A"));
        assertEquals("A", res.getParent("B"));
        assertEquals("A", res.getParent("C"));
        assertEquals("B", res.getParent("D"));
        assertEquals("B", res.getParent("E"));
    }

    @Test
    public void testCheminDepuisAVersC() {
        GrapheListe g = creerGrapheExemple();
        Djikstra djikstra = new Djikstra();

        Valeurs res = djikstra.resoudre(g, "A");

        List<String> chemin = res.calculerChemin("C");

        assertEquals(List.of("A", "C"), chemin);
        assertEquals(19.0, res.getValeur("C"), 0.001);
    }

    @Test
    public void testCheminDepuisAVersE() {
        GrapheListe g = creerGrapheExemple();
        Djikstra djikstra = new Djikstra();

        Valeurs res = djikstra.resoudre(g, "A");

        List<String> chemin = res.calculerChemin("E");

        assertEquals(List.of("A", "B", "E"), chemin);
        assertEquals(23.0, res.getValeur("E"), 0.001);
    }

    @Test
    public void testDepartB() {
        GrapheListe g = creerGrapheExemple();
        Djikstra djikstra = new Djikstra();

        Valeurs res = djikstra.resoudre(g, "B");

        assertEquals(0.0, res.getValeur("B"), 0.001);
        assertEquals(23.0, res.getValeur("D"), 0.001);
        assertEquals(33.0, res.getValeur("C"), 0.001);
        assertEquals(11.0, res.getValeur("E"), 0.001);

        assertNull(res.getParent("B"));
        assertEquals("B", res.getParent("D"));
        assertEquals("D", res.getParent("C"));
        assertEquals("B", res.getParent("E"));
    }

    @Test
    public void testArcPoidsNegatifIgnore() {
        GrapheListe g = new GrapheListe();

        g.ajouterArc("A", "B", -5);

        assertTrue(g.getListeNoeuds().isEmpty());
    }

    @Test
    public void testGrapheAvecUnSeulArc() {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 7);

        Djikstra djikstra = new Djikstra();
        Valeurs res = djikstra.resoudre(g, "A");

        assertEquals(0.0, res.getValeur("A"), 0.001);
        assertEquals(7.0, res.getValeur("B"), 0.001);

        assertNull(res.getParent("A"));
        assertEquals("A", res.getParent("B"));

        assertEquals(List.of("A", "B"), res.calculerChemin("B"));
    }
}