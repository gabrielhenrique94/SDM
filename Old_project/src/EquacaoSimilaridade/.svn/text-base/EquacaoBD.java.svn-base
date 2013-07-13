/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EquacaoSimilaridade;

import DAO.Relacoes.SintomaPesoDAO;
import DAO.Relacoes.SintomaCasoDAO;
import DAO.CasoDAO;
import ProcessosBD.*;
import java.util.*;

/**
 *
 * @author Gabriel
 */
public class EquacaoBD {

    public static ArrayList<CasoSimilar> BuscaSimilares(Caso caso, int numeroCasos) {
        CasoDAO dao = new CasoDAO();
        ArrayList<SintomaPeso> sintomas = caso.getSintomas();
        ArrayList<CasoSimilar> casosRetorno = new ArrayList<CasoSimilar>();
        ControladorSimilaridade controlador = new ControladorSimilaridade(caso);
        if (!sintomas.isEmpty()) {
            ArrayList<Caso> casos = dao.selectSintoma(sintomas.get(0).getSintoma());
            if (sintomas.size() > 1) {
                Iterator iterator = caso.getSintomas().iterator();
                while (iterator.hasNext()) {
                    SintomaPeso sintoma = (SintomaPeso) iterator.next();
                        casos = filtraCasos(casos, sintoma);
                }
            }
            if (numeroCasos > 0) {
                casosRetorno = controlador.similaridade(casos, numeroCasos);
                return casosRetorno;
            } else {
                casosRetorno = controlador.similaridade(casos);
                return casosRetorno;
            }
        }
        return casosRetorno;
    }

    public static ArrayList<Caso> filtraCasos(ArrayList<Caso> casos, SintomaPeso sintoma) {
        ArrayList<Caso> retorno = casos;
        for (int a = 0; a < casos.size(); a++) {
            boolean temSintoma = retorno.get(a).getSintomas().contains(sintoma);
            if (!temSintoma) {
                retorno.remove(a);
            }
        }
        return retorno;
    }

    public static void gravaCasoBD(Caso caso) {
        CasoDAO dao = new CasoDAO();
        dao.incluir(caso);
        dao.select(caso);

        ArrayList<SintomaPeso> sintomas = caso.getSintomas();
        for (SintomaPeso s : sintomas) {
            gravaSintoma(s, caso);
        }
    }

    public static void gravaSintoma(SintomaPeso sintoma, Caso caso) {
        SintomaPesoDAO dao = new SintomaPesoDAO();
        if (dao.existeSintoma(sintoma)) {
            sintoma.setPesoClinico(sintoma.getPesoClinico() + 1);
            dao.alterar(sintoma);
        } else {
            dao.incluir(sintoma);
        }
        SintomaCasoDAO dao2 = new SintomaCasoDAO();
        SintomaCaso sintomaCaso = new SintomaCaso(sintoma.getSintoma(), caso);
        dao2.incluir(sintomaCaso);

    }
}
