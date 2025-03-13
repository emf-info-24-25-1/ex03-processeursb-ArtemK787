package processeur.services;

import java.util.ResourceBundle.Control;

import processeur.ctrl.Controller;
import processeur.models.CPU;

/**
 * Service de notre application MVC "Processeur" pouvant gérer des CPUs.
 *
 * Cette classe représente le service CPU de notre application MVC "Processeur".
 *
 * @author <a href="mailto:friedlip@edufr.ch">Paul Friedli</a>
 * @since 18 octobre 2023
 * @version 0.1
 */
public class ServiceCPU {

    /**
     * Constantes indiquant le nombre maximum de CPUs que peut contenir notre liste.
     */
    public final int NBRE_CPU = 20;

    /**
     * Attribut contenant le tableau des CPUs.
     */
    CPU[] cpus;
    /**
     * Attribut contenant la référence au contrôleur de l'application MVC
     * "Processeur".
     */
    Controller refCtrl;

    /**
     * Constructeur de la classe ServiceCPU. Les attributs de la classe ServiceCPU
     * sont initialisés.
     */
    public ServiceCPU() {
        refCtrl = null;
        cpus = new CPU[ NBRE_CPU ];
    }

    /**
     * Cette méthode permet de stocker un nouveau CPU dans notre liste. La liste
     * étant un tableau de taille fixe, au bout d'un moment celui-ci sera plein et
     * ne pourra donc plus accueillir de nouveau objets. Cette méthode indique
     * par sa valeur de retour si elle a réussi à faire le travail demandé.
     * 
     * @param cpu le nouveau CPU à stocker dans notre liste
     * @return vrai si une place libre a été trouvée dans notre liste de cpus
     */
    public boolean ajouterUnNouveau( CPU cpu ) {
        boolean cpuTrouve = false;
        for ( int i = 0; i < cpus.length; i++ ) {
            if ( cpus[ i ] == null ) {
                cpus[ i ] = cpu;
                cpuTrouve = true;
                break;
            }
        }
        return cpuTrouve;
    }

    /**
     * Cette méthode permet d'obtenir la liste actuelle de nos CPU.
     *
     * @return la liste des CPUs
     */
    public CPU[] obtenirLaListe() {
        int compte = 0;
        for ( int i = 0; i < cpus.length; i++ ) {
            if ( cpus[ i ] != null ) {
                compte++;
            }
        }
        /*
         * créer un nouveau liste des CPUs non NULL. Les CPUs vérifiés se trouvent dans
         * le tableau 'noveauListeCPU' qui est de la taille 'compte' contenant des CPUs
         * validés par la méthode 'obtenirLaliste()'
         */
        CPU[] nouveauListeCPU = new CPU[ compte ];

        /*
         * remplir le tableau des CPU
         */
        int indexCPU = 0;
        for ( int i = 0; i < nouveauListeCPU.length; i++ ) {
            if ( cpus[ i ] != null ) {
                nouveauListeCPU[ indexCPU ] = cpus[ i ];
                indexCPU++;
            }
        }
        return nouveauListeCPU;
    }

    /**
     * Cette méthode permet de connaître le nombre de CPUs contenus dans notre
     * liste.
     *
     * @return le nombre de CPUs contenus dans notre liste
     */
    public int nombreDeCPUDansLaListe() {
        int compteur = 0;
        for (int i = 0; i < cpus.length; i++) {
            if ( cpus[ i ] != null ) {
                compteur++;
            }
        }
        return compteur;
    }

    /**
     * Cette méthode permet de connaître la taille de la liste de CPU (et donc le
     * nombre maximum d'éléments qu'on peut y
     * mettre).
     *
     * @return la taille de la liste de CPU
     */
    public int tailleDeLaListe() {
        return cpus.length;
    }

    /**
     * Cette méthode permet d'obtenir un CPU de notre liste en fonction de son
     * indice.
     * 
     * @param indice l'indice du CPU à obtenir se trouvant dans notre tableau
     * @return CPU le CPU demandé ou null si l'indice ne se trouve pas dans les
     *         limites du tableau
     */
    public CPU obtenirUnElement( int indice ) {
        CPU indiceCPU = null;

        if ( indice >= 0 && indice < cpus.length ) {
            indiceCPU = cpus[ indice ];
        }
        return indiceCPU;

    }

    /**
     * Getter de la référence au contrôleur de l'application MVC "Processeur".
     *
     * @return la référence au contrôleur de l'application MVC "Processeur"
     */
    public Controller getRefCtrl() {
        return refCtrl;
    }

    /**
     * Setter de la référence au contrôleur de l'application MVC "Processeur".
     *
     * @param refCtrl référence au contrôleur de l'application MVC "Processeur"
     */
    public void setRefCtrl( Controller refCtrl ) {
        this.refCtrl = refCtrl;
    }

}