// Nodo del árbol

class Nodo {

    String pregunta;      // Condición o pregunta
    Nodo izquierda;       // Rama izquierda
    Nodo derecha;         // Rama derecha

    // Constructor
    public Nodo(String pregunta) {
        this.pregunta = pregunta;
        this.izquierda = null;
        this.derecha = null;
    }
}

// Clase principal
public class arbolito {

    public static void main(String[] args) {
        // Crear el árbol
        Nodo raiz = new Nodo("¿Es mayor de 18 años?");
        raiz.izquierda = new Nodo("Menor de edad");
        raiz.derecha = new Nodo("¿Tiene licencia de conducir?");
        raiz.derecha.izquierda = new Nodo("Sin licencia");
        raiz.derecha.derecha = new Nodo("Apto para conducir");

        // Simular decisiones
        System.out.println("Decisión: " + recorrerArbol(raiz, 20, true));
    }

    // Método para recorrer el árbol
    public static String recorrerArbol(Nodo nodo, int edad, boolean licencia) {
        if (nodo.izquierda == null && nodo.derecha == null) {
            return nodo.pregunta; // Es una hoja
        }

        // Condición basada en los datos
        if (nodo.pregunta.equals("¿Es mayor de 18 años?")) {
            return (edad >= 18) ? recorrerArbol(nodo.derecha, edad, licencia)
                    : recorrerArbol(nodo.izquierda, edad, licencia);
        } else if (nodo.pregunta.equals("¿Tiene licencia de conducir?")) {
            return licencia ? recorrerArbol(nodo.derecha, edad, licencia)
                    : recorrerArbol(nodo.izquierda, edad, licencia);
        }

        return "No se pudo tomar una decisión.";
    }
}
