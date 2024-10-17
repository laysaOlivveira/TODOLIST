import java.io.*;
import java.util.ArrayList;


public class ToDoList {

    private ArrayList<Tarefa> geralTarefas;
    
    public ToDoList(){
        this.geralTarefas = new ArrayList<>();
    }

    // Adiciona tarefa à lista geral
    public void addGeneralTarefa(String name, String dataLimite, int prioridade) {
        geralTarefas.add(new Tarefa(name, dataLimite, prioridade));
    }

     // Lista todas as tarefas gerais
     public void listGeneralTarefas() {
        if (geralTarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada.");
        } else {
            for (int i = 0; i < geralTarefas.size(); i++) {
                System.out.println(i + " - " + geralTarefas.get(i));
            }
        }
    }

    // Salva uma tarefa em arquivo de categoria
    public void addTarefaToCategory(String category, String name, String dataLimite, int prioridade) {
        Tarefa tarefa = new Tarefa(name, dataLimite, prioridade);
        saveTarefaToFile(category + ".txt", tarefa);
    }

        // Edita uma tarefa de uma categoria
        public void editTarefaInCategory(String category, int TarefaIndex, String newName, String newDueDate, int newPriority) {
            ArrayList<Tarefa> Tarefas = loadTarefasFromFile(category + ".txt");
            if (TarefaIndex >= 0 && TarefaIndex < Tarefas.size()) {
                Tarefa Tarefa = Tarefas.get(TarefaIndex);
                Tarefa.setName(newName);
                Tarefa.setDataLimite(newDueDate);
                Tarefa.setPrioridade(newPriority);
                saveTarefasToFile(category + ".txt", Tarefas); // Sobrescreve o arquivo
            } else {
                System.out.println("Índice inválido!");
            }
        }
    
        // Remove uma tarefa de uma categoria
        public void removeTarefaFromCategory(String category, int TarefaIndex) {
            ArrayList<Tarefa> Tarefas = loadTarefasFromFile(category + ".txt");
            if (TarefaIndex >= 0 && TarefaIndex < Tarefas.size()) {
                Tarefas.remove(TarefaIndex);
                saveTarefasToFile(category + ".txt", Tarefas); // Sobrescreve o arquivo
            } else {
                System.out.println("Índice inválido!");
            }
        }
    
        // Lista tarefas de uma categoria
        public void listCategoryTarefas(String category) {
            ArrayList<Tarefa> Tarefas = loadTarefasFromFile(category + ".txt");
            if (Tarefas.isEmpty()) {
                System.out.println("Nenhuma tarefa encontrada.");
            } else {
                for (int i = 0; i < Tarefas.size(); i++) {
                    System.out.println(i + " - " + Tarefas.get(i));
                }
            }
        }
    
        // Carrega as tarefas de um arquivo de categoria
        private ArrayList<Tarefa> loadTarefasFromFile(String filename) {
            ArrayList<Tarefa> Tarefas = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    Tarefas.add(Tarefa.fromFileString(line));
                }
            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            }
            return Tarefas;
        }
    
        // Salva uma lista de tarefas em um arquivo de categoria
        private void saveTarefasToFile(String filename, ArrayList<Tarefa> Tarefas) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                for (Tarefa tarefa : Tarefas) {
                    writer.write(tarefa.toFileString());
                    writer.newLine();
                }
            } catch (IOException e) {
                System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
            }
        }
    
        // Salva uma única tarefa em um arquivo de categoria (apenas acrescenta)
        private void saveTarefaToFile(String filename, Tarefa tarefa) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
                writer.write(tarefa.toFileString());
                writer.newLine();
            } catch (IOException e) {
                System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
            }
        }
}
