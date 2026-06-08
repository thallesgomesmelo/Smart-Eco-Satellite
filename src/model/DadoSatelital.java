package model;

public class DadoSatelital {
    private int id;
    private double temperaturaExterna;
    private double umidade;
    private double indiceUV;
    private double radiacaoSolar;
    private String condicaoClimatica;

    public DadoSatelital(int id, double temperaturaExterna, double umidade, double indiceUV, double radiacaoSolar, String condicaoClimatica) {
        this.id = id;
        this.temperaturaExterna = temperaturaExterna;
        this.umidade = umidade;
        this.indiceUV = indiceUV;
        this.radiacaoSolar = radiacaoSolar;
        this.condicaoClimatica = condicaoClimatica;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getTemperaturaExterna() { return temperaturaExterna; }
    public void setTemperaturaExterna(double temperaturaExterna) { this.temperaturaExterna = temperaturaExterna; }

    public double getUmidade() { return umidade; }
    public void setUmidade(double umidade) { this.umidade = umidade; }

    public double getIndiceUV() { return indiceUV; }
    public void setIndiceUV(double indiceUV) { this.indiceUV = indiceUV; }

    public double getRadiacaoSolar() { return radiacaoSolar; }
    public void setRadiacaoSolar(double radiacaoSolar) { this.radiacaoSolar = radiacaoSolar; }

    public String getCondicaoClimatica() { return condicaoClimatica; }
    public void setCondicaoClimatica(String condicaoClimatica) { this.condicaoClimatica = condicaoClimatica; }

    public void exibirDados() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "DadoSatelital [ID=" + id + ", Temp Externa=" + temperaturaExterna + "°C, Umidade=" + umidade +
                "%, UV=" + indiceUV + ", Radiação Solar=" + radiacaoSolar + " W/m², Clima=" + condicaoClimatica + "]";
    }
}