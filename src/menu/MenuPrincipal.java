package menu;

import service.AmbienteService;
import service.DadoSatelitalService;
import service.SensorIoTService;
import service.RecomendacaoService;
import util.InputUtil;
import model.SensorIoT;
import model.DadoSatelital;

public class MenuPrincipal {
    private final AmbienteService ambienteService;
    private final DadoSatelitalService satelitalService;
    private final SensorIoTService iotService;
    private final RecomendacaoService recomendacaoService;

    public MenuPrincipal(AmbienteService ambienteService, DadoSatelitalService satelitalService, SensorIoTService iotService, RecomendacaoService recomendacaoService) {
        this.ambienteService = ambienteService;
        this.satelitalService = satelitalService;
        this.iotService = iotService;
        this.recomendacaoService = recomendacaoService;
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n===== SMART ECO SATELLITE =====");
            System.out.println("1 - Gerenciar Ambientes");
            System.out.println("2 - Gerenciar Dados Satelitais");
            System.out.println("3 - Gerenciar Sensores IoT");
            System.out.println("4 - Gerenciar Recomendações");
            System.out.println("5 - Exibir Relatório Geral");
            System.out.println("0 - Sair");
            opcao = InputUtil.lerInt("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> AmbienteMenu.exibirMenu(ambienteService);
                case 2 -> DadoSatelitalMenu.exibirMenu(satelitalService);
                case 3 -> SensorIoTMenu.exibirMenu(iotService);
                case 4 -> RecomendacaoMenu.exibirMenu(recomendacaoService);
                case 5 -> exibirRelatorioGeral();
                case 0 -> System.out.println("Finalizando aplicação. Até logo!");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void exibirRelatorioGeral() {
        System.out.println("\n=================================");
        System.out.println("        RELATÓRIO GERAL          ");
        System.out.println("=================================");

        int totalAmbientes = ambienteService.listar().size();
        int totalSensores = iotService.listar().size();
        int totalRecomendacoes = recomendacaoService.listar().size();

        double mediaEnergia = iotService.listar().stream()
                .mapToDouble(SensorIoT::getConsumoEnergia).average().orElse(0.0);

        double mediaAgua = iotService.listar().stream()
                .mapToDouble(SensorIoT::getConsumoAgua).average().orElse(0.0);

        double mediaTempExterna = satelitalService.listar().stream()
                .mapToDouble(DadoSatelital::getTemperaturaExterna).average().orElse(0.0);

        System.out.println("Quantidade de ambientes cadastrados : " + totalAmbientes);
        System.out.println("Quantidade de sensores cadastrados  : " + totalSensores);
        System.out.printf("Média do consumo energético          : %.2f kWh\n", mediaEnergia);
        System.out.printf("Média do consumo de água             : %.2f L\n", mediaAgua);
        System.out.printf("Temperatura externa média            : %.2f °C\n", mediaTempExterna);
        System.out.println("Quantidade de recomendações          : " + totalRecomendacoes);
        System.out.println("=================================");
    }
}