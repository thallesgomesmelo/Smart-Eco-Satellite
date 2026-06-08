package service;

import model.SensorIoT;
import java.util.ArrayList;

public class SensorIoTService {
    private final ArrayList<SensorIoT> lista = new ArrayList<>();

    public void cadastrar(SensorIoT objeto) {
        lista.add(objeto);
    }

    public ArrayList<SensorIoT> listar() {
        return lista;
    }

    public SensorIoT buscarPorId(int id) {
        for (SensorIoT s : lista) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public boolean atualizar(int id, SensorIoT novoObjeto) {
        SensorIoT antigo = buscarPorId(id);
        if (antigo != null) {
            antigo.setConsumoEnergia(novoObjeto.getConsumoEnergia());
            antigo.setConsumoAgua(novoObjeto.getConsumoAgua());
            antigo.setTemperaturaInterna(novoObjeto.getTemperaturaInterna());
            antigo.setOcupacaoAmbiente(novoObjeto.getOcupacaoAmbiente());
            antigo.setStatusEquipamento(novoObjeto.getStatusEquipamento());
            return true;
        }
        return false;
    }

    public boolean remover(int id) {
        SensorIoT s = buscarPorId(id);
        if (s != null) {
            return lista.remove(s);
        }
        return false;
    }
}