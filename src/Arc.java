public class Arc {
    /** Attributrs */
    private String nCible;
    private double poids;

    /**
     * Constructeur
     * @param n Noeud cible de l'arc (chaine de caractere)
     * @param p Entier correspondant au poids de l'arc
     */
    public Arc(String n, double p){
        this.nCible = n;
        this.poids = p;
    }

    /**
     * Retourne l'identifiant du nœud cible de cet arc.
     * * @return Le nom du nœud cible.
     */
    public String getnCible() {
        return nCible;
    }

    /**
     * Retourne le poids associé à cet arc.
     * * @return Le poids de l'arc (double).
     */
    public double getPoids() {
        return poids;
    }

    /**
     * Retourne une représentation textuelle de l'arc.
     * Le format retourné est : "nomCible(poids)".
     * * @return Une chaîne de caractères représentant l'arc.
     */
    @Override
    public String toString() {
        return nCible + "(" + poids + ")";
    }
}
