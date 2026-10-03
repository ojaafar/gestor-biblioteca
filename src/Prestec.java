/**
 * Representa el préstec d'un llibre a un usuari.
 *
 * Aquesta classe guarda l'usuari, el llibre prestat, la data del préstec
 * i la data prevista de retorn.
 *
 * @author Ousama
 * @version 1.0
 */
import java.time.LocalDate;

public class Prestec {

    // ---------------------------------
    // ---------- ATRIBUTOS ------------
    // ---------------------------------

    public static final int MAX_LLIBRES = 3;
    private Usuari usuari;
    private Llibre llibre;
    private LocalDate dataPrestec;
    private LocalDate dataRetorn;

    // ---------------------------------
    // --------- CONSTRUCTOR -----------
    // ---------------------------------

    /**
     * Crea un nou préstec entre un usuari i un llibre.
     *
     * La data de retorn es calcula automàticament sumant dues setmanes
     * a la data del préstec.
     *
     * @param usuari usuari que rep el llibre
     * @param llibre llibre prestat
     * @param dataPrestec data en què es realitza el préstec
     */
    public Prestec(Usuari usuari, Llibre llibre, LocalDate dataPrestec) {
        this.usuari = usuari;
        this.llibre = llibre;
        this.dataPrestec = dataPrestec;
        this.dataRetorn = dataPrestec.plusWeeks(2);
    }

    // ---------------------------------
    // ---------- FUNCIONES ------------
    // ---------------------------------

    /**
     * Comprova si el préstec està retardat.
     *
     * @return true si la data actual és posterior a la data de retorn;
     *         false en cas contrari
     */
    public boolean estaRetardat() {
        return LocalDate.now().isAfter(dataRetorn);
    }

    /**
     * Retorna la informació del préstec en format text.
     *
     * @return cadena de text amb les dades del préstec
     */
    @Override
    public String toString() {
        return "\n----- PRÉSTEC -----" +
                "\nUsuari: " + usuari.getNom() +
                "\nLlibre: " + llibre.getTitol() +
                "\nData préstec: " + dataPrestec +
                "\nData retorn: " + dataRetorn +
                "\nRetard: " +
                (estaRetardat() ? "Sí" : "No");
    }

    // ---------------------------------
    // ------- GETTERS + SETTERS -------
    // ---------------------------------

    public Usuari getUsuari() {
        return usuari;
    }

    public Llibre getLlibre() {
        return llibre;
    }

    public LocalDate getDataPrestec() {
        return dataPrestec;
    }

    public LocalDate getDataRetorn() {
        return dataRetorn;
    }

}
