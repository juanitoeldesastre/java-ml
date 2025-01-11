import java.util.Scanner;

class Nodo {
    int valor;
    Nodo izquierda, derecha;

    public Nodo(int valor) {
        this.valor = valor;
        izquierda = derecha = null;
    }
}

class ArbolBinario {
    private Nodo raiz;

    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private Nodo insertarRec(Nodo nodo, int valor) {
        if (nodo == null) {
            nodo = new Nodo(valor);
            return nodo;
        }
        if (valor < nodo.valor) {
            nodo.izquierda = insertarRec(nodo.izquierda, valor);
        } else if (valor > nodo.valor) {
            nodo.derecha = insertarRec(nodo.derecha, valor);
        }
        return nodo;
    }

    public void mostrar() {
        mostrarRec(raiz, 0);
    }

    private void mostrarRec(Nodo nodo, int nivel) {
        if (nodo == null) {
            return;
        }
        mostrarRec(nodo.derecha, nivel + 1);
        System.out.println(" ".repeat(nivel * 4) + nodo.valor);
        mostrarRec(nodo.izquierda, nivel + 1);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolBinario arbol = new ArbolBinario();

        System.out.println("Ingrese números para el árbol binario (separados por espacio):");
        String[] numeros = scanner.nextLine().split(" ");

        for (String num : numeros) {
            arbol.insertar(Integer.parseInt(num));
        }

        System.out.println("\nÁrbol Binario:");
        arbol.mostrar();
    }
}
