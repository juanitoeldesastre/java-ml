
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
            System.out.println("Oh, no adiviné. Ayúdame a mejorar.");
            System.out.print("¿Cuál era tu animal? ");
            String userAnimal = scanner.nextLine().trim();

            System.out.println("Por favor, dame una pregunta que diferencie un(a) " + userAnimal + " de un(a) " + currentNode.questionOrAnimal + ".");
            System.out.print("Tu pregunta debe ser del tipo '¿Es ...?': ");
            String newQuestion = scanner.nextLine().trim();

            System.out.print("Si la respuesta a tu pregunta es 'sí', ¿el animal es un " + userAnimal + "? (sí/no): ");
            String yesForNewAnimal = scanner.nextLine().trim().toLowerCase();

            // Crear nodos para la nueva pregunta y animales
            DecisionTreeNode newAnimalNode = new DecisionTreeNode(userAnimal);
            DecisionTreeNode oldAnimalNode = new DecisionTreeNode(currentNode.questionOrAnimal);

            if (yesForNewAnimal.equals("sí")) {
                currentNode.questionOrAnimal = newQuestion;
                currentNode.yesBranch = newAnimalNode;
                currentNode.noBranch = oldAnimalNode;
            } else {
                currentNode.questionOrAnimal = newQuestion;
                currentNode.yesBranch = oldAnimalNode;
                currentNode.noBranch = newAnimalNode;
            }

            System.out.println("¡Gracias! Ahora soy más inteligente.");
        }
    }

    public static void main(String[] args) {
        AnimalGuessingGame game = new AnimalGuessingGame();
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido al juego de adivinar animales!");
        String playAgain;

        do {
            game.play();
            System.out.print("¿Quieres jugar otra vez? (sí/no): ");
            playAgain = scanner.nextLine().trim().toLowerCase();
        } while (playAgain.equals("sí"));

        System.out.println("¡Gracias por jugar!");
        scanner.close();
    }
}
