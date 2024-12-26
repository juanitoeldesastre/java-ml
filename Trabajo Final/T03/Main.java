
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // Datos de ejemplo
        List<Map<String, String>> datos = new ArrayList<>();
        datos.add(Map.of("Género", "Acción", "Año", "2019", "Película", "Avengers: Endgame"));
        datos.add(Map.of("Género", "Acción", "Año", "2008", "Película", "El Caballero de la Noche"));
        datos.add(Map.of("Género", "Comedia", "Año", "2011", "Película", "The Hangover"));
        datos.add(Map.of("Género", "Comedia", "Año", "2004", "Película", "Shrek"));
        datos.add(Map.of("Género", "Drama", "Año", "1997", "Película", "Titanic"));

        // Atributos
        List<String> atributos = new ArrayList<>(List.of("Género", "Año"));

        // Construir árbol de decisiones
        NodoDecision arbol = AlgoritmoID3.construirArbol(datos, atributos);

        // Visualizar árbol
        imprimirArbol(arbol, "");
    }

    private static void imprimirArbol(NodoDecision nodo, String indentacion) {
        if (nodo.esHoja()) {
            System.out.println(indentacion + "-> " + nodo.etiqueta);
        } else {
            System.out.println(indentacion + nodo.atributo);
            for (Map.Entry<String, NodoDecision> entrada : nodo.hijos.entrySet()) {
                System.out.println(indentacion + "  " + entrada.getKey() + ":");
                imprimirArbol(entrada.getValue(), indentacion + "    ");
            }
        }
    }
}
