import java.util.ArrayList;

/**
 * Interface graphe
 */
public interface Graphe {
    /**
     * Methode qui permet d'avoir la liste de tout les noeuds du graphe
     * @return la liste des noeuds du graphe
     */
    public ArrayList<String> getListeNoeuds();

    /**
     * Méthode qui permet d'avoir les noeuds adjacents correspondant au noeud
     * @param noeud noeud que l'on souhaite obtenir les neouds adjacents
     * @return les noeuds adjacents
     */
    public Arcs getNoeudAdjacence(String noeud);
}
