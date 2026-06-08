classDiagram
    direction UI

    class Ambiente {
        - int id
        - String nome
        - String tipoAmbiente
        - int quantidadeFuncionarios
        - double areaM2
        + Ambiente(int, String, String, int, double)
        + exibirInformacoes() void
        + toString() String
    }

    class DadoSatelital {
        - int id
        - double temperaturaExterna
        - double umidade
        - double indiceUV
        - double radiacaoSolar
        - String condicaoClimatica
        + DadoSatelital(int, double, double, double, double, String)
        + exibirDados() void
        + toString() String
    }

    class SensorIoT {
        - int id
        - double consumoEnergia
        - double consumoAgua
        - double temperaturaInterna
        - int ocupacaoAmbiente
        - String statusEquipamento
        + SensorIoT(int, double, double, double, int, String)
        + exibirDados() void
        + toString() String
    }

    class Recomendacao {
        - int id
        - String descricao
        - String prioridade
        + Recomendacao(int, String, String)
        + exibirRecomendacao() void
        + toString() String
    }

    class AmbienteService {
        - ArrayList~Ambiente~ lista
        + cadastrar(Ambiente) void
        + listar() ArrayList~Ambiente~
        + buscarPorId(int) Ambiente
        + atualizar(int, Ambiente) boolean
        + remover(int) boolean
    }

    class DadoSatelitalService {
        - ArrayList~DadoSatelital~ lista
        + cadastrar(DadoSatelital) void
        + listar() ArrayList~DadoSatelital~
        + buscarPorId(int) DadoSatelital
        + atualizar(int, DadoSatelital) boolean
        + remover(int) boolean
    }

    class SensorIoTService {
        - ArrayList~SensorIoT~ lista
        + cadastrar(SensorIoT) void
        + listar() ArrayList~SensorIoT~
        + buscarPorId(int) SensorIoT
        + atualizar(int, SensorIoT) boolean
        + remover(int) boolean
    }

    class RecomendacaoService {
        - ArrayList~Recomendacao~ lista
        + cadastrar(Recomendacao) void
        + listar() ArrayList~Recomendacao~
        + buscarPorId(int) Recomendacao
        + atualizar(int, Recomendacao) boolean
        + remover(int) boolean
    }

    AmbienteService "1" --> "*" Ambiente : gerencia
    DadoSatelitalService "1" --> "*" DadoSatelital : gerencia
    SensorIoTService "1" --> "*" SensorIoT : gerencia
    RecomendacaoService "1" --> "*" Recomendacao : gerencia

    class MenuPrincipal {
        - AmbienteService ambienteService
        - DadoSatelitalService satelitalService
        - SensorIoTService iotService
        - RecomendacaoService recomendacaoService
        + MenuPrincipal(AmbienteService, DadoSatelitalService, SensorIoTService, RecomendacaoService)
        + exibirMenu() void
        - exibirRelatorioGeral() void
    }

    MenuPrincipal --> AmbienteService
    MenuPrincipal --> DadoSatelitalService
    MenuPrincipal --> SensorIoTService
    MenuPrincipal --> RecomendacaoService