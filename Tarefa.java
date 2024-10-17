import java.io.Serializable;
import java.lang.Integer;

public class Tarefa implements Serializable {
    private String name;
    private String dataLimite;
    private int prioridade;
    private boolean completo;


    public Tarefa(String name, String dataLimite, int prioridade, boolean completo) {
        this.name = name;
        this.dataLimite = dataLimite;
        this.prioridade = prioridade;
        this.completo = false;
    }

    public String getName() {
        return name;
    }

    public String getDataLimite() {
        return dataLimite;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public boolean isCompleto() {
        return completo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDataLimite(String dataLimite) {
        this.dataLimite = dataLimite;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public void setCompleto() {
        this.completo = true;
    }

    public String toString(){
        String priorityStr = switch(prioridade){
            case 1 -> "Alta";
            case 2 -> "Média";
            case 3 -> "Baixa";
            default -> "Desconhecida";
        };
        return (completo ? "[X] " : "[ ]") + name + "| Data limite: "+
        dataLimite + "| Prioridade: " + priorityStr;
    }

    // serializar em formato para salvar em arquivo
    public String toFileString(){
        return name + "|" + dataLimite + "|" + prioridade + "|" + completo;
    }

    // carregar a partir de uma string de arquivo
    public static Tarefa fromFileString(String fileString){
        String[] partes = fileString.split("\\|");
        Tarefa tarefa = new Tarefa(partes[0], partes[1], Integer.parseInt(partes[2]));
        if (Boolean.parseBoolean(partes[3])){
            tarefa.setCompleto();
        }
        return tarefa;
    }
}
