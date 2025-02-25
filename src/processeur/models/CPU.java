package processeur.models;


import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Application "CPU".
 *
 * Cette classe représente un CPU d'un ordinateur.
 *
 * @author <a href="mailto:friedlip@edufr.ch">Paul Friedli</a>
 * @since 18 octobre 2023
 * @version 0.1
 */
public class CPU {

    /**
     * Cette constante (-1.0) représente une performance MIPS (Millions Instructions
     * Per Second) inconnue.
     */
    public final static double UNKNOWN_MIPS = -1.0;

    /**
     * Attribut qui représente le nom du CPU.
     */
    private final String nom;

    /**
     * Attribut qui représente l'année de sortie du CPU.
     */
    private final int annee;

    /**
     * Attribut qui représente le nombre de transistors utilisés dans le CPU.
     */
    private final long transistors;

    /**
     * Attribut qui représente la performance en MIPS (Millions Instructions Per
     * Second) du CPU.
     */
    private final double mips;

    /**
     * Constructeur de la classe CPU à utiliser lorsqu'on connaît la valeur de
     * chaque attribut.
     *
     * @param nom         le nom du CPU
     * @param annee       l'année de sortie du CPU
     * @param transistors le nombre de transistors utilisés dans le CPU
     * @param mips        la performance en MIPS (Millions Instructions Per Second)
     *                    du CPU
     */
    public CPU(String nom, int annee, long transistors, double mips) {
        this.nom = nom;
        this.annee = annee;
        this.transistors = transistors;
        this.mips = mips;
    }

    /**
     * Constructeur de la classe CPU à utiliser lorsqu'on ne connaît pas la
     * performance du CPU. Dans ce cas, l'attribut
     * "mips" sera initialisé avec la valeur UNKNOWN_MIPS pour indiquer que cette
     * information n'est pas connue.
     *
     * @param nom         le nom du CPU
     * @param annee       l'année de sortie du CPU
     * @param transistors le nombre de transistors utilisés dans le CPU
     */
    public CPU(String nom, int annee, long transistors) {
        this.nom = nom;
        this.annee = annee;
        this.transistors = transistors;
        this.mips = UNKNOWN_MIPS;
    }

    /**
     * Getter de l'attribut nom.
     *
     * @return la valeur de l'attribut nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter de l'attribut annee.
     *
     * @return la valeur de l'attribut annee
     */

    public int getAnnee() {
        return annee;
    }

    /**
     * Getter de l'attribut transistors.
     *
     * @return la valeur de l'attribut transistors
     */
    public long getTransistors() {
        return transistors;
    }

    /**
     * Getter de l'attribut mips.
     *
     * @return la valeur de l'attribut mips
     */
    public double getMips() {
        return mips;
    }

    /*
     * méthode toString() pour le formattage. DecimalFormat est mis dedans pour
     * travailler avec l'affichage dans la méthode désiré.
     */
    public String toString() {
        String cpuNom;

        // #,### défini le formatage sous la forme 1,000,000 = 1'000'000
        DecimalFormat dfTransistors = new DecimalFormat("#,###");

        /*
         * #,##0.00 (la même chose que #,###.00) défini le formatage sous la forme
         * 1,000,000 = 1'000'000.00
         */
        DecimalFormat dfMips = new DecimalFormat("#,##0.00");

        /*
         * crée un objet pour y mettre la configuration de formatage personnalisée (pour
         * des symbols)
         */
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();

        /*
         * crée un objet pour y mettre la configuration de formatage personnalisée (pour
         * des points)
         */
        DecimalFormatSymbols point = new DecimalFormatSymbols();

        // définition de formatage pour la varibale "symbols" créée
        symbols.setGroupingSeparator('\'');

        /*
         * "Decimal" configure le séparateur pour les nombres après la virgule (var
         * point).
         */
        point.setDecimalSeparator('.');

        // "Grouping" configure le séparateur pour les miliers
        point.setGroupingSeparator('\'');
        dfTransistors.setDecimalFormatSymbols(symbols);
        dfMips.setDecimalFormatSymbols(point);

        /*
         * utiliser dfTransistors.format(transistors) au lieu de `transistors` pour
         * appliquer DecimalFormat. La même chose pour les `mips`
         */
        if (getMips() == UNKNOWN_MIPS) {
            cpuNom = "En " + annee + " le CPU " + nom + " avec " + dfTransistors.format(transistors)
                    + " transistors et une puissance de calcul inconnue ";
        } else {
            cpuNom = "En " + annee + " le CPU " + nom + " avec " + dfTransistors.format(transistors)
                    + " transistors et une puissance de calcul de " + dfMips.format(mips) + " mips.";
        }
        return cpuNom;
    }

}
