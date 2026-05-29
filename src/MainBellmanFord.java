public class MainBellmanFord {
    public static void main(String[] args){
        BellmanFord bellmanFord = new BellmanFord();

        // Creation du graphe
        GrapheListe graphe = new GrapheListe();
        graphe.ajouterArc("A", "B", 12);
        graphe.ajouterArc("A", "D", 87);
        graphe.ajouterArc("B", "E", 11);
        graphe.ajouterArc("C", "A", 19);
        graphe.ajouterArc("D", "B", 23);
        graphe.ajouterArc("D", "C", 10);
        graphe.ajouterArc("E", "D", 43);

        Valeurs res = bellmanFord.resoudre(graphe, "A");
        System.out.println(res.calculerChemin("C"));

    }
}
