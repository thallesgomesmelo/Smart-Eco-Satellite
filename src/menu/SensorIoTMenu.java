package menu;

import model.SensorIoT;
import service.SensorIoTService;
import util.InputUtil;

public class SensorIoTMenu {
    public static void exibirMenu(SensorIoTService service) {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Sensores IoT ---");
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
                    double energia = InputUtil.lerDouble("Consumo de Energia (kWh): ");
                    double agua = InputUtil.lerDouble("Consumo de Água (L): ");
                    double temp = InputUtil.lerDouble("Temperatura Interna (°C): ");
                    int ocupacao = InputUtil.lerInt("Nível de Ocupação: ");
                    String status = InputUtil.lerString("Status do Equipamento: ");
                    service.cadastrar(new SensorIoT(id, energia, agua, temp, ocupacao, status));
                    System.out.println("Sensor cadastrado!");
                }
                case 2 -> {
                    System.out.println("\n--- Sensores Cadastrados ---");
                    if (service.listar().isEmpty()) System.out.println("Nenhum sensor registrado.");
                    else service.listar().forEach(SensorIoT::exibirDados);
                }
                case 3 -> {
                    int id = InputUtil.lerInt("ID para busca: ");
                    SensorIoT s = service.buscarPorId(id);
                    if (s != null) s.exibirDados();
                    else System.out.println("Sensor não encontrado.");
                }
                case 4 -> {
                    int id = InputUtil.lerInt("ID para atualizar: ");
                    if (service.buscarPorId(id) != null) {
                        double energia = InputUtil.lerDouble("Novo Consumo de Energia (kWh): ");
                        double agua = InputUtil.lerDouble("Novo Consumo de Água (L): ");
                        double temp = InputUtil.lerDouble("Nova Temperatura Interna (°C): ");
                        int ocupacao = InputUtil.lerInt("Novo Nível Ocupação: ");
                        String status = InputUtil.lerString("Novo Status do Equipamento: ");
                        service.atualizar(id, new SensorIoT(id, energia, agua, temp, ocupacao, status));
                        System.out.println("Sensor atualizado!");
                    } else System.out.println("Sensor não encontrado.");
                }
                case 5 -> {
                    int id = InputUtil.lerInt("ID para remover: ");
                    if (service.remover(id)) System.out.println("Sensor removido!");
                    else System.out.println("Sensor não encontrado.");
                }
            }
        } while (opcao != 0);
    }
}