/**
 * Gestiona els préstecs de la biblioteca.
 *
 * Aquesta classe controla el préstec i retorn de llibres, els préstecs
 * actius, els préstecs retardats i algunes estadístiques generals.
 *
 * @author Mykola
 * @version 1.0
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorBiblioteca {

    // ---------------------------------
    // ---------- ATRIBUTOS ------------
    // ---------------------------------

    private List<Prestec> prestecs;

    // ---------------------------------
    // --------- CONSTRUCTOR -----------
    // ---------------------------------

    /**
     * Crea un gestor de biblioteca sense préstecs actius.
     */
    public GestorBiblioteca() {
        this.prestecs = new ArrayList<>();
    }

    // ---------------------------------
    // ---------- FUNCIONES ------------
    // ---------------------------------

    /**
     * Presta un llibre a un usuari si es compleixen les condicions.
     *
     * Comprova que l'usuari no superi el límit màxim de llibres i que el
     * llibre estigui disponible.
     *
     * @param usuari usuari que vol agafar el llibre
     * @param llibre llibre que es vol prestar
     */
    public void prestarLlibre(Usuari usuari, Llibre llibre) {
        if (usuari.getLlibresPrestats().size() >= Prestec.MAX_LLIBRES) {
            System.out.println("L'usuari ha arribat al límit de llibres.");
            return;
        } else {
            if (!llibre.disponible()) {
                System.out.println("Aquest llibre no està disponible.");
                return;
            } else {
                llibre.prestar();

                Prestec prestec = new Prestec(usuari, llibre, LocalDate.now());

                prestecs.add(prestec);

                usuari.afegirLlibre(llibre);

                usuari.afegirPrestecHistorial(prestec);
                System.out.println(usuari.getNom() + " ha agafat el llibre: " + llibre.getTitol());
            }
        }
    }

    /**
     * Retorna un llibre prestat per un usuari.
     *
     * Si l'usuari té el llibre prestat, s'elimina de la seva llista,
     * augmenta el stock del llibre i s'elimina el préstec actiu.
     *
     * @param usuari usuari que retorna el llibre
     * @param llibre llibre que es retorna
     */
    public void retornarLlibre(Usuari usuari, Llibre llibre) {
        if (!usuari.getLlibresPrestats().contains(llibre)) {
            System.out.println("Aquest usuari no té aquest llibre prestat.");
        } else {
            usuari.retornarLlibre(llibre);
            llibre.retornar();

            Prestec prestecRetornat = null;

            for (Prestec prestec : prestecs) {
                if (prestec.getUsuari() == usuari && prestec.getLlibre() == llibre) {
                    prestecRetornat = prestec;
                }
            }

            if (prestecRetornat != null) {
                prestecs.remove(prestecRetornat);
            }

            System.out.println("Llibre retornat correctament.");
        }
    }

    /**
     * Mostra per consola tots els préstecs actius.
     *
     * Si no hi ha préstecs, mostra un missatge informatiu.
     */
    public void mostrarPrestecs() {
        if (prestecs.isEmpty()) {
            System.out.println("No hi ha préstecs.");
        } else {
            for (Prestec prestec : prestecs) {
                System.out.println(prestec);
            }
        }
    }

    /**
     * Mostra l'historial de préstecs d'un usuari.
     *
     * @param usuari usuari del qual es vol consultar l'historial
     */
    public void mostrarPrestecsUsuari(Usuari usuari) {
        usuari.mostrarHistorial();
    }

    /**
     * Mostra per consola tots els préstecs que estan retardats.
     *
     * Si no hi ha préstecs retardats, mostra un missatge informatiu.
     */
    public void mostrarPrestecsRetardats() {
        boolean trobat = false;

        for (Prestec prestec : prestecs) {
            if (prestec.estaRetardat()) {
                System.out.println(prestec);
                trobat = true;
            }
        }

        if (!trobat) {
            System.out.println("No hi ha préstecs retardats.");
        }
    }

    /**
     * Cerca l'usuari amb més préstecs registrats.
     *
     * @param biblioteca biblioteca d'on s'obtenen els usuaris
     * @return usuari amb més préstecs o null si no hi ha cap usuari actiu
     */
    public Usuari usuariMesActiu(Biblioteca biblioteca) {
        Usuari millorUsuari = null;
        int maxPrestecs = 0;

        for (Usuari usuari : biblioteca.getUsuaris()) {
            if (usuari.quantitatPrestecs() > maxPrestecs) {
                maxPrestecs = usuari.quantitatPrestecs();
                millorUsuari = usuari;
            }
        }

        return millorUsuari;
    }

    /**
     * Mostra estadístiques generals de la biblioteca.
     *
     * Inclou el llibre més prestat, l'usuari més actiu i el nombre de
     * préstecs per categoria.
     *
     * @param biblioteca biblioteca de la qual es volen mostrar estadístiques
     */
    public void mostrarEstadistiques(Biblioteca biblioteca) {
        System.out.println("\n===== ESTADÍSTIQUES =====");

        Llibre llibrePopular = biblioteca.llibreMesPrestat();

        if (llibrePopular != null) {
            System.out.println("\nLlibre més prestat:");
            System.out.println(llibrePopular);
        }

        Usuari usuariActiu = usuariMesActiu(biblioteca);

        if (usuariActiu != null) {
            System.out.println("\nUsuari més actiu:");
            System.out.println(usuariActiu);
        }

        System.out.println("\nPréstecs per categoria:");

        String[] categories = {
                "Novel·la",
                "Història",
                "Ciència",
                "Tecnologia"
        };

        for (String categoria : categories) {
            System.out.println(categoria + ": " + biblioteca.totalPrestecsCategoria(categoria));
        }
    }



    // ---------------------------------
    // ------- GETTERS + SETTERS -------
    // ---------------------------------

    public List<Prestec> getPrestecs() {
        return prestecs;
    }
}
