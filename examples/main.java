
class DecisionTree {

    // Nodo del árbol
    static class Node {

        String question;   // Pregunta o decisión
        Node yesBranch;    // Rama "sí"
        Node noBranch;     // Rama "no"

        Node(String question) {
            this.question = question;
        }
    }

    // Método principal
    public static void main(String[] args) {
        // Crear el árbol de decisión
        Node root = new Node("¿Está soleado?");
        root.yesBranch = new Node("¿Hace calor?");
        root.noBranch = new Node("¿Está lloviendo?");

        // Ramas para el caso soleado
        root.yesBranch.yesBranch = new Node("Ve a la playa.");
        root.yesBranch.noBranch = new Node("Da un paseo al parque.");

        // Ramas para el caso no soleado
        root.noBranch.yesBranch = new Node("Lleva un paraguas.");
        root.noBranch.noBranch = new Node("Lee un libro en casa.");

        // Ejecutar el árbol de decisión
        String[] respuestas = {"no", "sí"}; // Cambia estas respuestas para probar diferentes escenarios
        String decision = traverseTree(root, respuestas);
        System.out.println("Decisión: " + decision);
    }

    // Método para recorrer el árbol de decisión
    private static String traverseTree(Node node, String[] answers) {
        Node currentNode = node;
        int index = 0;

        while (currentNode.yesBranch != null && currentNode.noBranch != null) {
            if (index >= answers.length) {
                return "Respuestas insuficientes.";
            }
            String answer = answers[index++].toLowerCase();
            currentNode = answer.equals("sí") ? currentNode.yesBranch : currentNode.noBranch;
        }

        return currentNode.question; // Nodo hoja (decisión final)
    }
}
