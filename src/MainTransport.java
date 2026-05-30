import java.io.IOException;
import java.util.List;

public class MainTransport {
    public static void main(String[] args) throws IOException {
        try {
            if (args.length < 2){
                System.out.println("Utilisation du programme : \n     java -jar ApplicationCalculTajetTransport.jar [id_arret_depart] [id_arret_destination]");
                return;
            }
            String depart = args[0].split("\\[")[1].split("]")[0];
            String destination = args[1].split("\\[")[1].split("]")[0];

            // Creation du graphe
            Graphe graphe = LireReseau.lire(
                    "infos_reseau/stan.nodes.txt",
                    "infos_reseau/stan.edges.txt");


            // Calcul BellmanFord
            BellmanFord bellmanFord = new BellmanFord();

            long startTime = System.nanoTime();
            Valeurs valeursBellmanFord = bellmanFord.resoudre(graphe, depart);
            long endTime = System.nanoTime();

            List<String> cheminBellmanFord = valeursBellmanFord.calculerChemin(destination);

//        System.out.println(cheminBellmanFord + "\nCalculé en " + (endTime-startTime) + " ns avec l'algorithme de Bellaman Ford.");


            // Calcul Djikstra
            Djikstra djikstra = new Djikstra();

            startTime = System.nanoTime();
            Valeurs valeursDjikstra = djikstra.resoudre(graphe, depart);
            endTime = System.nanoTime();

            List<String> cheminDjikstra = valeursDjikstra.calculerChemin(destination);

//        System.out.println(cheminDjikstra + "\nCalculé en " + (endTime-startTime) + " ns avec l'algorithme de Djikstra.");

            // On construit la chaîne propre sans espaces parasites
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cheminDjikstra.size(); i++) {
                sb.append(cheminDjikstra.get(i).trim());
                if (i < cheminDjikstra.size() - 1) {
                    sb.append(";");
                }
            }

            String formatPython = sb.toString().trim();

            //  On écrit la chaîne suivie d'un saut de ligne
            // pour vider le buffer du système d'exploitation vers Python
            System.out.println(formatPython);

            // On force l'envoi immédiat
            System.out.flush();

            // On ferme explicitement la sortie standard.
            // C'est ça qui va déclencher le "if not new: break" en Python !
            System.out.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
