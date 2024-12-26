
import java.util.HashMap;
import java.util.Map;

public class NodoDecision {

    public String atributo; // Atributo del nodo (p. ej., "Género")
    public Map<String, NodoDecision> hijos; // Hijos del nodo (p. ej., "Acción" -> subárbol)
    public String etiqueta; // Etiqueta si el nodo es hoja (p. ej., "Avengers")

    public NodoDecision(String atributo) {
        this.atributo = atributo;
        this.hijos = new HashMap<>();
        this.etiqueta = null; // Nodo no hoja al principio
    }

    public boolean esHoja() {
        return etiqueta != null;
    }
}
