/**
 * Classe principal del projecte Gestor de Biblioteca.
 *
 * Aquesta classe conté el punt d'entrada del programa i els menús
 * que permeten a l'usuari interactuar amb l'aplicació per consola.
 *
 * @author Mykola
 * @version 1.0
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        GestorBiblioteca gestor = new GestorBiblioteca();

        int opcio;

        do {
            mostrarMenuPrincipal();
            opcio = scanner.nextInt();
            scanner.nextLine();

            switch (opcio) {
                case 1:
                    menuLlibres(scanner, biblioteca);
                    break;

                case 2:
                    menuUsuaris(scanner, biblioteca);
                    break;

                case 3:
                    menuPrestecs(scanner, biblioteca, gestor);
                    break;

                case 4:
                    gestor.mostrarEstadistiques(biblioteca);
                    break;

                case 0:
                    System.out.println("Sortint del programa...");
                    break;

                default:
                    System.out.println("Opció no vàlida.");
            }

        } while (opcio != 0);

        scanner.close();
    }

    // ---------------------------------
    // -------- MENÚ PRINCIPAL ---------
    // ---------------------------------

    public static void mostrarMenuPrincipal() {
        System.out.println("\n===== BIBLIOTECA =====");
        System.out.println("1. Gestió de llibres");
        System.out.println("2. Gestió d'usuaris");
        System.out.println("3. Gestió de préstecs");
        System.out.println("4. Estadístiques");
        System.out.println("0. Sortir");
        System.out.print("\nOpció: ");
    }

    // ---------------------------------
    // -------- MENÚ LLIBRES -----------
    // ---------------------------------

    public static void menuLlibres(Scanner scanner, Biblioteca biblioteca) {
        int opcio;

        do {
            System.out.println("\n===== GESTIÓ DE LLIBRES =====");
            System.out.println("1. Afegir llibre");
            System.out.println("2. Modificar llibre");
            System.out.println("3. Eliminar llibre");
            System.out.println("4. Llistar llibres");
            System.out.println("5. Cercar llibre");
            System.out.println("6. Llistar llibres per categoria");
            System.out.println("0. Tornar al menú principal");
            System.out.print("\nOpció: ");

            opcio = scanner.nextInt();
            scanner.nextLine();

            switch (opcio) {
                case 1:
                    afegirLlibre(scanner, biblioteca);
                    break;

                case 2:
                    modificarLlibre(scanner, biblioteca);
                    break;

                case 3:
                    eliminarLlibre(scanner, biblioteca);
                    break;

                case 4:
                    biblioteca.llistarLlibres();
                    break;

                case 5:
                    cercarLlibre(scanner, biblioteca);
                    break;

                case 6:
                    llistarLlibresPerCategoria(scanner, biblioteca);
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opció no vàlida.");
            }

        } while (opcio != 0);
    }

    public static void afegirLlibre(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Títol: ");
        String titol = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();

        System.out.print("Stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        Llibre llibre = new Llibre(titol, autor, categoria, stock);
        biblioteca.afegirLlibre(llibre);
    }

    public static void modificarLlibre(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Títol del llibre que vols modificar: ");
        String titolModificar = scanner.nextLine();

        Llibre llibreModificar = biblioteca.buscarLlibre(titolModificar);

        if (llibreModificar != null) {
            System.out.print("Nou títol: ");
            String nouTitol = scanner.nextLine();

            System.out.print("Nou autor: ");
            String nouAutor = scanner.nextLine();

            System.out.print("Nova categoria: ");
            String novaCategoria = scanner.nextLine();

            System.out.print("Nou stock: ");
            int nouStock = scanner.nextInt();
            scanner.nextLine();

            llibreModificar.setTitol(nouTitol);
            llibreModificar.setAutor(nouAutor);
            llibreModificar.setCategoria(novaCategoria);
            llibreModificar.setStock(nouStock);

            System.out.println("Llibre modificat correctament.");
        } else {
            System.out.println("No s'ha trobat el llibre.");
        }
    }

    public static void eliminarLlibre(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("ID del llibre que vols eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        biblioteca.eliminarLlibre(id);
    }

    public static void cercarLlibre(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Títol del llibre: ");
        String titol = scanner.nextLine();

        Llibre llibre = biblioteca.buscarLlibre(titol);

        if (llibre != null) {
            System.out.println(llibre);
        } else {
            System.out.println("No s'ha trobat el llibre.");
        }
    }

    public static void llistarLlibresPerCategoria(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();

        biblioteca.llistarPerCategoria(categoria);
    }

    // ---------------------------------
    // -------- MENÚ USUARIS -----------
    // ---------------------------------

    public static void menuUsuaris(Scanner scanner, Biblioteca biblioteca) {
        int opcio;

        do {
            System.out.println("\n===== GESTIÓ D'USUARIS =====");
            System.out.println("1. Afegir usuari");
            System.out.println("2. Modificar usuari");
            System.out.println("3. Eliminar usuari");
            System.out.println("4. Llistar usuaris");
            System.out.println("5. Cercar usuari");
            System.out.println("0. Tornar al menú principal");
            System.out.print("\nOpció: ");

            opcio = scanner.nextInt();
            scanner.nextLine();

            switch (opcio) {
                case 1:
                    afegirUsuari(scanner, biblioteca);
                    break;

                case 2:
                    modificarUsuari(scanner, biblioteca);
                    break;

                case 3:
                    eliminarUsuari(scanner, biblioteca);
                    break;

                case 4:
                    biblioteca.llistarUsuaris();
                    break;

                case 5:
                    cercarUsuari(scanner, biblioteca);
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opció no vàlida.");
            }

        } while (opcio != 0);
    }

    public static void afegirUsuari(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Nom usuari: ");
        String nom = scanner.nextLine();

        Usuari usuari = new Usuari(nom);
        biblioteca.afegirUsuari(usuari);

        System.out.println("Usuari afegit correctament.");
    }

    public static void modificarUsuari(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Nom de l'usuari que vols modificar: ");
        String nom = scanner.nextLine();

        Usuari usuari = biblioteca.buscarUsuari(nom);

        if (usuari != null) {
            System.out.print("Nou nom: ");
            String nouNom = scanner.nextLine();

            usuari.setNom(nouNom);

            System.out.println("Usuari modificat correctament.");
        } else {
            System.out.println("No s'ha trobat l'usuari.");
        }
    }

    public static void eliminarUsuari(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("ID de l'usuari que vols eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        biblioteca.eliminarUsuari(id);
    }

    public static void cercarUsuari(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Nom de l'usuari: ");
        String nom = scanner.nextLine();

        Usuari usuari = biblioteca.buscarUsuari(nom);

        if (usuari != null) {
            System.out.println(usuari);
        } else {
            System.out.println("No s'ha trobat l'usuari.");
        }
    }

    // ---------------------------------
    // -------- MENÚ PRÉSTECS ----------
    // ---------------------------------

    public static void menuPrestecs(Scanner scanner, Biblioteca biblioteca, GestorBiblioteca gestor) {
        int opcio;

        do {
            System.out.println("\n===== GESTIÓ DE PRÉSTECS =====");
            System.out.println("1. Prestar llibre");
            System.out.println("2. Retornar llibre");
            System.out.println("3. Mostrar historial d'un usuari");
            System.out.println("4. Mostrar préstecs actius");
            System.out.println("5. Mostrar préstecs retardats");
            System.out.println("0. Tornar al menú principal");
            System.out.print("\nOpció: ");

            opcio = scanner.nextInt();
            scanner.nextLine();

            switch (opcio) {
                case 1:
                    prestarLlibre(scanner, biblioteca, gestor);
                    break;

                case 2:
                    retornarLlibre(scanner, biblioteca, gestor);
                    break;

                case 3:
                    mostrarHistorialUsuari(scanner, biblioteca, gestor);
                    break;

                case 4:
                    gestor.mostrarPrestecs();
                    break;

                case 5:
                    gestor.mostrarPrestecsRetardats();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opció no vàlida.");
            }

        } while (opcio != 0);
    }

    public static void prestarLlibre(Scanner scanner, Biblioteca biblioteca, GestorBiblioteca gestor) {
        System.out.print("Nom usuari: ");
        String nomUsuari = scanner.nextLine();

        Usuari usuari = biblioteca.buscarUsuari(nomUsuari);

        System.out.print("Títol llibre: ");
        String titolLlibre = scanner.nextLine();

        Llibre llibre = biblioteca.buscarLlibre(titolLlibre);

        if (usuari != null && llibre != null) {
            gestor.prestarLlibre(usuari, llibre);
        } else {
            System.out.println("Usuari o llibre incorrecte.");
        }
    }

    public static void retornarLlibre(Scanner scanner, Biblioteca biblioteca, GestorBiblioteca gestor) {
        System.out.print("Nom usuari: ");
        String nomUsuari = scanner.nextLine();

        Usuari usuari = biblioteca.buscarUsuari(nomUsuari);

        System.out.print("Títol llibre: ");
        String titolLlibre = scanner.nextLine();

        Llibre llibre = biblioteca.buscarLlibre(titolLlibre);

        if (usuari != null && llibre != null) {
            gestor.retornarLlibre(usuari, llibre);
        } else {
            System.out.println("Usuari o llibre incorrecte.");
        }
    }

    public static void mostrarHistorialUsuari(Scanner scanner, Biblioteca biblioteca, GestorBiblioteca gestor) {
        System.out.print("Nom usuari: ");
        String nomUsuari = scanner.nextLine();

        Usuari usuari = biblioteca.buscarUsuari(nomUsuari);

        if (usuari != null) {
            gestor.mostrarPrestecsUsuari(usuari);
        } else {
            System.out.println("Usuari no trobat.");
        }
    }
}
