package model;

public class Recomendacao {
    private int id;
    private String descricao;
    private String prioridade;

    public Recomendacao(int id, String descricao, String prioridade) {
        this.id = id;
        this.descricao = descricao;
        this.prioridade = prioridade;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getPrioridade() { return prioridade; }
    public void setPrioridade(String prioridade) { this.prioridade = prioridade; }

    public void exibirRecomendacao() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Recomendacao [ID=" + id + ", Descrição=" + descricao + ", Prioridade=" + prioridade + "]";
    }
}