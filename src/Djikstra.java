import java.util.ArrayList;

public class Djikstra {
    public Valeurs resoudre(Graphe g, String depart){
        Valeurs res = new  Valeurs();
        // noeuds represente l'ensemble des noeuds du graphe
        ArrayList<String> noeuds = g.getListeNoeuds();
        // Q représente la liste des noeuds a traiter
        ArrayList<String> q = new ArrayList<>();

        for (int i = 0; i < noeuds.size(); i++){
            res.setValeur(noeuds.get(i), Double.MAX_VALUE); //les autres valeurs mises a l'infini
            res.setParent(noeuds.get(i), null); // Les parents de ses valeurs sont indefinies donc null
            q.add(noeuds.get(i)); // ajout du sommet v à la liste Q
        }
        res.setValeur(depart, 0.0);
        while(!q.isEmpty()){
            String u = null;
            double minValeur = Double.MAX_VALUE;
            for (int i = 0; i < noeuds.size(); i++) {
                double val = res.getValeur(noeuds.get(i));
                // Cherche de la plus petite valeur
                if (val < minValeur) {
                    minValeur = val;
                    u = noeuds.get(i);
                }
            }
            if (u == null || minValeur == Double.POSITIVE_INFINITY) {
                break;
            }
            q.remove(u);
            for (Arc arc : g.getNoeudAdjacence(u).getListeArc()) {
                String v = arc.getDest();
            }

        }
    }
}
