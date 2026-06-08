package menu;

import model.Ambiente;
import service.AmbienteService;
import util.InputUtil;

public class AmbienteMenu {
    public static void exibirMenu(AmbienteService service) {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Ambientes ---");
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
                    String nome = InputUtil.lerString("Nome: ");
                    String tipo = InputUtil.lerString("Tipo de Ambiente: ");
                    int func = InputUtil.lerInt("Quantidade de Funcionários: ");
                    double area = InputUtil.lerDouble("Área (m²): ");
                    service.cadastrar(new Ambiente(id, nome, tipo, func, area));
                    System.out.println("Ambiente cadastrado com sucesso!");
                }
                case 2 -> {
                    System.out.println("\n--- Lista de Ambientes ---");
                    if (service.listar().isEmpty()) System.out.println("Nenhum cadastrado.");
                    else service.listar().forEach(Ambiente::exibirInformacoes);
                }
                case 3 -> {
                    int id = InputUtil.lerInt("ID para busca: ");
                    Ambiente a = service.buscarPorId(id);
                    if (a != null) a.exibirInformacoes();
                    else System.out.println("Ambiente não encontrado.");
                }
                case 4 -> {
                    int id = InputUtil.lerInt("ID para atualizar: ");
                    if (service.buscarPorId(id) != null) {
                        String nome = InputUtil.lerString("Novo Nome: ");
                        String tipo = InputUtil.lerString("Novo Tipo: ");
                        int func = InputUtil.lerInt("Nova Qtde Funcionários: ");
                        double area = InputUtil.lerDouble("Nova Área (m²): ");
                        service.atualizar(id, new Ambiente(id, nome, tipo, func, area));
                        System.out.println("Ambiente atualizado!");
                    } else System.out.println("Ambiente não encontrado.");
                }
                case 5 -> {
                    int id = InputUtil.lerInt("ID para remover: ");
                    if (service.remover(id)) System.out.println("Ambiente removido!");
                    else System.out.println("Ambiente não encontrado.");
                }
            }
        } while (opcao != 0);
    }
}