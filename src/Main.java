import service.AmbienteService;
import service.DadoSatelitalService;
import service.SensorIoTService;
import service.RecomendacaoService;
import menu.MenuPrincipal;

public class Main {
    public static void main(String[] args) {
        // Inicialização dos Serviços (Camada de persistência em memória)
        AmbienteService ambienteService = new AmbienteService();
        DadoSatelitalService satelitalService = new DadoSatelitalService();
        SensorIoTService iotService = new SensorIoTService();
        RecomendacaoService recomendacaoService = new RecomendacaoService();

        // Inicialização e execução do Menu Central do Sistema
        MenuPrincipal menu = new MenuPrincipal(ambienteService, satelitalService, iotService, recomendacaoService);
        menu.exibirMenu();
    }
}