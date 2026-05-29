import java.util.ArrayList;
import java.util.Iterator;

public class BellmanFord {

    /** Attributs */

    /**
     * TO DO
     *
     *
     * */
    public Valeurs resoudre(Graphe g, String depart){
        Valeurs valeurs = new Valeurs();

        // Init des autres sommets
        ArrayList<String> listeNoeuds = g.getListeNoeuds();

        // Creation des nouvelles valeurs
        for (int i=0; i<listeNoeuds.size(); i++){
            valeurs.setValeur(listeNoeuds.get(i), Double.MAX_VALUE);
            valeurs.setParent(listeNoeuds.get(i), null);
        }
        valeurs.setValeur(depart, 0.0);


        // Booleen qui mettra fin a la boucle
        boolean modifie = true;

        while (modifie){
            modifie = false;

            // Boucle sur chaque noeud
            for (int i=0; i<listeNoeuds.size(); i++){
                String noeud = listeNoeuds.get(i);
                double poidsNoeud = valeurs.getValeur(noeud);
                ArrayList<Arc> listeAdjacents = g.getNoeudAdjacence(noeud).getListeArc();

                // Boucle sur chaque sommet adjacent
                for (int j=0; j<listeAdjacents.size(); j++){
                    Arc arc = listeAdjacents.get(j);
                    double poidsArc = arc.getPoids();
                    String cible = arc.getnCible();

                    // Si le l'antecedent vaut +∞
                    if (poidsNoeud == Double.MAX_VALUE){
                        continue;
                    }

                    double nouvelleValeur = poidsNoeud + poidsArc;

                    if (nouvelleValeur < valeurs.getValeur(cible)) {

                       // Change le poids du noeuds
                       valeurs.setValeur(cible, nouvelleValeur);

                       // Changer le parent
                       valeurs.setParent(cible, noeud);

                       // Mettre modifier a true
                       modifie = true;
                    }

                }
            }
        }
        return valeurs;
    }


}
