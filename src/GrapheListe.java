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

        // 1. Si le noeud source n'existe pas dans le tableau, on l'ajoute
        if (this.noeuds.indexOf(noeudSrc) < 0) {
            this.noeuds.add(noeudSrc);
            this.adjacences.add(new Arcs()); // On cree sa liste d'adjacence vide synchrone
        }

        // 2. Si le noeud destination n'existe pas dans le tableau, on l'ajoute aussi
        if (this.noeuds.indexOf(noeudDest) < 0) {
            this.noeuds.add(noeudDest);
            this.adjacences.add(new Arcs()); // On cree sa liste d'adjacence vide synchrone
        }

        // 3. Maintenant qu'on est SUR que les noeuds existent, on recupere le bon indice de la source
        int indiceSrc = this.noeuds.indexOf(noeudSrc);

        // 4. On cree l'arc et on l'ajoute a la liste d'adjacence du noeud source
        Arc a = new Arc(noeudDest, poids);
        this.adjacences.get(indiceSrc).ajouterArc(a);
    }

    @Override
    public String toString() {
        return "GrapheListe{" +
                "noeuds=" + noeuds +
                ", adjacences=" + adjacences +
                '}';
    }
}
