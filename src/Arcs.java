import java.util.ArrayList;

public class Arcs {
    /** Attributs */
    ArrayList<Arc> listeArcs;

    /**
     * Constructeur vide
     */
    public Arcs(){
        this.listeArcs = new ArrayList<Arc>();
    }

    /**
     * Methode qui permet d'ajouter un arc la liste des arcs
     * @param a Objet de type Arc
     */
    public void ajouterArc(Arc a){
        this.listeArcs.add(a);
    }

    /**
     * Methode qui permet de recuperer la liste des arcs
     * @return ArrayList<Arc>
     */
    public ArrayList<Arc> getListeArc() {
        return listeArcs;
    }
}
