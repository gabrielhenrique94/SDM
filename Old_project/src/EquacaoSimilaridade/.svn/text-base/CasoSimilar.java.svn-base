package EquacaoSimilaridade;

import ProcessosBD.*;

/**
 *
 * @author Gabriel
 */
public class CasoSimilar extends Caso implements Comparable<CasoSimilar> {

    private double similaridade;

    public double getSimilaridade() {
        return similaridade;
    }

    public void setSimilaridade(double similaridade) {
        this.similaridade = similaridade;
    }

    public CasoSimilar() {
    }

    public CasoSimilar(Caso caso, double similaridade) {
        setSimilaridade(similaridade);
        setCodigo(caso.getCodigo());
        setNome(caso.getNome());
        setMedicacoes(caso.getMedicacoes());
        setAltura(caso.getAltura());
        setIdade(caso.getIdade());
        setPeso(caso.getPeso());
        setDoenca(caso.getDoenca());
        setMedico(caso.getMedico());
        setSintomas(caso.getSintomas());

    }

    public CasoSimilar(double similaridade) {
        this.similaridade = similaridade;
    }

    @Override
    public String toString() {
        String retorno = this.getClass().toString() + "@[doença = " + this.getDoenca().getNome() + " Similaridade = " + this.getSimilaridade() + "]";
        return retorno;
    }

    @Override
    public int compareTo(CasoSimilar o) {
        if (similaridade == o.getSimilaridade()) {
            return 0;
        } else {
            if (similaridade > o.getSimilaridade()) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
