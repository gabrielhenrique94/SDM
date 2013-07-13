package EquacaoSimilaridade;

import ProcessosBD.*;
import java.util.*;

public class ControladorSimilaridade {

    private Caso caso1;

    public ControladorSimilaridade(Caso caso1) {
        this.caso1 = caso1;
    }

    public double similaridade(Caso caso2) {
        double soma = 0;
        double somaPesos = 0;
        for (int a = 0; a < caso2.getSintomas().size(); a++) {
            somaPesos += caso2.getSintomas().get(a).getPesoClinico();
                if (caso1.getSintomas().contains(caso2.getSintomas().get(a))) {
                soma += caso2.getSintomas().get(a).getPesoClinico();
            }
        }
        return (soma / somaPesos) * 100;
    }

    public ArrayList<CasoSimilar> similaridade(ArrayList<Caso> casos, int maximoDeCasos) {
        HashMap<Integer, CasoSimilar> filtroCasos = new HashMap<Integer, CasoSimilar>();
        for (int a = 0; a < casos.size(); a++) {
            double similaridade = similaridade(casos.get(a));
            if (filtroCasos.containsKey(casos.get(a).getDoenca().getCodigo())) {
                if (filtroCasos.get(casos.get(a).getDoenca().getCodigo()).getSimilaridade() < similaridade) {
                    CasoSimilar casoSimilar = new CasoSimilar(casos.get(a), similaridade);
                    filtroCasos.put(casos.get(a).getDoenca().getCodigo(), casoSimilar);
                }
            } else {
                CasoSimilar casoSimilar = new CasoSimilar(casos.get(a), similaridade);
                filtroCasos.put(casos.get(a).getDoenca().getCodigo(), casoSimilar);
            }
        }
        TreeSet<CasoSimilar> ordenadorCasos = new TreeSet<CasoSimilar>();
        ordenadorCasos.addAll(filtroCasos.values());
        Iterator casosOrdenados = ordenadorCasos.iterator();
        ArrayList<CasoSimilar> retorno = new ArrayList<CasoSimilar>();
        for (int b = 0; (casosOrdenados.hasNext() && (b < maximoDeCasos)); b++) {
            retorno.add((CasoSimilar) casosOrdenados.next());
        }
        return retorno;
    }

    public ArrayList<CasoSimilar> similaridade(ArrayList<Caso> casos) {
        HashMap<Integer, CasoSimilar> filtroCasos = new HashMap<Integer, CasoSimilar>();
        for (int a = 0; a < casos.size(); a++) {
            double similaridade = similaridade(casos.get(a));
            if (filtroCasos.containsKey(casos.get(a).getDoenca().getCodigo())) {
                if (filtroCasos.get(casos.get(a).getDoenca().getCodigo()).getSimilaridade() < similaridade) {
                    CasoSimilar casoSimilar = new CasoSimilar(casos.get(a), similaridade);
                    filtroCasos.put(casos.get(a).getDoenca().getCodigo(), casoSimilar);
                }
            } else {
                CasoSimilar casoSimilar = new CasoSimilar(casos.get(a), similaridade);
                filtroCasos.put(casos.get(a).getDoenca().getCodigo(), casoSimilar);
            }

        }
        TreeSet<CasoSimilar> ordenadorCasos = new TreeSet<CasoSimilar>();
        ordenadorCasos.addAll(filtroCasos.values());
        Iterator casosOrdenados = ordenadorCasos.iterator();
        ArrayList<CasoSimilar> retorno = new ArrayList<CasoSimilar>();
        for (int b = 0; casosOrdenados.hasNext(); b++) {
            retorno.add((CasoSimilar) casosOrdenados.next());
        }
        return retorno;
    }
}
