package service;

import model.DadoSatelital;
import java.util.ArrayList;

public class DadoSatelitalService {
    private final ArrayList<DadoSatelital> lista = new ArrayList<>();

    public void cadastrar(DadoSatelital objeto) {
        lista.add(objeto);
    }

    public ArrayList<DadoSatelital> listar() {
        return lista;
    }

    public DadoSatelital buscarPorId(int id) {
        for (DadoSatelital d : lista) {
            if (d.getId() == id) {
                return d;
            }
        }
        return null;
    }

    public boolean atualizar(int id, DadoSatelital novoObjeto) {
        DadoSatelital antigo = buscarPorId(id);
        if (antigo != null) {
            antigo.setTemperaturaExterna(novoObjeto.getTemperaturaExterna());
            antigo.setUmidade(novoObjeto.getUmidade());
            antigo.setIndiceUV(novoObjeto.getIndiceUV());
            antigo.setRadiacaoSolar(novoObjeto.getRadiacaoSolar());
            antigo.setCondicaoClimatica(novoObjeto.getCondicaoClimatica());
            return true;
        }
        return false;
    }

    public boolean remover(int id) {
        DadoSatelital d = buscarPorId(id);
        if (d != null) {
            return lista.remove(d);
        }
        return false;
    }
}