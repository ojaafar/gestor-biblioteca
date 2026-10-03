/**
 * Representa un llibre dins del sistema de gestió de biblioteca.
 *
 * Aquesta classe guarda la informació bàsica d'un llibre, com el títol,
 * l'autor, la categoria, el stock disponible i el nombre de vegades que
 * ha estat prestat.
 *
 * @author Aaron
 * @version 1.0
 */
public class Llibre {

    // ---------------------------------
    // ---------- ATRIBUTOS ------------
    // ---------------------------------

    private static int contadorId = 1;
    private int id;
    private String titol;
    private String autor;
    private String categoria;
    private int stock;
    private int vegadesPrestat;

    // ---------------------------------
    // --------- CONSTRUCTOR -----------
    // ---------------------------------

    /**
     * Crea un nou llibre amb les dades indicades.
     *
     * @param titol títol del llibre
     * @param autor autor del llibre
     * @param categoria categoria a la qual pertany el llibre
     * @param stock nombre d'exemplars disponibles
     */
    public Llibre(String titol, String autor, String categoria, int stock) {
        this.id = contadorId++;
        this.titol = titol;
        this.autor = autor;
        this.categoria = categoria;
        this.stock = stock;
        this.vegadesPrestat = 0;
    }

    // ---------------------------------
    // ----------- FUNCIONES -----------
    // ---------------------------------

    /**
     * Comprova si el llibre té exemplars disponibles.
     *
     * @return true si el stock és superior a 0; false en cas contrari
     */
    public boolean disponible() {
        return stock > 0;
    }

    /**
     * Presta un exemplar del llibre.
     *
     * Si hi ha stock disponible, redueix el stock en una unitat i incrementa
     * el nombre de vegades que el llibre ha estat prestat.
     */
    public void prestar() {
        if (stock > 0) {
            stock--;
            vegadesPrestat++;
        }

    }

    /**
     * Retorna un exemplar del llibre.
     *
     * Incrementa el stock del llibre en una unitat.
     */
    public void retornar() {
        stock++;
    }

    /**
     * Retorna la informació del llibre en format text.
     *
     * @return cadena de text amb les dades del llibre
     */
    @Override
    public String toString() {
        return "\n----- LLIBRE -----" +
                "\nID: " + id +
                "\nTítol: " + titol +
                "\nAutor: " + autor +
                "\nCategoria: " + categoria +
                "\nStock: " + stock;
    }

    // ---------------------------------
    // ------- GETTERS + SETTERS -------
    // ---------------------------------

    public int getId() {
        return id;
    }

    public String getTitol() {
        return titol;
    }

    public String getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getStock() {
        return stock;
    }

    public int getVegadesPrestat() {
        return vegadesPrestat;
    }


    public void setTitol(String titol) {
        this.titol = titol;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
