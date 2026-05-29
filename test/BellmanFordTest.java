import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BellmanFordTest {

    private BellmanFord bf;
    private GrapheListe graphe;

    @BeforeEach
    public void setUp() {
        bf = new BellmanFord();

        // Initialisation du graphe
        graphe = new GrapheListe();
        graphe.ajouterArc("A", "B", 12);
        graphe.ajouterArc("A", "D", 87);
        graphe.ajouterArc("B", "E", 11);
        graphe.ajouterArc("C", "A", 19);
        graphe.ajouterArc("D", "B", 23);
        graphe.ajouterArc("D", "C", 10);
        graphe.ajouterArc("E", "D", 43);
    }

    /**
     * Test avec le graphe de l'énoncé en partant du nœud "A".
     * Vérifie les distances minimales et les parents associés.
     */
    @Test
    public void testBellmanFordGrapheSujetDepartA() {
        // Exécution de l'algorithme
        Valeurs resultats = bf.resoudre(graphe, "A");

        assertNotNull(resultats, "Le résultat ne doit pas être null");

        // Vérification des distances (Valeurs)
        assertEquals(0.0, resultats.getValeur("A"), "Distance de A à A doit être 0");
        // A -> B : 12
        assertEquals(12.0, resultats.getValeur("B"), "Distance de A à B doit être 12");
        // A -> B -> E : 12 + 11 = 23
        assertEquals(23.0, resultats.getValeur("E"), "Distance de A à E doit être 23");
        // A -> B -> E -> D : 23 + 43 = 66  (plus court que le chemin direct A->D à 87)
        assertEquals(66.0, resultats.getValeur("D"), "Distance de A à D doit être 66 (via E)");
        // A -> B -> E -> D -> C : 66 + 10 = 76
        assertEquals(76.0, resultats.getValeur("C"), "Distance de A à C doit être 76 (via D)");

        // Vérification des parents
        assertNull(resultats.getParent("A"), "Le noeud de départ A ne doit pas avoir de parent");
        assertEquals("A", resultats.getParent("B"), "Le parent de B doit être A");
        assertEquals("B", resultats.getParent("E"), "Le parent de E doit être B");
        assertEquals("E", resultats.getParent("D"), "Le parent de D doit être E (et non A)");
        assertEquals("D", resultats.getParent("C"), "Le parent de C doit être D");
    }

    /**
     * Test avec un nœud de départ différent ("D") sur le même graphe.
     */
    @Test
    public void testBellmanFordGrapheSujetDepartD() {
        Valeurs resultats = bf.resoudre(graphe, "D");

        // Vérification du chemin le plus court à partir de D
        // D -> C (10), D -> B (23)
        // D -> C -> A : 10 + 19 = 29
        // D -> B -> E : 23 + 11 = 34
        assertEquals(0.0, resultats.getValeur("D"));
        assertEquals(10.0, resultats.getValeur("C"));
        assertEquals(23.0, resultats.getValeur("B"));
        assertEquals(29.0, resultats.getValeur("A"));
        assertEquals(34.0, resultats.getValeur("E"));

        // Vérification des parents
        assertNull(resultats.getParent("D"));
        assertEquals("D", resultats.getParent("C"));
        assertEquals("D", resultats.getParent("B"));
        assertEquals("C", resultats.getParent("A"));
        assertEquals("B", resultats.getParent("E"));
    }

    /**
     * Test sur un graphe contenant un nœud totalement isolé.
     * Le nœud isolé doit garder une valeur de Double.MAX_VALUE et un parent null.
     */
    @Test
    public void testNoeudIsole() {
        GrapheListe gIsole = new GrapheListe();
        gIsole.ajouterArc("A", "B", 5);
        // On force l'ajout du noeud "C" sans aucun arc entrant ni sortant
        // (ajouterArc sur lui-même ou simplement présent dans la liste)
        gIsole.ajouterArc("C", "C", 0);

        Valeurs resultats = bf.resoudre(gIsole, "A");

        // A et B doivent être connectés
        assertEquals(0.0, resultats.getValeur("A"));
        assertEquals(5.0, resultats.getValeur("B"));
        assertEquals("A", resultats.getParent("B"));

        // C est inaccessible depuis A
        assertEquals(Double.MAX_VALUE, resultats.getValeur("C"), "Un noeud inaccessible doit rester à MAX_VALUE");
        assertNull(resultats.getParent("C"), "Un noeud inaccessible ne doit pas avoir de parent");
    }
}