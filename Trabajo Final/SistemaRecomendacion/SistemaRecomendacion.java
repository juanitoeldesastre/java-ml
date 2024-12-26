
public class SistemaRecomendacion {

    // Método para crear el árbol de recomendaciones
    public static Nodo crearArbol() {
        Nodo raiz = new Nodo("Películas");

        Nodo accion = new Nodo("Acción");
        Nodo comedia = new Nodo("Comedia");
        Nodo drama = new Nodo("Drama");

        Nodo rapidosFuriosos = new Nodo("Rápidos y Furiosos");
        Nodo johnWick = new Nodo("John Wick");

        Nodo hangover = new Nodo("The Hangover");
        Nodo superbad = new Nodo("Superbad");

        Nodo titanic = new Nodo("Titanic");
        Nodo elPianista = new Nodo("El Pianista");

        accion.agregarHijo(rapidosFuriosos);
        accion.agregarHijo(johnWick);

        comedia.agregarHijo(hangover);
        comedia.agregarHijo(superbad);

        drama.agregarHijo(titanic);
        drama.agregarHijo(elPianista);

        raiz.agregarHijo(accion);
        raiz.agregarHijo(comedia);
        raiz.agregarHijo(drama);

        return raiz;
    }

    // Recorrido pre-order
    public static void preOrder(Nodo nodo) {
        if (nodo == null) {
            return;
        }

        System.out.println(nodo.valor); // Procesar nodo actual
        for (Nodo hijo : nodo.hijos) {
            preOrder(hijo);
        }
    }

    // Recorrido post-order
    public static void postOrder(Nodo nodo) {
        if (nodo == null) {
            return;
        }

        for (Nodo hijo : nodo.hijos) {
            postOrder(hijo);
        }
        System.out.println(nodo.valor); // Procesar nodo actual
    }
}
