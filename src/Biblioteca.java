/**
 * Gestiona els llibres i usuaris d'una biblioteca.
 *
 * Aquesta classe permet afegir, eliminar, cercar i llistar llibres i usuaris.
 * També inclou funcions per consultar llibres per categoria i obtenir
 * estadístiques bàsiques.
 *
 * @author Aaron
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.List;
import java.text.Normalizer;

public class Biblioteca {

    // ---------------------------------
    // ---------- ATRIBUTOS ------------
    // ---------------------------------

    private List<Llibre> llibres;
    private List<Usuari> usuaris;

    // ---------------------------------
    // --------- CONSTRUCTOR -----------
    // ---------------------------------
    /**
     * Crea una biblioteca buida amb llistes de llibres i usuaris.
     */
    public Biblioteca() {
        this.llibres = new ArrayList<>();
        usuaris = new ArrayList<>();
    }

    // ---------------------------------
    // ---------- FUNCIONES ------------
    // ---------------------------------

    /**
     * Afegeix un llibre a la biblioteca.
     *
     * @param llibre llibre que es vol afegir
     */
    public void afegirLlibre(Llibre llibre) {
        llibres.add(llibre);
        System.out.println("Llibre afegit correctament.");
    }

    /**
     * Elimina un llibre de la biblioteca segons el seu identificador.
     *
     * @param id identificador del llibre que es vol eliminar
     */
    public void eliminarLlibre(int id) {
        Llibre llibreEliminar = null;

        for (Llibre llibre : llibres) {
            if (llibre.getId() == id) {
                llibreEliminar = llibre;
            }
        }

        if (llibreEliminar != null) {
            llibres.remove(llibreEliminar);
            System.out.println("Llibre eliminat correctament.");
        } else {
            System.out.println("No s'ha trobat el llibre.");
        }
    }

    /**
     * Normalitza un text eliminant accents i signes diacrítics.
     *
     * Aquest mètode facilita les cerques sense tenir en compte accents.
     *
     * @param text text que es vol normalitzar
     * @return text normalitzat sense accents
     */
    private String normalitzarText(String text) {

        return Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

    /**
     * Cerca un llibre pel seu títol.
     *
     * La cerca no diferencia majúscules i minúscules i ignora accents.
     *
     * @param titol títol del llibre que es vol cercar
     * @return llibre trobat o null si no existeix
     */
    public Llibre buscarLlibre(String titol) {
        String titolNormalitzat = normalitzarText(titol);
        String llibreNormalitzat;
        for (Llibre llibre : llibres) {
            llibreNormalitzat = normalitzarText(llibre.getTitol());

            if (llibreNormalitzat.equalsIgnoreCase(titolNormalitzat)) {
                return llibre;
            }

        }
        return null;
    }

    /**
     * Mostra per consola tots els llibres registrats a la biblioteca.
     *
     * Si no hi ha llibres, mostra un missatge informatiu.
     */
    public void llistarLlibres() {
        if (llibres.isEmpty()) {
            System.out.println("No hi ha llibres.");
        } else {
            for (Llibre llibre : llibres) {
                System.out.println(llibre);
            }
        }
    }

    /**
     * Afegeix un usuari a la biblioteca.
     *
     * @param usuari usuari que es vol afegir
     */
    public void afegirUsuari(Usuari usuari) {
        usuaris.add(usuari);
    }

    /**
     * Mostra per consola tots els usuaris registrats.
     *
     * Si no hi ha usuaris, mostra un missatge informatiu.
     */
    public void llistarUsuaris() {
        if (usuaris.isEmpty()) {
            System.out.println("No hi ha usuaris.");
        } else {
            for (Usuari usuari : usuaris) {
                System.out.println(usuari);
            }
        }
    }

    /**
     * Cerca un usuari pel seu nom.
     *
     * La cerca no diferencia majúscules i minúscules i ignora accents.
     *
     * @param nom nom de l'usuari que es vol cercar
     * @return usuari trobat o null si no existeix
     */
    public Usuari buscarUsuari(String nom) {
        String nomNormalitzat = normalitzarText(nom);
        String usuariNormalitzat;

        for (Usuari usuari : usuaris) {
            usuariNormalitzat = normalitzarText(usuari.getNom());

            if (usuariNormalitzat.equalsIgnoreCase(nomNormalitzat)) {
                return usuari;
            }
        }
        return null;
    }

    /**
     * Elimina un usuari de la biblioteca segons el seu identificador.
     *
     * @param id identificador de l'usuari que es vol eliminar
     */
    public void eliminarUsuari(int id) {
        Usuari usuariEliminar = null;

        for (Usuari usuari : usuaris) {
            if (usuari.getId() == id) {
                usuariEliminar = usuari;
            }
        }

        if (usuariEliminar != null) {
            usuaris.remove(usuariEliminar);
            System.out.println("Usuari eliminat correctament.");
        } else {
            System.out.println("No s'ha trobat l'usuari.");
        }
    }


    /**
     * Mostra tots els llibres que pertanyen a una categoria concreta.
     *
     * @param categoria categoria dels llibres que es volen mostrar
     */
    public void llistarPerCategoria(String categoria) {
        boolean trobat = false;
        String categoriaNormalitzat = normalitzarText(categoria);
        String llibreNormalitzat;

        for (Llibre llibre : llibres) {
            llibreNormalitzat = normalitzarText(llibre.getCategoria());

            if (llibreNormalitzat.equalsIgnoreCase(categoriaNormalitzat)) {
                System.out.println(llibre);
                trobat = true;
            }
        }

        if (!trobat) {
            System.out.println("No hi ha llibres d'aquesta categoria.");
        }
    }

    /**
     * Cerca el llibre que ha estat prestat més vegades.
     *
     * @return llibre més prestat o null si no hi ha llibres
     */
    public Llibre llibreMesPrestat() {
        if (llibres.isEmpty()) {
            return null;
        }

        Llibre mesPrestat = llibres.get(0);

        for (Llibre llibre : llibres) {
            if (llibre.getVegadesPrestat() > mesPrestat.getVegadesPrestat()) {
                mesPrestat = llibre;
            }
        }

        return mesPrestat;
    }

    /**
     * Calcula el nombre total de préstecs d'una categoria concreta.
     *
     * @param categoria categoria de llibres que es vol consultar
     * @return total de préstecs de la categoria indicada
     */
    public int totalPrestecsCategoria(String categoria) {
        int total = 0;
        String categoriaNormalitzat = normalitzarText(categoria);
        String llibreNormalitzat;

        for (Llibre llibre : llibres) {
            llibreNormalitzat = normalitzarText(llibre.getCategoria());
            if (llibreNormalitzat.equalsIgnoreCase(categoriaNormalitzat)) {
                total += llibre.getVegadesPrestat();
            }
        }

        return total;
    }

    // ---------------------------------
    // ------- GETTERS + SETTERS -------
    // ---------------------------------

    public List<Llibre> getLlibres() {
        return llibres;
    }

    public List<Usuari> getUsuaris() {
        return usuaris;
    }

}
