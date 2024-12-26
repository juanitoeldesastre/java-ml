
import java.util.ArrayList;
import java.util.List;

public class Nodo {

    public String valor; // Nombre del nodo (categoría o película)
    public List<Nodo> hijos; // Lista de hijos del nodo

    // Constructor para inicializar el nodo
    public Nodo(String valor) {
        this.valor = valor;
        this.hijos = new ArrayList<>();
    }

    // Método para agregar hijos al nodo
    public void agregarHijo(Nodo hijo) {
        hijos.add(hijo);
    }
}
