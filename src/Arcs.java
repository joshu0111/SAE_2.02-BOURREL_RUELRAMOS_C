import java.util.ArrayList;

public class Arcs {
    /** Attributs */
    private ArrayList<Arc> listeArcs;

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

    /**
     * Methode toString()
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.listeArcs.size(); i++) {
            sb.append(this.listeArcs.get(i).toString());
            if (i < this.listeArcs.size() - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
