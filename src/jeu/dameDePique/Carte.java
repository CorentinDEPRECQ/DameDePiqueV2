/*
 * Carte.java                           21/04/2021
 * IUT Rodez, aucun droit d'auteur
 */
package jeu.dameDePique;;

/**
 *
 * @author Corentin DEPRECQ
 */

public class Carte {

    /* Valeur possible pour les cartes valide dans un paquet de cartes */
    private static final String[] VALEUR = {
            "Indéfini", "", "2", "3", "4", "5","6", "7", "8", "9",
            "10", "Valet", "Dame", "Roi", "As"
    };

    /* Couleur possible dans un paquet de cartes normal*/
    private static final String[] COULEUR = {
            "Indéfini", "Trèfle", "Carreau", "Coeur", "Pique"
    };

    /**
     * numéro de la carte en question
     */
    private final int numCarte;

    /**
     * Définit une carte Valide
     * @param numCarte 2, 3, 4, 5, 6, 7, 8, 9, 10, Valet, Dame, Roi, As
     */
    public Carte(int numCarte) {

        if (!isNumCarteValide(numCarte)) {
            throw new IllegalArgumentException("Erreur : La carte n'est pas valide");
        }

        this.numCarte = numCarte;
    }

    /**
     * Contrôle de la bonne saisie du numéro de la carte
     * @param numCarte 102 à 114, 202 à 214, 302 à 314 et 402 à 414
     * @return true ou false
     */
    private boolean isNumCarteValide(int numCarte) {

        return numCarte == 0
                || (numCarte >= 102 && numCarte <= 114)
                || (numCarte >= 202 && numCarte <= 214)
                || (numCarte >= 302 && numCarte <= 314)
                || (numCarte >= 402 && numCarte <= 414);
    }

    /**
     * Renvoie la valeur de la carte
     * @return numCarte
     */
    public int getNumCarte() {
        return numCarte;
    }

    /**
     * Renvoie un string de la valeur de la carte
     * @return "2", "3", "4", "5","6", "7", "8", "9", "10", "Valet", "Dame", "Roi", "As"
     */
    public String valeur() {

        return VALEUR[numCarte % 100];
    }

    /**
     * Renvoie un string de couleur de la carte
     * @return "Trèfle", "Carreau", "Coeur", "Pique"
     */
    public String couleur() {

        return COULEUR[numCarte / 100];
    }

    /**
     *
     * @return string de la forme "valeur" de "couleur"
     */
    public String toString() {
        return VALEUR[numCarte % 100] + " de " + COULEUR[numCarte / 100];
    }
}
