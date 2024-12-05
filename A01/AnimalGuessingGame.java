
import java.util.Scanner;

class DecisionTreeNode {

    String questionOrAnimal;
    DecisionTreeNode yesBranch;
    DecisionTreeNode noBranch;

    public DecisionTreeNode(String questionOrAnimal) {
        this.questionOrAnimal = questionOrAnimal;
    }
}

public class AnimalGuessingGame {

    private DecisionTreeNode root;

    public AnimalGuessingGame() {
        // Crear el árbol de decisión inicial
        root = new DecisionTreeNode("¿Es un mamífero?");
        root.yesBranch = new DecisionTreeNode("¿Es doméstico?");
        root.yesBranch.yesBranch = new DecisionTreeNode("perro");
        root.yesBranch.noBranch = new DecisionTreeNode("león");
        root.noBranch = new DecisionTreeNode("¿Vuela?");
        root.noBranch.yesBranch = new DecisionTreeNode("águila");
        root.noBranch.noBranch = new DecisionTreeNode("serpiente");
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        DecisionTreeNode currentNode = root;

        while (currentNode.yesBranch != null && currentNode.noBranch != null) {
            System.out.println(currentNode.questionOrAnimal);
            System.out.print("Responde (sí/no): ");
            String answer = scanner.nextLine().trim().toLowerCase();

            if (answer.equals("sí")) {
                currentNode = currentNode.yesBranch;
            } else if (answer.equals("no")) {
                currentNode = currentNode.noBranch;
            } else {
                System.out.println("Por favor responde 'sí' o 'no'.");
            }
        }

        // Llegamos a una hoja del árbol
        System.out.println("¿Es un " + currentNode.questionOrAnimal + "?");
        System.out.print("Responde (sí/no): ");
        String finalAnswer = scanner.nextLine().trim().toLowerCase();

        if (finalAnswer.equals("sí")) {
            System.out.println("¡Genial! Adiviné tu animal.");
        } else {
            System.out.println("Oh, no adiviné. ¡Mejoraré para la próxima!");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        AnimalGuessingGame game = new AnimalGuessingGame();
        System.out.println("¡Bienvenido al juego de adivinar animales!");
        game.play();
    }
}
