import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ArcTest {

    @Test
    public void test1_constructeur_et_attributs() {
        // Given
        String noeudCible = "B";
        double poids = 12.5;

        // When
        Arc arc = new Arc(noeudCible, poids);

        // Then
        // Note : Comme les attributs sont package-private (visibilité par défaut), 
        // ils sont accessibles directement si le test est dans le même package.
        assertEquals(noeudCible, arc.getnCible(), "Le nœud cible doit être correctement initialisé.");
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