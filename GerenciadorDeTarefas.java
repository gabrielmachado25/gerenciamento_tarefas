import java.util.Scanner;

public class GerenciadorDeTarefas {
    public static void main(String[] args) {
        RepositorioDeTarefas repositorio = new RepositorioDeTarefas();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nGerenciador de Tarefas:");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Editar Tarefa");
            System.out.println("3. Concluir Tarefa");
            System.out.println("4. Deletar Tarefa");
            System.out.println("5. Ver Todas as Tarefas");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();  // consumir a nova linha

            switch (escolha) {
                case 1:
                    System.out.print("Digite o nome da tarefa: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    repositorio.adicionarTarefa(nome, descricao);
                    break;
                case 2:
                    System.out.print("Digite o ID da tarefa para editar: ");
                    int idEdicao = scanner.nextInt();
                    scanner.nextLine();  // consumir a nova linha
                    System.out.print("Digite o novo nome da tarefa: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Digite a nova descrição da tarefa: ");
                    String novaDescricao = scanner.nextLine();
                    repositorio.editarTarefa(idEdicao, novoNome, novaDescricao);
                    break;
                case 3:
                    System.out.print("Digite o ID da tarefa para concluir: ");
                    int idConcluir = scanner.nextInt();
                    repositorio.concluirTarefa(idConcluir);
                    break;
                case 4:
                    System.out.print("Digite o ID da tarefa para deletar: ");
                    int idDeletar = scanner.nextInt();
                    repositorio.deletarTarefa(idDeletar);
                    break;
                case 5:
                    System.out.println("Tarefas:");
                    for (Tarefa tarefa : repositorio.obterTodasTarefas()) {
                        System.out.println(tarefa);
                    }
                    break;
                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
