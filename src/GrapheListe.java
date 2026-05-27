import java.util.ArrayList;

public class GrapheListe implements Graphe{
    ArrayList<String> noeuds;
    ArrayList<Arcs> adjacences;

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
        // Indices des noeuds
        int indiceSrc = this.noeuds.indexOf(noeudSrc);
        int indiceDest = this.noeuds.indexOf(noeudDest);

        // Verifications des parametres
        if ((indiceSrc > 0) && (indiceDest > 0) && (poids>0)){
            // Creation d'un nouvel arc
            Arc a = new Arc(noeudDest, poids);

            // Ajout aux adjacences
            this.adjacences.get(indiceSrc).ajouterArc(a);
        }
    }
}
