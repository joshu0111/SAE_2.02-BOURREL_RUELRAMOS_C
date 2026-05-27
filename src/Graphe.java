import java.util.ArrayList;

/**
 *
 */
public interface Graphe {
    public ArrayList<String> getListeNoeuds();
    public Arcs getNoeudAdjacence(String noeud);
}
