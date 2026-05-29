public class Arc {
    /** Attributrs */
    String nCible;
    double poids;

    /**
     * Constructeur
     * @param n Noeud cible de l'arc (chaine de caractere)
     * @param p Entier correspondant au poids de l'arc
     */
    public Arc(String n, double p){
        this.nCible = n;
        this.poids = p;
    }

    public String getnCible() {
        return nCible;
    }

    public double getPoids() {
        return poids;
    }

    @Override
    public String toString() {
        return nCible + "(" + poids + ")";
    }
}
