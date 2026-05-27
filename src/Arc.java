public class Arc {
    /** Attributrs */
    String nCible;
    int poids;

    /**
     * Constructeur
     * @param n Noeud cible de l'arc (chaine de caractere)
     * @param p Entier correspondant au poids de l'arc
     */
    public Arc(String n, int p){
        this.nCible = n;
        this.poids = p;
    }
}
