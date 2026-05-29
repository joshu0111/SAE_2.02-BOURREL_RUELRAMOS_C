import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ArcTest {

    @Test
    public void test1_constructeur_et_attributs() {
        String noeudCible = "B";
        double poids = 12.5;

        Arc arc = new Arc(noeudCible, poids);

        assertEquals(noeudCible, arc.getnCible(), "Le noeud cible doit être correctement initialisé.");
        assertEquals(poids, arc.getPoids(), "Le poids doit être correctement initialisé.");
    }

    @Test
    public void test2_toString() {
        // Given
        Arc arc = new Arc("C", 42.0);

        // When
        String resultat = arc.toString();

        // Then
        assertEquals("C(42.0)", resultat, "La méthode toString ne retourne pas le format attendu 'Noeud(Poids)'.");
    }
}