package menu;

import model.DadoSatelital;
import service.DadoSatelitalService;
import util.InputUtil;

public class DadoSatelitalMenu {
    public static void exibirMenu(DadoSatelitalService service) {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Dados Satelitais ---");
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
                    double temp = InputUtil.lerDouble("Temperatura Externa (°C): ");
                    double umidade = InputUtil.lerDouble("Umidade (%): ");
                    double uv = InputUtil.lerDouble("Índice UV: ");
                    double rad = InputUtil.lerDouble("Radiação Solar (W/m²): ");
                    String clima = InputUtil.lerString("Condição Climática: ");
                    service.cadastrar(new DadoSatelital(id, temp, umidade, uv, rad, clima));
                    System.out.println("Dados satelitais salvos!");
                }
                case 2 -> {
                    System.out.println("\n--- Dados Satelitais ---");
                    if (service.listar().isEmpty()) System.out.println("Nenhum registro.");
                    else service.listar().forEach(DadoSatelital::exibirDados);
                }
                case 3 -> {
                    int id = InputUtil.lerInt("ID para busca: ");
                    DadoSatelital d = service.buscarPorId(id);
                    if (d != null) d.exibirDados();
                    else System.out.println("Registro não encontrado.");
                }
                case 4 -> {
                    int id = InputUtil.lerInt("ID para atualizar: ");
                    if (service.buscarPorId(id) != null) {
                        double temp = InputUtil.lerDouble("Nova Temperatura Externa (°C): ");
                        double umidade = InputUtil.lerDouble("Nova Umidade (%): ");
                        double uv = InputUtil.lerDouble("Novo Índice UV: ");
                        double rad = InputUtil.lerDouble("Nova Radiação Solar (W/m²): ");
                        String clima = InputUtil.lerString("Nova Condição Climática: ");
                        service.atualizar(id, new DadoSatelital(id, temp, umidade, uv, rad, clima));
                        System.out.println("Dados atualizados!");
                    } else System.out.println("Registro não encontrado.");
                }
                case 5 -> {
                    int id = InputUtil.lerInt("ID para remover: ");
                    if (service.remover(id)) System.out.println("Registro removido!");
                    else System.out.println("Registro não encontrado.");
                }
            }
        } while (opcao != 0);
    }
}