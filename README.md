# Documentació del projecte Gestor de Biblioteca

## 1. Informació general
Nom del projecte: Gestor de Biblioteca
Llenguatge: Java
Tipus d’aplicació: aplicació de consola
Repositori: GitHub

Aquest projecte permet gestionar una biblioteca de manera senzilla. L’aplicació treballa amb llibres, usuaris i préstecs mitjançant un menú per consola.

La documentació segueix els tres tipus treballats a classe:
* Documentació per a l’usuari.
* Documentació tècnica.
* Documentació orientada al programador.

## 2. Documentació per a l’usuari

Quan s’executa el programa, apareix un menú principal amb aquestes opcions:

1. Gestió de llibres
2. Gestió d'usuaris
3. Gestió de préstecs
4. Estadístiques
0. Sortir

### Gestió de llibres
L’usuari pot:
* Afegir llibres.
* Modificar llibres.
* Eliminar llibres per ID.
* Llistar tots els llibres.
* Cercar llibres pel títol.
* Llistar llibres per categoria.

Cada llibre té un ID, títol, autor, categoria, stock i nombre de vegades prestat.

### Gestió d’usuaris
L’usuari pot:
* Afegir usuaris.
* Modificar el nom d’un usuari.
* Eliminar usuaris per ID.
* Llistar usuaris.
* Cercar usuaris pel nom.

Cada usuari té un ID, un nom, una llista de llibres prestats i un historial de préstecs.

### Gestió de préstecs
L’aplicació permet:
* Prestar un llibre a un usuari.
* Retornar un llibre.
* Consultar l’historial de préstecs d’un usuari.
* Mostrar préstecs actius.
* Mostrar préstecs retardats.

Un usuari pot tenir com a màxim 3 llibres prestats. La data de retorn es calcula automàticament dues setmanes després de la data del préstec.

### Estadístiques
El programa mostra:
* El llibre més prestat.
* L’usuari més actiu.
* El nombre de préstecs per categoria.

## 3. Documentació tècnica

### Requisits
Per executar el projecte cal tenir instal·lat:
* Java JDK.
* Un IDE com IntelliJ IDEA, Eclipse, NetBeans o Visual Studio Code.
* Git, si es vol descarregar el projecte des de GitHub.

### Instal·lació des de GitHub
```
git clone URL_DEL_REPOSITORI
cd NOM_DEL_PROJECTE
```
### Compilació i execució
Si tots els fitxers .java estan a la mateixa carpeta:
```
javac *.java
java Main
```
### Generació de Javadoc

Per generar documentació tècnica en HTML:
```
javadoc -d doc -author -version *.java
```
Aquesta comanda crea una carpeta doc amb la documentació del codi.

## 4. Documentació orientada al programador

El projecte està format per aquestes classes:

Main -> Conté el menú principal i gestiona la interacció amb l’usuari.
Biblioteca -> Guarda i gestiona llibres i usuaris.
GestorBiblioteca -> Controla préstecs, retorns i estadístiques.
Llibre -> Representa un llibre de la biblioteca.
Usuari -> Representa un usuari de la biblioteca.
Prestec -> Representa el préstec d’un llibre a un usuari.

### Funcionament general

La classe Main crea una Biblioteca i un GestorBiblioteca.
La classe Biblioteca guarda les llistes de llibres i usuaris.
La classe GestorBiblioteca controla els préstecs actius.

Quan es presta un llibre:
1. Es busca l’usuari.
2. Es busca el llibre.
3. Es comprova que el llibre tingui stock.
4. Es crea un préstec.
5. Es redueix el stock del llibre.
6. S’afegeix el préstec a l’historial de l’usuari.

Quan es retorna un llibre, s’elimina dels préstecs actius i augmenta el stock del llibre.

## 5. Repartiment de tasques

### Mykola

Fitxers:
* GestorBiblioteca.java
* Main.java

Tasques aproximades:
* Creació del menú principal.
* Creació dels menús de llibres, usuaris i préstecs.
* Gestió de l’entrada de dades amb Scanner.
* Implementació de préstecs, retorns i estadístiques.

### Aaron

Fitxers:
* Llibre.java
* Biblioteca.java

Tasques aproximades:
* Creació de la classe Llibre.
* Gestió del stock dels llibres.
* Creació de la classe Biblioteca.
* Gestió de llibres i usuaris.
* Implementació de cerques i llistats.

### Ousama

Fitxers:
* Usuari.java
* Prestec.java

Tasques aproximades:
* Creació de la classe Usuari.
* Gestió dels llibres prestats per usuari.
* Creació de l’historial de préstecs.
* Creació de la classe Prestec.
* Control de dates de préstec, retorn i retards.

## 6. Limitacions i millores futures

Actualment, el projecte no guarda les dades quan es tanca el programa, perquè no utilitza fitxers ni base de dades.

Possibles millores:
* Afegir persistència de dades.
* Afegir validació d’errors d’entrada.
* Crear una interfície gràfica.
* Afegir proves unitàries.
* Millorar la documentació Javadoc dins el codi.
