/**
 * Representa un usuari de la biblioteca.
 *
 * Aquesta classe guarda el nom de l'usuari, els llibres que té prestats
 * actualment i el seu historial de préstecs.
 *
 * @author Ousama
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.List;

public class Usuari {

    // ---------------------------------
    // ---------- ATRIBUTOS ------------
    // ---------------------------------

    private static int contadorId = 1;
    private int id;
    private String nom;
    private List<Llibre> llibresPrestats;
    private List<Prestec> historialPrestecs;


    // ---------------------------------
    // --------- CONSTRUCTOR -----------
    // ---------------------------------

    /**
     * Crea un nou usuari amb el nom indicat.
     *
     * @param nom nom de l'usuari
     */
    public Usuari(String nom) {
        this.nom = nom;
        this.llibresPrestats = new ArrayList<>();
        this.historialPrestecs = new ArrayList<>();
        this.id = contadorId++;
    }

    // ---------------------------------
    // ---------- FUNCIONES ------------
    // ---------------------------------

    /**
     * Afegeix un llibre a la llista de llibres prestats de l'usuari.
     *
     * @param llibre llibre que s'afegeix a l'usuari
     */
    public void afegirLlibre(Llibre llibre) {
        llibresPrestats.add(llibre);
    }

    /**
     * Afegeix un préstec a l'historial de l'usuari.
     *
     * @param prestec préstec que es vol guardar a l'historial
     */
    public void afegirPrestecHistorial(Prestec prestec) {
        historialPrestecs.add(prestec);
    }

    /**
     * Elimina un llibre de la llista de llibres prestats de l'usuari.
     *
     * @param llibre llibre que es vol retornar
     */
    public void retornarLlibre(Llibre llibre) {
        llibresPrestats.remove(llibre);
    }

    /**
     * Mostra per consola l'historial de préstecs de l'usuari.
     *
     * Si l'usuari no té préstecs, mostra un missatge informatiu.
     */
    public void mostrarHistorial() {
        if (historialPrestecs.isEmpty()) {
            System.out.println("Aquest usuari no té préstecs.");
        } else {
            for (Prestec prestec : historialPrestecs) {
                System.out.println(prestec);
            }
        }
    }

    /**
     * Retorna el nombre total de préstecs de l'usuari.
     *
     * @return quantitat de préstecs registrats a l'historial
     */
    public int quantitatPrestecs() {
        return historialPrestecs.size();
    }

    /**
     * Retorna la informació de l'usuari en format text.
     *
     * @return cadena de text amb les dades de l'usuari
     */
    @Override
    public String toString() {

        return "\n----- USUARI -----" +
                "\nID: " + id +
                "\nNom: " + nom +
                "\nLlibres prestats: " +
                llibresPrestats.size();
    }

    // ---------------------------------
    // ------- GETTERS + SETTERS -------
    // ---------------------------------

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public List<Llibre> getLlibresPrestats() {
        return llibresPrestats;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Prestec> getHistorialPrestecs() {
        return historialPrestecs;
    }

}
