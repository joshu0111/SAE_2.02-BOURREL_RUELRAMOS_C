public class Main {

    public static void main(String[] args)
    {
	if (args.length != 2) {
	    System.err.println("Erreur: usage java Main <STATION_DEPART> <STATION_ARRIVEE>");
	    System.exit(1);
	}
	else {
	    // On retourne un chemin contenant les deux arrêts sélectionnés
	    // (ce chemin est un exemple, il n'est pas valide car il ne vérifie pas que
	    //  le chemin en question utilise les arcs du graphe!)
	    String from  = args[0];
	    String to    = args[1];
	    String regex = "\\[|\\]";
	    System.out.println(from.split(regex)[1]+";"+to.split(regex)[1]);
	}
    }
}
