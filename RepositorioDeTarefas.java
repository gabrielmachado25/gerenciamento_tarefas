import java.util.ArrayList;
import java.util.List;

public class RepositorioDeTarefas {
    private List<Tarefa> tarefas;
    private int proximoId;

    public RepositorioDeTarefas() {
        tarefas = new ArrayList<>();
        proximoId = 1;
    }

    public void adicionarTarefa(String nome, String descricao) {
        Tarefa tarefa = new Tarefa(proximoId++, nome, descricao);
        tarefas.add(tarefa);
    }

    public void editarTarefa(int id, String nome, String descricao) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) {
                tarefa.setNome(nome);
                tarefa.setDescricao(descricao);
                break;
            }
        }
    }

    public void concluirTarefa(int id) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) {
                tarefa.setConcluida(true);
                break;
            }
        }
    }

    public void deletarTarefa(int id) {
        tarefas.removeIf(tarefa -> tarefa.getId() == id);
    }

    public List<Tarefa> obterTodasTarefas() {
        return tarefas;
    }
}
