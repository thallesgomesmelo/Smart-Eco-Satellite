package model;

public class SensorIoT {
    private int id;
    private double consumoEnergia;
    private double consumoAgua;
    private double temperaturaInterna;
    private int ocupacaoAmbiente;
    private String statusEquipamento;

    public SensorIoT(int id, double consumoEnergia, double consumoAgua, double temperaturaInterna, int ocupacaoAmbiente, String statusEquipamento) {
        this.id = id;
        this.consumoEnergia = consumoEnergia;
        this.consumoAgua = consumoAgua;
        this.temperaturaInterna = temperaturaInterna;
        this.ocupacaoAmbiente = ocupacaoAmbiente;
        this.statusEquipamento = statusEquipamento;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getConsumoEnergia() { return consumoEnergia; }
    public void setConsumoEnergia(double consumoEnergia) { this.consumoEnergia = consumoEnergia; }

    public double getConsumoAgua() { return consumoAgua; }
    public void setConsumoAgua(double consumoAgua) { this.consumoAgua = consumoAgua; }

    public double getTemperaturaInterna() { return temperaturaInterna; }
    public void setTemperaturaInterna(double temperaturaInterna) { this.temperaturaInterna = temperaturaInterna; }

    public int getOcupacaoAmbiente() { return ocupacaoAmbiente; }
    public void setOcupacaoAmbiente(int ocupacaoAmbiente) { this.ocupacaoAmbiente = ocupacaoAmbiente; }

    public String getStatusEquipamento() { return statusEquipamento; }
    public void setStatusEquipamento(String statusEquipamento) { this.statusEquipamento = statusEquipamento; }

    public void exibirDados() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "SensorIoT [ID=" + id + ", Consumo Energia=" + consumoEnergia + " kWh, Consumo Água=" + consumoAgua +
                "L, Temp Interna=" + temperaturaInterna + "°C, Ocupação=" + ocupacaoAmbiente + ", Status=" + statusEquipamento + "]";
    }
}