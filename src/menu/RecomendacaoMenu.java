package menu;

import model.Recomendacao;
import service.RecomendacaoService;
import util.InputUtil;

public class RecomendacaoMenu {
    public static void exibirMenu(RecomendacaoService service) {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Recomendações ---");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Remover");
            System.out.println("0 - Voltar");
            opcao = InputUtil.lerInt("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> {
                    int id = InputUtil.lerInt("ID: ");
                    String desc = InputUtil.lerString("Descrição: ");
                    String prio = InputUtil.lerString("Prioridade (Baixa/Média/Alta): ");
                    service.cadastrar(new Recomendacao(id, desc, prio));
                    System.out.println("Recomendação adicionada!");
                }
                case 2 -> {
                    System.out.println("\n--- Lista de Recomendações ---");
                    if (service.listar().isEmpty()) System.out.println("Nenhuma recomendação registrada.");
                    else service.listar().forEach(Recomendacao::exibirRecomendacao);
                }
                case 3 -> {
                    int id = InputUtil.lerInt("ID para busca: ");
                    Recomendacao r = service.buscarPorId(id);
                    if (r != null) r.exibirRecomendacao();
                    else System.out.println("Recomendação não encontrada.");
                }
                case 4 -> {
                    int id = InputUtil.lerInt("ID para atualizar: ");
                    if (service.buscarPorId(id) != null) {
                        String desc = InputUtil.lerString("Nova Descrição: ");
                        String prio = InputUtil.lerString("Nova Prioridade: ");
                        service.atualizar(id, new Recomendacao(id, desc, prio));
                        System.out.println("Recomendação atualizada!");
                    } else System.out.println("Recomendação não encontrada.");
                }
                case 5 -> {
                    int id = InputUtil.lerInt("ID para remover: ");
                    if (service.remover(id)) System.out.println("Recomendação removida!");
                    else System.out.println("Recomendação não encontrada.");
                }
            }
        } while (opcao != 0);
    }
}