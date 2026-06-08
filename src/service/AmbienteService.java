package service;

import model.Ambiente;
import java.util.ArrayList;

public class AmbienteService {
    private final ArrayList<Ambiente> lista = new ArrayList<>();

    public void cadastrar(Ambiente objeto) {
        lista.add(objeto);
    }

    public ArrayList<Ambiente> listar() {
        return lista;
    }

    public Ambiente buscarPorId(int id) {
        for (Ambiente a : lista) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public boolean atualizar(int id, Ambiente novoObjeto) {
        Ambiente antigo = buscarPorId(id);
        if (antigo != null) {
            antigo.setNome(novoObjeto.getNome());
            antigo.setTipoAmbiente(novoObjeto.getTipoAmbiente());
            antigo.setQuantidadeFuncionarios(novoObjeto.getQuantidadeFuncionarios());
            antigo.setAreaM2(novoObjeto.getAreaM2());
            return true;
        }
        return false;
    }

    public boolean remover(int id) {
        Ambiente a = buscarPorId(id);
        if (a != null) {
            return lista.remove(a);
        }
        return false;
    }
}