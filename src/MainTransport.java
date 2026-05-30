import java.io.IOException;
import java.util.List;

public class MainTransport {
    public static void main(String[] args) throws IOException {
        String depart = args[0];
        String destination = args[1];

        // Creation du graphe
        Graphe graphe = LireReseau.lire(
                "infos_reseau/stan.nodes.txt",
                "infos_reseau/stan.edges.txt");

        // Calcul BellmanFord
        BellmanFord bellmanFord = new BellmanFord();
        Valeurs valeursBellmanFord = bellmanFord.resoudre(graphe, depart);
        List<String> cheminBellmanFord = valeursBellmanFord.calculerChemin(destination);
        System.out.println(cheminBellmanFord);

//        // Calcul Djikstra
//        Djikstra djikstra = new Djikstra();
//        Valeurs valeursDjikstra = djikstra.resoudre(graphe, depart);
//        List<String> cheminDjikstra = valeursDjikstra.calculerChemin(destination);
//        System.out.println(cheminDjikstra);


    }
}
