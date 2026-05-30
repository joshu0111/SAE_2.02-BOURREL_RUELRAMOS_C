import java.io.IOException;
import java.util.List;

public class MainTransport {
    public static void main(String[] args) throws IOException {
        if (args.length < 2){
            System.out.println("Utilisation du programme : \n     java -jar ApplicationCalculTajetTransport.jar [id_arret_depart] [id_arret_destination]");
            return;
        }
        String depart = args[0].split("\\[")[1].split("]")[0];
        String destination = args[1].split("\\[")[1].split("]")[0];

        // Creation du graphe
        Graphe graphe = LireReseau.lire(
                "/Users/joshua/Desktop/COURS/S2/SAE/SAE_2.02-BOURREL_RUELRAMOS_C/infos_reseau/stan.nodes.txt",
                "/Users/joshua/Desktop/COURS/S2/SAE/SAE_2.02-BOURREL_RUELRAMOS_C/infos_reseau/stan.edges.txt");


        // Calcul BellmanFord
        BellmanFord bellmanFord = new BellmanFord();

        long startTime = System.nanoTime();
        Valeurs valeursBellmanFord = bellmanFord.resoudre(graphe, depart);
        long endTime = System.nanoTime();

        List<String> cheminBellmanFord = valeursBellmanFord.calculerChemin(destination);

        System.out.println(cheminBellmanFord + "\nCalculé en " + (endTime-startTime) + " ns avec l'algorithme de Bellaman Ford.");


        // Calcul Djikstra
        Djikstra djikstra = new Djikstra();

        startTime = System.nanoTime();
        Valeurs valeursDjikstra = djikstra.resoudre(graphe, depart);
        endTime = System.nanoTime();

        List<String> cheminDjikstra = valeursDjikstra.calculerChemin(destination);

        System.out.println(cheminDjikstra + "\nCalculé en " + (endTime-startTime) + " ns avec l'algorithme de Djikstra.");
    }
}
