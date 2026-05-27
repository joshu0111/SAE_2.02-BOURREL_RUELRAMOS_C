import java.util.ArrayList;

public class GrapheListe implements Graphe{
    ArrayList<String> noeuds;
    ArrayList<Arcs> adjacence;

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
        return this.adjacence.get(indiceNoeud);
    }
}
