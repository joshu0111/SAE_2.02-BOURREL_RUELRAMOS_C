import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class ArcsTest {

    @Test
    public void test1_constructeur_vide() {
        Arcs arcs = new Arcs();

        assertNotNull(arcs.getListeArc(), "La liste d'arcs ne doit pas être nulle après initialisation.");
        assertTrue(arcs.getListeArc().isEmpty(), "La liste d'arcs doit être vide à la création.");
    }

    @Test
    public void test2_ajouterArc() {
        Arcs arcs = new Arcs();
        Arc arc1 = new Arc("B", 10.0);
        Arc arc2 = new Arc("C", 5.5);

        arcs.ajouterArc(arc1);
        arcs.ajouterArc(arc2);

        ArrayList<Arc> liste = arcs.getListeArc();
        assertEquals(2, liste.size(), "La liste devrait contenir exactement 2 arcs.");
        assertEquals(arc1, liste.get(0), "Le premier arc ajouté n'est pas au bon indice.");
        assertEquals(arc2, liste.get(1), "Le second arc ajouté n'est pas au bon indice.");
    }

    @Test
    public void test3_toString_liste_vide() {
        Arcs arcs = new Arcs();

        String resultat = arcs.toString();

        assertEquals("", resultat, "Le toString d'une liste vide devrait retourner une chaîne vide.");
    }

    @Test
    public void test4_toString_plusieurs_arcs() {
        Arcs arcs = new Arcs();
        arcs.ajouterArc(new Arc("B", 12.0));
        arcs.ajouterArc(new Arc("D", 87.0));

        String resultat = arcs.toString();

        // On s'assure qu'il y a bien un espace entre les arcs et pas d'espace en trop à la fin
        assertEquals("B(12.0) D(87.0)", resultat, "La méthode toString doit séparer les arcs par un espace.");
    }
}