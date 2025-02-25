package processeur.views;

import processeur.models.CPU;
import processeur.ctrl.Controller;

/**
 * Ihm principale MVC de l'application "Processeur".
 *
 * @author <a href="mailto:friedlip@edufr.ch">Paul Friedli</a>
 * @since 17 jan. 2023
 * @version 0.1
 */
public class View {

    /**
     * Référence au contrôleur MVC de notre application.
     */
    private Controller refCtrl;

    /**
     * Constructeur de notre ihm principale MVC de l'application "Processeur".
     */
    public View() {
        refCtrl = null;
    }

    /**
     * Cette méthode permet de débuter un nouveau rapport qui sera affiché à
     * l'utilisateur. Pas de code dans cette
     * version.
     */
    public void rapport_Debut() {
        // Rien à faire dans cette version-ci
    }

    /**
     * Cette méthode permet d'ajouter une ligne au rapport des CPU qui sera affiché
     * à l'utilisateur. Faire un simple
     * sout() de l'objet reçu.
     *
     * @param cpu le CPU à afficher à l'utilisateur
     */
    public void rapport_AfficherCPU(CPU cpu) {
        System.out.println(cpu);
    }

    /**
     * Cette méthode permet de terminer le nouveau rapport qui sera affiché à
     * l'utilisateur. Pas de code dans cette
     * version.
     */
    public void rapport_Fin() {
        // Rien à faire dans cette version-ci
    }

    /**
     * Setter de la référence au contrôleur de l'application MVC "Processeur".
     *
     * @param refCtrl référence au contrôleur de l'application MVC "Processeur"
     */
    public void setRefCtrl(Controller refCtrl) {
        this.refCtrl = refCtrl;
    }

    /**
     * Getter de la référence au contrôleur de l'application MVC "Processeur".
     *
     * @return la référence au contrôleur de l'application MVC "Processeur"
     */
    public Controller getRefCtrl() {
        return refCtrl;
    }

}
