
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AlgoritmoID3 {

    // Crea el árbol de decisión utilizando el algoritmo ID3
    public static NodoDecision construirArbol(List<Map<String, String>> datos, List<String> atributos) {
        // Si todos los datos tienen la misma clasificación, crea una hoja
        if (todosIguales(datos)) {
            NodoDecision hoja = new NodoDecision(null);
            hoja.etiqueta = datos.get(0).get("Película");
            return hoja;
        }

        // Si no hay más atributos, devuelve la clasificación más común
        if (atributos.isEmpty()) {
            NodoDecision hoja = new NodoDecision(null);
            hoja.etiqueta = obtenerEtiquetaMasComun(datos);
            return hoja;
        }

        // Encuentra el mejor atributo para dividir
        String mejorAtributo = obtenerMejorAtributo(datos, atributos);

        // Crea un nodo con el mejor atributo
        NodoDecision nodo = new NodoDecision(mejorAtributo);

        // Obtén los valores únicos del atributo
        Set<String> valores = obtenerValoresUnicos(datos, mejorAtributo);

        // Filtra los datos y crea subárboles recursivamente
        for (String valor : valores) {
            List<Map<String, String>> subconjunto = filtrarDatos(datos, mejorAtributo, valor);
            if (subconjunto.isEmpty()) {
                NodoDecision hoja = new NodoDecision(null);
                hoja.etiqueta = obtenerEtiquetaMasComun(datos);
                nodo.hijos.put(valor, hoja);
            } else {
                List<String> nuevosAtributos = new ArrayList<>(atributos);
                nuevosAtributos.remove(mejorAtributo);
                nodo.hijos.put(valor, construirArbol(subconjunto, nuevosAtributos));
            }
        }

        return nodo;
    }

    // Calcula la entropía de un conjunto de datos
    private static double calcularEntropia(List<Map<String, String>> datos) {
        Map<String, Integer> frecuencia = new HashMap<>();
        for (Map<String, String> fila : datos) {
            String etiqueta = fila.get("Película");
            frecuencia.put(etiqueta, frecuencia.getOrDefault(etiqueta, 0) + 1);
        }

        double entropia = 0.0;
        int total = datos.size();
        for (int count : frecuencia.values()) {
            double probabilidad = (double) count / total;
            entropia -= probabilidad * Math.log(probabilidad) / Math.log(2);
        }

        return entropia;
    }

    // Calcula la ganancia de información para un atributo
    private static double calcularGanancia(List<Map<String, String>> datos, String atributo) {
        double entropiaInicial = calcularEntropia(datos);
        Map<String, List<Map<String, String>>> particiones = new HashMap<>();
        for (Map<String, String> fila : datos) {
            String valor = fila.get(atributo);
            particiones.putIfAbsent(valor, new ArrayList<>());
            particiones.get(valor).add(fila);
        }

        double entropiaCondicional = 0.0;
        int total = datos.size();
        for (List<Map<String, String>> subconjunto : particiones.values()) {
            double probabilidad = (double) subconjunto.size() / total;
            entropiaCondicional += probabilidad * calcularEntropia(subconjunto);
        }

        return entropiaInicial - entropiaCondicional;
    }

    // Encuentra el mejor atributo para dividir los datos
    private static String obtenerMejorAtributo(List<Map<String, String>> datos, List<String> atributos) {
        double mejorGanancia = -1;
        String mejorAtributo = null;
        for (String atributo : atributos) {
            double ganancia = calcularGanancia(datos, atributo);
            if (ganancia > mejorGanancia) {
                mejorGanancia = ganancia;
                mejorAtributo = atributo;
            }
        }
        return mejorAtributo;
    }

    // Otros métodos auxiliares
    private static boolean todosIguales(List<Map<String, String>> datos) {
        String primeraEtiqueta = datos.get(0).get("Película");
        for (Map<String, String> fila : datos) {
            if (!fila.get("Película").equals(primeraEtiqueta)) {
                return false;
            }
        }
        return true;
    }

    private static String obtenerEtiquetaMasComun(List<Map<String, String>> datos) {
        Map<String, Integer> frecuencia = new HashMap<>();
        for (Map<String, String> fila : datos) {
            String etiqueta = fila.get("Película");
            frecuencia.put(etiqueta, frecuencia.getOrDefault(etiqueta, 0) + 1);
        }
        return Collections.max(frecuencia.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private static Set<String> obtenerValoresUnicos(List<Map<String, String>> datos, String atributo) {
        Set<String> valores = new HashSet<>();
        for (Map<String, String> fila : datos) {
            valores.add(fila.get(atributo));
        }
        return valores;
    }

    private static List<Map<String, String>> filtrarDatos(List<Map<String, String>> datos, String atributo, String valor) {
        List<Map<String, String>> subconjunto = new ArrayList<>();
        for (Map<String, String> fila : datos) {
            if (fila.get(atributo).equals(valor)) {
                subconjunto.add(fila);
            }
        }
        return subconjunto;
    }
}
