import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LireReseau {
    /**
     * Lit un fichier de connexions textuel structuré (séparateur ";") pour modéliser et générer un objet Graphe.
     * Chaque ligne lue représente un arc au format : "StationSource;StationDestination;Poids".
     * @param fichier_stations   Le chemin d'accès vers le fichier contenant la liste des stations.
     * @param fichier_connexions Le chemin d'accès vers le fichier contenant les arcs/liens entre les stations.
     * @return Un objet Graphe initialisé avec l'ensemble des arcs.
     * @throws IOException Si une erreur d'accès ou de lecture survient sur l'un des fichiers.
     */
    public static Graphe lire(String fichier_stations, String fichier_connexions) throws IOException {

        // Init des lecteurs
        BufferedReader noeuds = new BufferedReader(new FileReader(fichier_stations));
        BufferedReader liens = new BufferedReader(new FileReader(fichier_connexions));

        // Init des variables
        String ligneLien;
        String [] tabLigneLien;

        // Init du graphe
        GrapheListe g = new GrapheListe();

        // Boucles qui lit chaque ligne et qui creer un nouvel arc dans le graphe
        while ((ligneLien = liens.readLine()) != null){
            tabLigneLien = ligneLien.split(";");
            g.ajouterArc(
                    tabLigneLien[0],
                    tabLigneLien[1],
                    Double.parseDouble(tabLigneLien[2]));
        }
        return g;
    }
}
