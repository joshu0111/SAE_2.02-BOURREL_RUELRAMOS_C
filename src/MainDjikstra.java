import java.util.List;

public class MainDjikstra {

    public static void main(String[] args) {
        // Création de l'algorithme
        Djikstra djikstra = new Djikstra();

        // Création du graphe
        GrapheListe graphe = new GrapheListe();
        graphe.ajouterArc("A", "B", 12);
        graphe.ajouterArc("A", "D", 87);
        graphe.ajouterArc("B", "E", 11);
        graphe.ajouterArc("C", "A", 19);
        graphe.ajouterArc("D", "B", 23);
        graphe.ajouterArc("D", "C", 10);
        graphe.ajouterArc("E", "D", 43);

        Valeurs res = djikstra.resoudre(graphe, "A");
        System.out.println(res.calculerChemin("C"));

        System.out.println("Distance totale : " + res.getValeur("C"));
    }
}