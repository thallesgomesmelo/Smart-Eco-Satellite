package model;

public class Ambiente {
    private int id;
    private String nome;
    private String tipoAmbiente;
    private int quantidadeFuncionarios;
    private double areaM2;

    public Ambiente(int id, String nome, String tipoAmbiente, int quantidadeFuncionarios, double areaM2) {
        this.id = id;
        this.nome = nome;
        this.tipoAmbiente = tipoAmbiente;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.areaM2 = areaM2;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTipoAmbiente() { return tipoAmbiente; }
    public void setTipoAmbiente(String tipoAmbiente) { this.tipoAmbiente = tipoAmbiente; }

    public int getQuantidadeFuncionarios() { return quantidadeFuncionarios; }
    public void setQuantidadeFuncionarios(int quantidadeFuncionarios) { this.quantidadeFuncionarios = quantidadeFuncionarios; }

    public double getAreaM2() { return areaM2; }
    public void setAreaM2(double areaM2) { this.areaM2 = areaM2; }

    public void exibirInformacoes() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Ambiente [ID=" + id + ", Nome=" + nome + ", Tipo=" + tipoAmbiente +
                ", Funcionários=" + quantidadeFuncionarios + ", Área=" + areaM2 + "m²]";
    }
}