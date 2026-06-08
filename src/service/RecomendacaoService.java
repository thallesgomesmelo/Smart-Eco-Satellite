package service;

import model.Recomendacao;
import java.util.ArrayList;

public class RecomendacaoService {
    private final ArrayList<Recomendacao> lista = new ArrayList<>();

    public void cadastrar(Recomendacao objeto) {
        lista.add(objeto);
    }

    public ArrayList<Recomendacao> listar() {
        return lista;
    }

    public Recomendacao buscarPorId(int id) {
        for (Recomendacao r : lista) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    public boolean atualizar(int id, Recomendacao novoObjeto) {
        Recomendacao antigo = buscarPorId(id);
        if (antigo != null) {
            antigo.setDescricao(novoObjeto.getDescricao());
            antigo.setPrioridade(novoObjeto.getPrioridade());
            return true;
        }
        return false;
    }

    public boolean remover(int id) {
        Recomendacao r = buscarPorId(id);
        if (r != null) {
            return lista.remove(r);
        }
        return false;
    }
}