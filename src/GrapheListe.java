import java.util.ArrayList;

public class GrapheListe implements Graphe{
    ArrayList<String> noeuds;
    ArrayList<Arcs> adjacences;

    public GrapheListe(){
        this.noeuds = new ArrayList<String>();
        this.adjacences = new ArrayList<Arcs>();
    }

    @Override
    public ArrayList<String> getListeNoeuds(){
        return this.noeuds;
    }

    @Override
    public Arcs getNoeudAdjacence(String noeud){
        int indiceNoeud = this.noeuds.indexOf(noeud);
        if (indiceNoeud < 0){
            return null;
        }
        return this.adjacences.get(indiceNoeud);
    }

    /**
     * Methode qui permet d'ajouter un arc au graphe
     * @param noeudSrc String qui correspond a l'identifiant du noeud
     * @param noeudDest String qui correspond a l'identifiant du noeud
     * @param poids Double qui corredpond au poids de l'arc
     */
    public void ajouterArc(String noeudSrc, String noeudDest, double poids){
        // Verification du poids
        if (poids < 0) {
            return;
        }
        if (this.noeuds.indexOf(noeudSrc) < 0) {
            this.noeuds.add(noeudSrc);
            this.adjacences.add(new Arcs());
        }
        if (this.noeuds.indexOf(noeudDest) < 0) {
            this.noeuds.add(noeudDest);
            this.adjacences.add(new Arcs());
        }
        int indiceSrc = this.noeuds.indexOf(noeudSrc);
        Arc a = new Arc(noeudDest, poids);
        this.adjacences.get(indiceSrc).ajouterArc(a);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.noeuds.size(); i++) {
            String noeudSrc = this.noeuds.get(i);
            Arcs adj = this.adjacences.get(i);
            sb.append(noeudSrc);
            sb.append(" -> ");
            sb.append(adj.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
