public class Principale {
    public static void main(String[] args){
        // Creation des Arcs vides pour chaque noeuf
        Arcs A = new Arcs();
        Arcs B = new Arcs();
        Arcs C = new Arcs();
        Arcs D = new Arcs();
        Arcs E = new Arcs();

        // Creation des arc avec leur noeuf cibles et leur poids
        Arc AB = new Arc("B", 12);
        Arc AD = new Arc("D", 87);
        Arc BE = new Arc("E", 11);
        Arc CA = new Arc("A", 19);
        Arc DB = new Arc("B", 23);
        Arc DC = new Arc("C", 10);
        Arc ED = new Arc("D", 43);

        // Ajout des listes adjacentes
        A.ajouterArc(AB);
        A.ajouterArc(AD);
        B.ajouterArc(BE);
        C.ajouterArc(CA);
        D.ajouterArc(DB);
        D.ajouterArc(DC);
        E.ajouterArc(ED);

        // Creation du graphe et remplissage
        GrapheListe graphe = new GrapheListe();


    }
}
