package processeur.app;

import processeur.ctrl.Controller;
import processeur.services.ServiceCPU;
import processeur.views.View;

/**
 * Application "Processeur". Application qui fait un usage progressivement plus complexe de classes et objets.
 *
 *
 * @author <a href="mailto:friedlip@edufr.ch">Paul Friedli</a>
 * @since 18 octobre 2023
 * @version 0.1
 */
public class Processeur {

    /**
     * La méthode main() de l'application, là où tout commence mais... tout se finit-il bien là ?
     *
     * @param args les arguments du programme passés sur la ligne de commande
     */
    public static void main(String[] args ) {
         Controller ctrl = new Controller();
         ServiceCPU serviceCPU = new ServiceCPU();
         View view = new View();

         ctrl.setRefServiceCPU( serviceCPU );
         ctrl.setRefView( view );
         serviceCPU.setRefCtrl( ctrl );
         view.setRefCtrl( ctrl );

         ctrl.start();
    }

}
