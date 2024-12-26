
public class Main {

    public static void main(String[] args) {
        Nodo arbolDePeliculas = Sistema.crearArbol();

        System.out.println("Recorrido Pre-order:");
        Sistema.preOrder(arbolDePeliculas);

        System.out.println("\nRecorrido Post-order:");
        Sistema.postOrder(arbolDePeliculas);
    }
}
