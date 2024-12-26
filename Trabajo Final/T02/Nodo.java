
import java.util.ArrayList;
import java.util.List;

public class Nodo {

    public String valor; // Nombre del nodo
    public List<Nodo> hijos; // Lista de nodos hijos

    public Nodo(String valor) {
        this.valor = valor;
        this.hijos = new ArrayList<>();
    }

    public void agregarHijo(Nodo hijo) {
        hijos.add(hijo);
    }
}
