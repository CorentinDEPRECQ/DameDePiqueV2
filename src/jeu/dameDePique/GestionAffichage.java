package jeu.dameDePique;



public class GestionAffichage {

    /**
     * Affichage du menu Principale lors du lancement de l'application
     */
    public static void afficherMenuPrincipale() {

        System.out.println("\n==============DAME DE PIQUE==============\n\n");

        System.out.println("""
                     Bienvenue dans le jeu : DAME DE PIQUE\s

                La Dame de pique est un jeu de cartes se jouant
                 avec un jeu de 52 ou 54 cartes. Il se joue  à
                   quatre joueurs avec treize cartes chacun,
                      et à six avec neuf cartes chacun.

                """);

        System.out.println("Taper 1 pour jouer un partie et taper 2 pour\n"
                + "       accéder au menu debug");
    }

    /**
     * Affichage des cartes que le joueur a en main
     * @param tableJoueur tableau dans lequel il y a toutes les cartes du joueur
     */

    public static void afficherMainJoueur(Carte[] tableJoueur) {

        StringBuilder resultant;        // Afficher la main du joueur
        resultant = new StringBuilder();

        for (Carte carte : tableJoueur) {

            if (carte != null && carte.getNumCarte() != 0) {
                resultant.append(carte).append(" | ");
            }

        }

        if (resultant.isEmpty()) {
            resultant.append("La main est vide !");
        }

        System.out.println("Votre jeu est actuellement constitué de :\n" + resultant);
    }


    public static void afficherCentre(Carte[] centreTable) {

        if (centreTable.length != 4) {
            throw new IllegalArgumentException("Le centre de la table doit contenir 4 cartes");
        }

        System.out.println("\nVoici les cartes sur la table : ");
        for(int i = 0 ; i < centreTable.length ; i++) {
            System.out.print( centreTable[i] + ", " );
        }
        System.out.println("");

    }




    /**
     * Affichage du classement des joueurs selon leurs points
     * @param j1 Joueur numéro 1
     * @param j2 Joueur numéro 2
     * @param j3 Joueur numéro 3
     * @param j4 Joueur numéro 4
     */

    public static void afficherClassement(Joueur j1, Joueur j2, Joueur j3, Joueur j4) {

        /* Initialisation du tableau avec les scores des quatre joueur */
        int[] triScore = new int[4];
        triScore[0] = j1.getScore();
        triScore[1] = j2.getScore();
        triScore[2] = j3.getScore();
        triScore[3] = j4.getScore();

        /* Algorithme de tri du tableau de score */
        for (int i = 0; i < triScore.length - 1; i++)
        {
            int index = i;
            int min;

            for (int j = i + 1; j < triScore.length; j++)
            {
                if (triScore[j] < triScore[index]){
                    index = j;
                }
            }

            min = triScore[index];
            triScore[index] = triScore[i];
            triScore[i] = min;
        }

        /* Affichage des résultats du classement */
        for (int a = 0; a < triScore.length; a ++) {
            if (triScore[a] == j1.getScore()) {
                System.out.println(j1.getNom() + " est actuellement le numéro " + (a + 1)
                        + " au classement de la partie avec " + j1.getScore());
            } else if (triScore[a] == j2.getScore()) {
                System.out.println(j2.getNom() + " est actuellement le numéro " + (a + 1)
                        + " au classement de la partie avec " + j2.getScore());
            } else if (triScore[a] == j3.getScore()) {
                System.out.println(j3.getNom() + " est actuellement le numéro " + (a + 1)
                        + " au classement de la partie avec " + j3.getScore());
            } else if (triScore[a] == j4.getScore()) {
                System.out.println(j4.getNom() + " est actuellement le numéro " + (a + 1)
                        + " au classement de la partie avec " + j4.getScore());
            }
        }
    }

    /**
     * Affichage du menu de la partie "debug"
     */

    public static void afficherMenuDebug() {

        System.out.println("Vous êtes dans le mode debug :");
        System.out.println("   Taper 1 pour jouer un partie et taper 2 pour\n"
                + "charger une distribution de carte pré-enregistrer");
    }

}

