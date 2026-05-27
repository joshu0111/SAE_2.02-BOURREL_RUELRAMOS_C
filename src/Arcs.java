import java.util.ArrayList;

public class Arcs {
    /** Attributs */
    ArrayList<Arc> listeArc;

    /**
     * Constructeur vide
     */
    public Arcs(){
        this.listeArc = new ArrayList<Arc>();
    }

    /**
     * Methode qui permet d'ajojuter un arc la liste des arcs
     * @param a Objet de type Arc
     */
    public void ajouterArc(Arc a){
        this.listeArc.add(a);
    }

    /**
     * Methode qui permet de recuperer la liste des arcs
     * @return ArrayList<Arc>
     */
    public ArrayList<Arc> getListeArc() {
        return listeArc;
    }
}
