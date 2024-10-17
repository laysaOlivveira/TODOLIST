import java.util.Scanner;
//import TODOLIST.ToDoList;

public class Main {
    private ToDoList todoList;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoList todoList = new ToDoList();

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Adicionar tarefa geral");
            System.out.println("2. Adicionar tarefa em categoria/disciplina");
            System.out.println("3. Listar tarefas gerais");
            System.out.println("4. Listar tarefas por categoria/disciplina");
            System.out.println("5. Editar tarefa em categoria/disciplina");
            System.out.println("6. Remover tarefa em categoria/disciplina");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Digite o nome da tarefa: ");
                    String name = scanner.nextLine();
                    System.out.print("Digite a data limite (dd/MM/yyyy): ");
                    String dueDate = scanner.nextLine();
                    System.out.print("Digite a prioridade (1 = Alta, 2 = Média, 3 = Baixa): ");
                    int priority = scanner.nextInt();
                    scanner.nextLine();
                    todoList.addGeneralTarefa(name, dueDate, priority);
                    break;
                case 2:
                    System.out.print("Digite a categoria/disciplina: ");
                    String category = scanner.nextLine();
                    System.out.print("Digite o nome da tarefa: ");
                    name = scanner.nextLine();
                    System.out.print("Digite a data limite (dd/MM/yyyy): ");
                    dueDate = scanner.nextLine();
                    System.out.print("Digite a prioridade (1 = Alta, 2 = Média, 3 = Baixa): ");
                    priority = scanner.nextInt();
                    scanner.nextLine();
                    todoList.addTarefaToCategory(category, name, dueDate, priority);
                    break;
                case 3:
                    todoList.listGeneralTarefas();
                    break;
                case 4:
                    System.out.print("Digite a categoria/disciplina: ");
                    category = scanner.nextLine();
                    todoList.listCategoryTarefas(category);
                    break;
                case 5:
                    System.out.print("Digite a categoria/disciplina: ");
                    category = scanner.nextLine();
                    System.out.print("Digite o índice da tarefa a ser editada: ");
                    int indexToEdit = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Novo nome da tarefa: ");
                    String newName = scanner.nextLine();
                    System.out.print("Nova data limite: ");
                    String newDueDate = scanner.nextLine();
                    System.out.print("Nova prioridade (1 = Alta, 2 = Média, 3 = Baixa): ");
                    int newPriority = scanner.nextInt();
                    scanner.nextLine();
                    todoList.editTarefaInCategory(category, indexToEdit, newName, newDueDate, newPriority);
                    break;
                case 6:
                    System.out.print("Digite a categoria/disciplina: ");
                    category = scanner.nextLine();
                    System.out.print("Digite o índice da tarefa a ser removida: ");
                    int indexToRemove = scanner.nextInt();
                    scanner.nextLine();
                    todoList.removeTarefaFromCategory(category, indexToRemove);
                    break;
                case 7:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
