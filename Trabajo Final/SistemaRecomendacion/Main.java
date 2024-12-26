
public class Main {

    public static void main(String[] args) {
        // Crear el árbol de películas
        Nodo arbolDePeliculas = SistemaRecomendacion.crearArbol();

        // Recorrer el árbol en pre-order
        System.out.println("Recorrido Pre-order:");
        SistemaRecomendacion.preOrder(arbolDePeliculas);

        // Recorrer el árbol en post-order
        System.out.println("\nRecorrido Post-order:");
        SistemaRecomendacion.postOrder(arbolDePeliculas);
    }
}
